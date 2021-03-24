package com.example.avaliadorimovel.details

import kotlinx.android.synthetic.main.activity_details.*

class DetailsInteractor (): {

    interface calculationSuccess {
        fun onError()
        fun onSuccess()
    }

     fun calculate

    fun createSamples(): List<House> {
        var list = listOf(House())
        /*sampleParadgm = presenter.createSamples(true,null, paradigm_area_input, space_parking_input, finishing_pattern_input, conservation_state_input)
        sample1 = presenter.createSamples(false, sample1_value_input, sample1_area_input, sample1_Parking_space_input, sample1_finishing_pattern_input, sample1_conservation_state_input)
        sample2 = presenter.createSamples(false, sample2_value_input, sample2_area_input, sample2_parking_space_input, sample2_finishing_pattern_input, sample2_conservation_state_input)
        sample3 = presenter.createSamples(false, sample3_value_input, sample3_area_input, sample3_parking_space_input, sample3_finishing_pattern_input, sample3_conservation_state_input)*/
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