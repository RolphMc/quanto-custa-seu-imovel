package com.avaliadorimovel.details.interfaces

import android.content.Context
import android.widget.Spinner

interface InterfaceDetailsPresenter {
    fun carregarSpinnersParkingSpace(context: Context, spinner: Spinner)
    fun carregarFinishPattern()
    fun carregarConservationState()
}