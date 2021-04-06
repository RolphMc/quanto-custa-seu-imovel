package com.avaliadorimovel.details.repository

import android.widget.EditText
import com.avaliadorimovel.details.interfaces.repository.InterfaceListFactor
import com.avaliadorimovel.details.interfaces.repository.InterfaceSampleItem

data class SampleItem(
        override val paradigm: Boolean,
        override val costSample: EditText?,
        override val areaSample: EditText,
        override val parkingSpace: Int,
        override val finishPattern: String,
        override val conservationState: String
        ) : InterfaceSampleItem {
}

data class ListFactor(
        override var squareMeterValue: Float,
        override var areaFactor: Float,
        override var parkingFactor: Float,
        override var finishingFactor: Float,
        override var stateFactor: Float
): InterfaceListFactor {
}