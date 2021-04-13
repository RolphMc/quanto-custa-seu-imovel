package com.avaliadorimovel.details

import com.avaliadorimovel.details.interfaces.InterfaceDetailsInteractor
import com.avaliadorimovel.details.interfaces.InterfaceDetailsPresenter
import com.avaliadorimovel.details.interfaces.repository.InterfaceFactorList
import com.avaliadorimovel.details.repository.FactorList
import com.avaliadorimovel.details.repository.HomogenizeFactorList
import com.avaliadorimovel.details.repository.LimitesList
import com.avaliadorimovel.details.repository.SampleItem


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


//        return Math.sqrt(
//                (
//                        Math.pow((homogenizeFactorList[0].sampleHomogeneized.minus(arithmeticMean)), 2.0) +
//                        Math.pow((homogenizeFactorList[1].sampleHomogeneized).minus(arithmeticMean), 2.0) +
//                        Math.pow((homogenizeFactorList[2].sampleHomogeneized).minus(arithmeticMean), 2.0)
//                        )/3)
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

    override fun calculateTheLimits(arithmeticMean: Double): LimitesList {
        return LimitesList(arithmeticMean*1.3, arithmeticMean*0.7)
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