package com.avaliadorimovel.details.service

import com.avaliadorimovel.details.DetailsInteract
import com.avaliadorimovel.details.interfaces.services.InterfaceConversionHelper

class ConversionHelper(val interact: DetailsInteract): InterfaceConversionHelper {

    override fun patternFactor(samplePattern: String): Double {
        return when (samplePattern) {
            "Econômico" -> 0.7
            "Simples" -> 0.8375
            "Normal" -> 0.975
            "Superior" -> 1.1125
            "Alto" -> 1.25
            else -> 0.0
        }
    }

    override fun conservationFactor(sampleConservation: String): Double{
        return when (sampleConservation) {
            "Ótimo" -> 1.0
            "Bom" -> 0.95
            "Razoável" -> 0.90
            "Ruim" -> 0.85
            "Demolição" -> 0.8
            else -> 0.0
        }
    }

    override fun parkingFactor(sampleParking: Int): Int{
        return when (sampleParking) {
            0 -> 95
            1 -> 100
            2 -> 105
            3 -> 110
            4 -> 115
            5 -> 120
            6 -> 125
            7 -> 130
            8 -> 135
            9 -> 140
            else -> 0
        }
    }

    override fun tStudentFactor(tStudent: Int): Double {
        return when (tStudent){
            1 -> 3.078
            2 -> 1.886
            3 -> 1.638
            4 -> 1.533
            5 -> 1.476
            6 -> 1.440
            7 -> 1.415
            8 -> 1.397
            9 -> 1.383
            10 -> 1.372
            else -> 0.0
        }
    }
}