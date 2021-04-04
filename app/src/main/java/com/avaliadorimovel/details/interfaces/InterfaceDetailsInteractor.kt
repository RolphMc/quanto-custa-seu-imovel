package com.avaliadorimovel.details.interfaces

import android.widget.RelativeLayout
import com.avaliadorimovel.spinnerlibrary.SpinnerLayout

interface InterfaceDetailsInteractor {
    fun dataNumberParkingSpaces(spinnerLinearFooter: List<RelativeLayout>, spinnerLayout: SpinnerLayout)
    fun dataFinishPattern()
    fun dataConservationState()
}