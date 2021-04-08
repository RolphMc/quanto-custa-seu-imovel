package com.avaliadorimovel.details

import com.avaliadorimovel.details.interfaces.InterfaceDetailsInteractor
import com.avaliadorimovel.details.interfaces.InterfaceDetailsPresenter
import com.avaliadorimovel.details.repository.SampleItem

class DetailsPresenter (val view: DetailsActivity): InterfaceDetailsPresenter {

    var detailsInteractor: InterfaceDetailsInteractor

    init {
        detailsInteractor = DetailsInteractor(this)
    }

    override fun takeSamples(sampleList: ArrayList<SampleItem>){
        if(detailsInteractor.thereBlankfields(sampleList)){
            view.onValidationError()
        }

        val result = detailsInteractor.calculateFactors(sampleList)
        //view.navigateToResult(result)
    }

    override fun onError() {

    }

    override fun onSuccess() {
        TODO("Not yet implemented")
    }

}