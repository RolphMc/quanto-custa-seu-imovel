package com.avaliadorimovel.details.interfaces

import com.avaliadorimovel.details.repository.SampleItem

interface InterfaceDetailsPresenter {
    fun takeSamples(sampleList: ArrayList<SampleItem>)

    fun onError()
    fun onSuccess()
    fun dataValidation(sampleList: ArrayList<SampleItem>)
    fun parkingFactor(sampleParking: Int): Int
    fun patternFactor(samplePattern: String): Float
    fun conservationFactor(sampleConservation: String): Float
}