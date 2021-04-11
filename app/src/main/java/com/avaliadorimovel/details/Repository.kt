package com.avaliadorimovel.details.repository

import com.avaliadorimovel.details.interfaces.repository.InterfaceFactorList
import com.avaliadorimovel.details.interfaces.repository.InterfaceSampleItem

data class SampleItem(
        override val paradigm: Boolean,
        override val costSample: Float,
        override val areaSample: Int,
        override val parkingSpace: Int,
        override val finishPattern: Float,
        override val conservationState: Float
        ) : InterfaceSampleItem {

        }

data class FactorList(
        override var squareMeterValue: Float,
        override var areaFactor: Float,
        override var parkingFactor: Float,
        override var finishingFactor: Float,
        override var stateFactor: Float
        ): InterfaceFactorList {

        }