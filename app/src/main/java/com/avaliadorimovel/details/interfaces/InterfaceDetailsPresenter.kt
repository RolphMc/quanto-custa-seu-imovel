package com.avaliadorimovel.details.interfaces

import android.content.Context
import android.widget.Spinner
import com.avaliadorimovel.details.repository.SampleItem

interface InterfaceDetailsPresenter {
    fun carregarSpinnersParkingSpace(context: Context, spinner: Spinner)
    fun carregarFinishPattern(context: Context, spinner: Spinner)
    fun carregarConservationState(context: Context, spinner: Spinner)
    fun takeSamples(context: Context, sampleList: ArrayList<SampleItem>)

    fun onError(context: Context)
    fun onSuccess()
}