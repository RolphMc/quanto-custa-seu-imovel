package com.example.avaliadorimovel.details

class DetailsInteractor (): {

    interface calculationSuccess {
        fun onError()
        fun onSuccess()
    }

    fun createSamples(
        paradigm: Boolean,
        costImmobile: Float?,
        areaImmobile: Int,
        parkingSpaces: Int,
        finishStandart: Float,
        conservationState: Float,
    ): CreateSample {
        return createSamples(
            paradigm,
            costImmobile,
            areaImmobile,
            parkingSpaces,
            finishStandart,
            conservationState
        )
    }

    fun convertToFloat(aux: Any?): Float {
        val aux1: String = aux.toString()
        return aux1.toFloat();
    }

    fun convertToInt(aux: Any): Int {
        val aux1: String = aux.toString()
        return aux1.toInt();
    }

    private fun homogenizeFactors(){

    }

    private fun navigateToResult(){
        TODO("Not yet implemented")
    }
}