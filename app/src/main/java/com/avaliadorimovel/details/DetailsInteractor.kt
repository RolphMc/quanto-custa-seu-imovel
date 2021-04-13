package com.avaliadorimovel.details

import com.avaliadorimovel.details.interfaces.InterfaceDetailsInteractor
import com.avaliadorimovel.details.interfaces.InterfaceDetailsPresenter
import com.avaliadorimovel.details.interfaces.models.InterfaceFactorList
import com.avaliadorimovel.details.repository.*
import com.avaliadorimovel.details.service.ConversionHelper
import kotlin.math.roundToInt


class DetailsInteractor (val presenter: InterfaceDetailsPresenter): InterfaceDetailsInteractor {

    private val conversionHelper = ConversionHelper()

    override fun convertPatternFactor(samplePattern: String): Double {
        return conversionHelper.patternFactor(samplePattern)
    }

    override fun convertConservationFactor(sampleConservation: String): Double {
        return conversionHelper.conservationFactor(sampleConservation)
    }

    override fun convertParkingFactor(sampleParking: Int): Int {
        return conversionHelper.parkingFactor(sampleParking)
    }

    override fun calculateFactors(sampleList: ArrayList<SampleItem>): MutableList<InterfaceFactorList> {

        // Fatorar diferenças características das amostras
        val paradgm: SampleItem = sampleList[0] //paradgma
        var factorList = mutableListOf<InterfaceFactorList>()

        sampleList.forEach { sample ->
            factorList.add(
                    FactorList(
                            squareMeterValue = sample.costSample / sample.areaSample,
                            areaFactor = balancingDiffArea(sample.areaSample, paradgm.areaSample),
                            parkingFactor = paradgm.parkingSpace.toDouble()/sample.parkingSpace.toDouble(),
                            finishingFactor = paradgm.finishPattern / sample.finishPattern,
                            stateFactor = paradgm.conservationState / sample.conservationState
                    )
            )
        }
        return factorList
    }

    override fun calculateStandardDeviation(homogenizeFactorList: MutableList<HomogenizeFactorList>, arithmeticMean: Double): Double {
        val pow = mutableListOf<Double>()

        homogenizeFactorList.forEach { factor ->
            pow.add(Math.pow((arithmeticMean.minus(factor.sampleHomogeneized)), 2.0))
        }

        return Math.sqrt(pow.sum().div(homogenizeFactorList.size-1))
    }

    override fun calcutaleCoefficienteOfVariation(standardDeviation: Double, arithmeticMean: Double): Double {
        return standardDeviation.div(arithmeticMean)
    }

    override fun calculateConfidenceInterval(standardDeviation: Double, tStudentGrade2: Double, size: Int, arithmeticMean: Double): ConfidenceIntervalData {

        val result = tStudentGrade2*(standardDeviation/Math.pow((size-1.0), 0.5))
        val higher = arithmeticMean + result
        val bottom = arithmeticMean - result

        return ConfidenceIntervalData(result, higher, bottom)
    }

    override fun roundValue(value: Double): Double {
        return value.roundToInt().toDouble()
    }

    override fun checkReliability(higherConfidenceIinterval: Double): Double {
        return if(higherConfidenceIinterval > 0.15) 1.15 else higherConfidenceIinterval
    }

    override fun calculateValueOfThePropety(unitaryValue: Double, areaSample: Int, reliability: Double): Double {
        return unitaryValue * areaSample * reliability
    }

    override fun calculateTStudentG2(tStudent: Int): Double {
        return conversionHelper.tStudentFactor(tStudent)
    }

    override fun homogenizeTheSample(factorList: MutableList<InterfaceFactorList>): MutableList<HomogenizeFactorList> {
        var homogenizedFactorList = mutableListOf<HomogenizeFactorList>()

        factorList.drop(1).forEach { factor ->
            homogenizedFactorList.add(
                    HomogenizeFactorList((
                            factor.squareMeterValue *0.9)
                            * (1+
                            (factor.finishingFactor-1)
                            +
                            (factor.stateFactor-1)
                            +
                            (factor.parkingFactor-1)
                            +
                            (factor.areaFactor-1))
                    )
            )
        }
        return homogenizedFactorList
    }

    override fun getArithmeticMean(homogenizeFactorList: MutableList<HomogenizeFactorList>): Double {
        var arithmeticMean = 0.0

        homogenizeFactorList.forEach { factor ->
            arithmeticMean = arithmeticMean.plus(factor.sampleHomogeneized)
        }
        arithmeticMean = (arithmeticMean / homogenizeFactorList.size)

        return arithmeticMean
    }

    override fun calculateTheLimits(arithmeticMean: Double): LimitsData {
        return LimitsData(arithmeticMean*1.3, arithmeticMean*0.7)
    }

    private fun balancingDiffArea(sample: Int, paradgm: Int): Float {
        var compare: Float = sample.toFloat()/paradgm.toFloat()
        if(compare <= 0.7 || compare >= 1.3){
            return Math.pow(compare.toDouble(), 0.125).toFloat()
        }else{
            return Math.pow(compare.toDouble(), 0.25).toFloat()
        }
    }

    override fun thereBlankfields(sampleList: ArrayList<SampleItem>): Boolean {
        return sampleList.any {
            return it.costSample.equals(0f) ||
                    it.areaSample.equals(0) ||
                    it.parkingSpace.equals(0) ||
                    it.finishPattern.equals("") ||
                    it.conservationState.equals("")
        }
    }
}