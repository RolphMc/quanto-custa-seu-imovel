package com.avaliadorimovel.details.repository

data class ContainerParking (val factorParking: Float, val amountParkingSpace: String) {
    val factor: Float
        get() = factorParking
    val descriptionShowSelect: String
        get() = amountParkingSpace
    var isSelected: Boolean = false
}