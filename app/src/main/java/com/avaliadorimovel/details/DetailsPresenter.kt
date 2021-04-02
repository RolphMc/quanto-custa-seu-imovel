package com.avaliadorimovel.details

import com.avaliadorimovel.details.interfaces.InterfaceDetailsInteractor
import com.avaliadorimovel.details.interfaces.InterfaceDetailsPresenter

class DetailsPresenter (var interfaceDetailsInteractor: InterfaceDetailsInteractor): InterfaceDetailsPresenter {

    override fun carregarSpinners() {
        interfaceDetailsInteractor.numberParkingSpaces()
        interfaceDetailsInteractor.finishPattern()
        interfaceDetailsInteractor.conservation_state()
    }
}