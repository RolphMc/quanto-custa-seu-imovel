package com.avaliadorimovel.details.interfaces

import com.avaliadorimovel.details.repository.SampleItem

interface InterfaceDetailsPresenter {
    fun takeSamples(sampleList: ArrayList<SampleItem>)

    fun onError()
    fun onSuccess()
    fun dataValidation(sampleList: ArrayList<SampleItem>)
    fun returnParkingFactor(sampleParking: Int): Int
    fun finishingPatternFactor(samplePattern: String): Float
    fun finishingConservationFactor(samplePattern: String): Float
}