package com.avaliadorimovel.details.interfaces

import com.avaliadorimovel.details.repository.SampleItem

interface InterfaceDetailsInteractor {
    //calculos
    fun calculateFactors(sampleList: ArrayList<SampleItem>)

    //tratamento de erros
    fun thereBlankfields(sampleList: ArrayList<SampleItem>): Boolean

    fun dataValidation(sampleList: ArrayList<SampleItem>){

    }
}