package com.example.avaliadorimovel.details

import com.example.avaliadorimovel.details.interfaces.InterfaceDetailsInteractor
import com.example.avaliadorimovel.details.interfaces.InterfaceDetailsPresenter

class DetailsPresenter (var interfaceDetailsInteractor: InterfaceDetailsInteractor): InterfaceDetailsPresenter {

    override fun carregarSpinners() {
        interfaceDetailsInteractor.numberParkingSpaces()
        interfaceDetailsInteractor.finishPattern()
        interfaceDetailsInteractor.conservation_state()
    }
}