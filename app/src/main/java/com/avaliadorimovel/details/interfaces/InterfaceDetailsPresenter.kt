package com.avaliadorimovel.details.interfaces

import com.avaliadorimovel.details.repository.SampleItem

interface InterfaceDetailsPresenter {
    fun takeSamples(sampleList: ArrayList<SampleItem>)

    fun onError()
    fun onSuccess()
    fun dataValidation(sampleList: ArrayList<SampleItem>)
    fun treatParkingInput(sampleParking: Int): Int
    fun treatPatternInput(samplePattern: String): Double
    fun treatConservationInput(sampleConservation: String): Double
}