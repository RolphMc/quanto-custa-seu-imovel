package com.avaliadorimovel.details.interfaces.repository

import android.widget.EditText

interface InterfaceSampleItem {
    val paradigm: Boolean
    val costSample: EditText?
    val areaSample: EditText
    val parkingSpace: Int
    val finishPattern: String
    val conservationState: String
}