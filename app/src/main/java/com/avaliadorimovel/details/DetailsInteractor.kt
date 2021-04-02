package com.avaliadorimovel.details

import com.avaliadorimovel.details.interfaces.InterfaceDetailsInteractor
import com.avaliadorimovel.spinnerlibrary.SpinnerLayout
import com.sugarya.footer.SpinnerLinearFooter
import

class DetailsInteractor(): InterfaceDetailsInteractor {

    interface calculationSuccess {
        fun onError()
        fun onSuccess()
    }

    override fun numberParkingSpaces(spinnerLinearFooter: SpinnerLinearFooter, spinnerLayout: SpinnerLayout) {

    }

    override fun finishPattern() {
        TODO("Not yet implemented")
    }

    override fun conservation_state() {
        TODO("Not yet implemented")
    }
}