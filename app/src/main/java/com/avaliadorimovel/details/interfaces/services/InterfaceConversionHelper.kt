package com.avaliadorimovel.details.interfaces.services

interface InterfaceConversionHelper {
    fun patternFactor(samplePattern: String): Double
    fun conservationFactor(sampleConservation: String): Double
    fun parkingFactor(sampleParking: Int): Int
    fun tStudentFactor(tStudent: Int): Double
}