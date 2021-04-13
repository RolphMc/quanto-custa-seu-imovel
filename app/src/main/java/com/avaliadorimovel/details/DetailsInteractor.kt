package com.avaliadorimovel.details

import com.avaliadorimovel.details.interfaces.InterfaceDetailsInteractor
import com.avaliadorimovel.details.interfaces.InterfaceDetailsPresenter
import com.avaliadorimovel.details.interfaces.repository.InterfaceFactorList
import com.avaliadorimovel.details.repository.*
import kotlin.math.roundToInt


class DetailsInteractor (val presenter: InterfaceDetailsPresenter): InterfaceDetailsInteractor {

    override fun calculateFactors(sampleList: ArrayList<SampleItem>): MutableList<InterfaceFactorList> {

        // Fatorar diferenças características das amostras
        val paradgm: SampleItem = sampleList[0] //paradgma
        var factorList = mutableListOf<InterfaceFactorList>()

        (1..sampleList.size - 1).forEach { sample ->
            factorList.add(
                    FactorList(
                            squareMeterValue = sampleList[sample].costSample / sampleList[sample].areaSample,
                            areaFactor = balancingDiffArea(sampleList[sample].areaSample, paradgm.areaSample),
                            parkingFactor = paradgm.parkingSpace.toDouble()/sampleList[sample].parkingSpace.toDouble(),
                            finishingFactor = paradgm.finishPattern / sampleList[sample].finishPattern,
                            stateFactor = paradgm.conservationState / sampleList[sample].conservationState
                    )
            )
        }
        return factorList
    }

    override fun calculateStandardDeviation(homogenizeFactorList: MutableList<HomogenizeFactorList>, arithmeticMean: Double): Double {
        val pow = mutableListOf<Double>()

        (0..homogenizeFactorList.size-1).forEach { factor ->
            pow.add(Math.pow((arithmeticMean.minus(homogenizeFactorList[factor].sampleHomogeneized)), 2.0))
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
        return tStudent(tStudent)
    }

    private fun tStudent(tStudent: Int): Double {
        return when (tStudent){
            1 -> 3.078
            2 -> 1.886
            3 -> 1.638
            4 -> 1.533
            5 -> 1.476
            6 -> 1.440
            7 -> 1.415
            8 -> 1.397
            9 -> 1.383
            10 -> 1.372
            else -> 0.0
        }

    }

    override fun homogenizeTheSample(factorList: MutableList<InterfaceFactorList>): MutableList<HomogenizeFactorList> {
        var homogenizedFactorList = mutableListOf<HomogenizeFactorList>()

        (0..factorList.size-1).forEach { factor ->
            homogenizedFactorList.add(
                    HomogenizeFactorList((
                            factorList[factor].squareMeterValue *0.9)
                            *
                            (1+(factorList[factor].finishingFactor-1)
                            +
                            (factorList[factor].stateFactor-1)
                            +
                            (factorList[factor].parkingFactor-1)
                            +
                            (factorList[factor].areaFactor-1))
                    )
            )
        }
        return homogenizedFactorList
    }

    override fun getArithmeticMean(homogenizeFactorList: MutableList<HomogenizeFactorList>): Double {
        var arithmeticMean = 0.0

        for(i in 0..homogenizeFactorList.size-1) {
            arithmeticMean = arithmeticMean.plus(homogenizeFactorList[i].sampleHomogeneized)
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

    override fun convertPatternFactor(samplePattern: String): Double {
        return when (samplePattern) {
            "Econômico" -> 0.7
            "Simples" -> 0.8375
            "Normal" -> 0.975
            "Superior" -> 1.1125
            "Alto" -> 1.25
            else -> 0.0
        }
    }

    override fun convertConservationFactor(sampleConservation: String): Double {
        return when (sampleConservation) {
            "Ótimo" -> 1.0
            "Bom" -> 0.95
            "Razoável" -> 0.90
            "Ruim" -> 0.85
            "Demolição" -> 0.8
            else -> 0.0
        }
    }

    override fun convertParkingFactor(sampleParking: Int): Int {
        return when (sampleParking) {
            0 -> 95
            1 -> 100
            2 -> 105
            3 -> 110
            4 -> 115
            5 -> 120
            6 -> 125
            7 -> 130
            8 -> 135
            9 -> 140
            else -> 0
        }
    }
}