package com.avaliadorimovel.details.repository

import com.avaliadorimovel.details.interfaces.repository.InterfaceFactorList
import com.avaliadorimovel.details.interfaces.repository.InterfaceHomogenizedFactorList
import com.avaliadorimovel.details.interfaces.repository.InterfaceLimitesList
import com.avaliadorimovel.details.interfaces.repository.InterfaceSampleItem

data class SampleItem(
        override val paradigm: Boolean,
        override val costSample: Double,
        override val areaSample: Int,
        override val parkingSpace: Int,
        override val finishPattern: Double,
        override val conservationState: Double
        ) : InterfaceSampleItem {

        }

data class FactorList(
        override var squareMeterValue: Double,
        override var areaFactor: Float,
        override var parkingFactor: Double,
        override var finishingFactor: Double,
        override var stateFactor: Double
        ): InterfaceFactorList {

        }

data class HomogenizeFactorList(
        override var sampleHomogeneized: Double
        ): InterfaceHomogenizedFactorList {
}

data class LimitesList(
        override var upperLimite: Double,
        override var lowerLimite: Double
): InterfaceLimitesList {
}

