package com.avaliadorimovel.details

import android.content.Context
import android.widget.Spinner
import com.avaliadorimovel.details.interfaces.InterfaceDetailsInteractor
import com.avaliadorimovel.details.interfaces.InterfaceDetailsPresenter
import com.avaliadorimovel.details.repository.SampleItem

class DetailsPresenter (var detailsInteractor: InterfaceDetailsInteractor): InterfaceDetailsPresenter {

    override fun carregarSpinnersParkingSpace(context: Context, spinner: Spinner){
        detailsInteractor.dataNumberParkingSpaces(context, spinner)
    }

    override fun carregarFinishPattern(context: Context, spinner: Spinner) {
        detailsInteractor.dataFinishPattern(context, spinner)
    }

    override fun carregarConservationState(context: Context, spinner: Spinner) {
        detailsInteractor.dataConservationState(context, spinner)
    }

    override fun takeSamples(context: Context, sampleList: ArrayList<SampleItem>){
        detailsInteractor.thereBlankfields(context, sampleList)
        detailsInteractor.calculateFactors(sampleList)
    }

    override fun onError(context: Context) {

    }

    override fun onSuccess() {
        TODO("Not yet implemented")
    }

}