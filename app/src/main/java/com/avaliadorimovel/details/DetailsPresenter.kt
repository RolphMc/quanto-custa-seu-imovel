package com.avaliadorimovel.details

import com.avaliadorimovel.details.interfaces.InterfaceDetailsInteractor
import com.avaliadorimovel.details.interfaces.InterfaceDetailsPresenter
import com.avaliadorimovel.details.repository.SampleItem

class DetailsPresenter (val view: DetailsActivity): InterfaceDetailsPresenter {

    var detailsInteractor: InterfaceDetailsInteractor

    init {
        detailsInteractor = DetailsInteractor(this)
    }

    override fun dataValidation(sampleList: ArrayList<SampleItem>){
        if(detailsInteractor.thereBlankfields(sampleList)){
            view.onValidationError()
        }
    }

    override fun parkingFactor(sampleParking: Int): Int {
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

    override fun patternFactor(samplePattern: String): Float{
        return when (samplePattern) {
            "Econômico" -> 0.7f
            "Simples" -> 0.8375f
            "Normal" -> 0.975f
            "Superior" -> 1.1125f
            "Alto" -> 1.25f
            else -> 0f
        }
    }

    override fun conservationFactor(sampleConservation: String): Float{
        return when (sampleConservation) {
            "Ótimo" -> 1f
            "Bom" -> 0.95f
            "Razoável" -> 0.90f
            "Ruim" -> 0.85f
            "Demolição" -> 0.8f
            else -> 0f
        }
    }

    override fun takeSamples(sampleList: ArrayList<SampleItem>){
         val result = detailsInteractor.calculateFactors(sampleList)

        //view.navigateToResult(result)
    }

    override fun onError() {

    }

    override fun onSuccess() {
        TODO("Not yet implemented")
    }

}