package com.avaliadorimovel.details.interfaces

import com.avaliadorimovel.details.interfaces.repository.InterfaceFactorList
import com.avaliadorimovel.details.repository.ConfidenceIntervalData
import com.avaliadorimovel.details.repository.HomogenizeFactorList
import com.avaliadorimovel.details.repository.LimitsData
import com.avaliadorimovel.details.repository.SampleItem

interface InterfaceDetailsInteractor {
    //conversões
    fun convertParkingFactor(sampleParking: Int): Int
    fun convertPatternFactor(samplePattern: String): Double
    fun convertConservationFactor(sampleConservation: String): Double

    //calculos
    fun calculateFactors(sampleList: ArrayList<SampleItem>): MutableList<InterfaceFactorList>
    fun homogenizeTheSample(interfaceFactorList: MutableList<InterfaceFactorList>): MutableList<HomogenizeFactorList>
    fun getArithmeticMean(homogenizeFactorList: MutableList<HomogenizeFactorList>): Double
    fun calculateTheLimits(arithmeticMean: Double): LimitsData
    fun calculateStandardDeviation(homogenizeFactorList: MutableList<HomogenizeFactorList>, arithmeticMean: Double): Double
    fun calcutaleCoefficienteOfVariation(standardDeviation: Double, arithmeticMean: Double): Double
    fun calculateTStudentG2(tStudent: Int): Double
    fun calculateConfidenceInterval(standardDeviation: Double, tStudentGrade2: Double, size: Int, arithmeticMean: Double): ConfidenceIntervalData

    //tratamento de erros
    fun thereBlankfields(sampleList: ArrayList<SampleItem>): Boolean

}