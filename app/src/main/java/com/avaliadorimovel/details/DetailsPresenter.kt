package com.avaliadorimovel.details

import com.avaliadorimovel.details.interfaces.InterfaceDetailsInteractor
import com.avaliadorimovel.details.interfaces.InterfaceDetailsPresenter
import com.avaliadorimovel.spinnerlibrary.SpinnerLayout
import com.sugarya.footer.SpinnerLinearFooter

class DetailsPresenter (var interfaceDetailsInteractor: InterfaceDetailsInteractor): InterfaceDetailsPresenter {

    override fun carregarSpinnersParkingSpace(spinnerLinearFooter: SpinnerLinearFooter, spinnerLayout: SpinnerLayout) {
        var listSpinner = listOf(spinnerLinearFooter, spinnerLayout)
        interfaceDetailsInteractor.dataNumberParkingSpaces(listSpinner)
    }

    override fun carregarFinishPattern() {
        interfaceDetailsInteractor.dataFinishPattern()
    }

    override fun carregarConservationState() {
        interfaceDetailsInteractor.dataConservationState()
    }


}