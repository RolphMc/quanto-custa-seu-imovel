package com.avaliadorimovel.details.repository

import com.sugarya.footer.interfaces.IFooterItem

data class ContainerParking (val factorParking: Float, val amountParkingSpace: String): IFooterItem {
    override val factor: Float
        get() = factorParking
    override val descriptionShowSelect: String
        get() = amountParkingSpace
    override var isSelected: Boolean = false
}