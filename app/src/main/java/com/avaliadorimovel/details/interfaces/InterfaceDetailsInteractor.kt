package com.avaliadorimovel.details.interfaces

import com.avaliadorimovel.details.interfaces.repository.InterfaceFactorList
import com.avaliadorimovel.details.repository.HomogenizeFactorList
import com.avaliadorimovel.details.repository.LimitesList
import com.avaliadorimovel.details.repository.SampleItem

interface InterfaceDetailsInteractor {
    //conversões
    fun convertParkingFactor(sampleParking: Int): Int


    //calculos
    fun calculateFactors(sampleList: ArrayList<SampleItem>): MutableList<InterfaceFactorList>
    fun homogenizeTheSample(interfaceFactorList: MutableList<InterfaceFactorList>): MutableList<HomogenizeFactorList>
    fun getArithmeticMean(homogenizeFactorList: MutableList<HomogenizeFactorList>): Double
    fun calculateTheLimits(arithmeticMean: Double): LimitesList
    fun calculateStandardDeviation(homogenizeFactorList: MutableList<HomogenizeFactorList>, arithmeticMean: Double): Double

    //tratamento de erros
    fun thereBlankfields(sampleList: ArrayList<SampleItem>): Boolean
    fun convertPatternFactor(samplePattern: String): Double
    fun convertConservationFactor(sampleConservation: String): Double
}