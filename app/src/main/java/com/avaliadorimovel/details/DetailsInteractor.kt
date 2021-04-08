package com.avaliadorimovel.details

import com.avaliadorimovel.details.interfaces.InterfaceDetailsInteractor
import com.avaliadorimovel.details.interfaces.InterfaceDetailsPresenter
import com.avaliadorimovel.details.repository.SampleItem


class DetailsInteractor (val presenter: InterfaceDetailsPresenter): InterfaceDetailsInteractor {

    override fun calculateFactors(sampleList: ArrayList<SampleItem>) {

        // [CRIAR] converter em fatores itens dos Spinners

        // [CRIAR] lógica do cálculo do fator área
        //Fator área = áreaAmostra / áreaMotivo
        // se < 0.7 ou >= 1.3 = Fator área ^ 0.125
        // se não Fator área ^ 0.25

//        var listFactor = arrayListOf(
//                ListFactor(sampleList[0].finishPattern/sampleList[1].finishPattern) //Sample 1
//        )

    }

    override fun thereBlankfields(sampleList: ArrayList<SampleItem>): Boolean {
        return sampleList.any {
            return it.costSample == null ||
                    it.areaSample == null ||
                    it.parkingSpace == null ||
                    it.finishPattern == null ||
                    it.conservationState == null
        }
    }
}