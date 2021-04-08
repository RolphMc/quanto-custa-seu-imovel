package com.avaliadorimovel.details.interfaces

import com.avaliadorimovel.details.repository.SampleItem

interface InterfaceDetailsPresenter {
    fun takeSamples(sampleList: ArrayList<SampleItem>)

    fun onError()
    fun onSuccess()
}