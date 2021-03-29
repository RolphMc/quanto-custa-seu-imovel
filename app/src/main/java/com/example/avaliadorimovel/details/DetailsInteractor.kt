package com.example.avaliadorimovel.details

import com.example.avaliadorimovel.details.interfaces.InterfaceDetailsInteractor
import com.example.avaliadorimovel.details.model.SpinnerLinearSpinner
import com.example.avaliadorimovel.details.utils.SpinnerLayout

class DetailsInteractor(): InterfaceDetailsInteractor {

    interface calculationSuccess {
        fun onError()
        fun onSuccess()
    }

    override fun numberParkingSpaces(spinnerLinearFooter: SpinnerLinearSpinner, spinnerLayout: SpinnerLayout) {
        TODO("Not yet implemented")
    }

    override fun finishPattern() {
        TODO("Not yet implemented")
    }

    override fun conservation_state() {
        TODO("Not yet implemented")
    }
}