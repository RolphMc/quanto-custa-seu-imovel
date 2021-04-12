package com.avaliadorimovel.details

import com.avaliadorimovel.details.interfaces.InterfaceDetailsInteractor
import com.avaliadorimovel.details.interfaces.InterfaceDetailsPresenter
import com.avaliadorimovel.details.interfaces.repository.InterfaceFactorList
import com.avaliadorimovel.details.repository.FactorList
import com.avaliadorimovel.details.repository.HomogenizedFactorList
import com.avaliadorimovel.details.repository.SampleItem


class DetailsInteractor (val presenter: InterfaceDetailsPresenter): InterfaceDetailsInteractor {

    override fun calculateFactors(sampleList: ArrayList<SampleItem>) {
        sampleList.size

        // [FEITO] converter em fatores itens dos Spinners

        // [FEITO] Fatorar diferenças características das amostras
        val paradgm: SampleItem = sampleList[0] //paradgma
        var factorList = mutableListOf<InterfaceFactorList>()

        (1..sampleList.size-1).forEach { sample ->
            factorList.add(
                    FactorList(
                    squareMeterValue = sampleList[sample].costSample / sampleList[sample].areaSample,
                    areaFactor = balancingDiffArea(sampleList[sample].areaSample, paradgm.areaSample),
                    parkingFactor = sampleList[sample].parkingSpace.toFloat() / paradgm.parkingSpace.toFloat(),
                    finishingFactor = sampleList[sample].finishPattern / paradgm.finishPattern,
                    stateFactor = sampleList[sample].conservationState / paradgm.conservationState
                    )
            )
        }

        // [FEITO] Homogeinizar amostras
        var homogenizedFactorList = arrayListOf<HomogenizedFactorList>()

        (0..factorList.size-1).forEach { sample ->
            homogenizedFactorList.add(
                    HomogenizedFactorList(
                        sampleHomogeneized = homogeneized(factorList[sample])
                    )
            )
        }

        // [FEITO] tirar média aritmética
        var arithmeticAverage = 0.0

        for(i in 0..homogenizedFactorList.size-1) {
            arithmeticAverage = arithmeticAverage.plus(homogenizedFactorList[i].sampleHomogeneized)
        }
        arithmeticAverage = (arithmeticAverage / homogenizedFactorList.size)

        // [FEITO] limites
        var upperLimite: Double = arithmeticAverage*1.3
        var lowerLimite: Double = arithmeticAverage*0.7

        //[CRIAR] Desvio padrão
        var standardDeviation = calculatStandardDeviation(homogenizedFactorList, arithmeticAverage)

        standardDeviation.equals("")

    }

    private fun calculatStandardDeviation(homogenizedFactorList: ArrayList<HomogenizedFactorList>, arithmeticAverage: Double): Double {
        return Math.sqrt(
            (
                    Math.pow((arithmeticAverage.minus(homogenizedFactorList[0].sampleHomogeneized)), 2.0) +
                            Math.pow((arithmeticAverage.minus(homogenizedFactorList[1].sampleHomogeneized)), 2.0) +
                            Math.pow((arithmeticAverage.minus(homogenizedFactorList[2].sampleHomogeneized)), 2.0)
                    )/3)
    }

    private fun homogeneized(interfaceFactorList: InterfaceFactorList): Float {
        return (
                (interfaceFactorList.squareMeterValue*0.9)
                        *
                        (1+(interfaceFactorList.finishingFactor-1))
                                +
                                (interfaceFactorList.stateFactor-1)
                                    +
                                    (interfaceFactorList.parkingFactor-1)
                                        +
                                        (interfaceFactorList.areaFactor-1)).toFloat()
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