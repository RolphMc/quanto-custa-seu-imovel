package com.avaliadorimovel.details.interfaces

import android.content.Context
import android.widget.Spinner
import com.avaliadorimovel.details.repository.SampleItem

interface InterfaceDetailsInteractor {
    //controles da view
    fun dataNumberParkingSpaces(context: Context, spinner: Spinner)
    fun dataFinishPattern(context: Context, spinner: Spinner)
    fun dataConservationState(context: Context, spinner: Spinner)

    //calculos
    fun calculateFactors(sampleList: ArrayList<SampleItem>)

    //tratamento de erros
    fun thereBlankfields(context: Context, sampleList: ArrayList<SampleItem>)
}