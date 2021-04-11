package com.avaliadorimovel.details

import com.avaliadorimovel.details.interfaces.InterfaceDetailsInteractor
import com.avaliadorimovel.details.interfaces.InterfaceDetailsPresenter
import com.avaliadorimovel.details.interfaces.repository.InterfaceFactorList
import com.avaliadorimovel.details.repository.FactorList
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
        factorList.size

        // [CRIAR] lógica do cálculo do fator área
        //Fator área = áreaAmostra / áreaMotivo
        // se < 0.7 ou >= 1.3 = Fator área ^ 0.125
        // se não Fator área ^ 0.25

        //        var listFactor = arrayListOf(
        //                ListFactor(sampleList[0].finishPattern/sampleList[1].finishPattern) //Sample 1
        //        )

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
