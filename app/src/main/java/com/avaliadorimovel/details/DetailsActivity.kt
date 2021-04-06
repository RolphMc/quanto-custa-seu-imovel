package com.avaliadorimovel.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.avaliadorimovel.R
import com.avaliadorimovel.details.interfaces.InterfaceDetailsView
import com.avaliadorimovel.details.repository.SampleItem
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity(), InterfaceDetailsView{

    private val detailsPresenter = DetailsPresenter(DetailsInteractor())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        setControls()
        calculate_result.setOnClickListener{createSamples()}
    }

    override fun setControls() {
        detailsPresenter.carregarSpinnersParkingSpace(this, parking_space_input)
        detailsPresenter.carregarSpinnersParkingSpace(this, sample1_parking_space_input)
        detailsPresenter.carregarSpinnersParkingSpace(this, sample2_parking_space_input)
        detailsPresenter.carregarSpinnersParkingSpace(this, sample3_parking_space_input)

        detailsPresenter.carregarFinishPattern(this, finishing_pattern_input)
        detailsPresenter.carregarFinishPattern(this, sample1_finishing_pattern_input)
        detailsPresenter.carregarFinishPattern(this, sample2_finishing_pattern_input)
        detailsPresenter.carregarFinishPattern(this, sample3_finishing_pattern_input)

        detailsPresenter.carregarConservationState(this, conservation_state_input)
        detailsPresenter.carregarConservationState(this, sample1_conservation_state_input)
        detailsPresenter.carregarConservationState(this, sample2_conservation_state_input)
        detailsPresenter.carregarConservationState(this, sample3_conservation_state_input)
     }

    override fun createSamples() {
//        //código funcional com Spinners
//        val sampleList = arrayListOf(
//            SampleItem(true, null, paradigm_area_input, parking_space_input, finishing_pattern_input, conservation_state_input), //Paradgma
//            SampleItem(false, sample1_value_input, sample1_area_input, sample1_parking_space_input, sample1_finishing_pattern_input, sample1_conservation_state_input), //Sample1
//            SampleItem(false, sample2_value_input, sample2_area_input, sample2_parking_space_input, sample2_finishing_pattern_input, sample2_conservation_state_input), //Sample2
//            SampleItem(false, sample3_value_input, sample3_area_input, sample3_parking_space_input, sample3_finishing_pattern_input, sample3_conservation_state_input), //Sample3
//        )

        //código Teste - sem Spinners
        val sampleList = arrayListOf(
            SampleItem(true, null, paradigm_area_input, 3, "Normal", "Bom"), //Paradgma
            SampleItem(false, sample1_value_input, sample1_area_input, 2, "Normal", "Bom"), //Sample1
            SampleItem(false, sample2_value_input, sample2_area_input, 2, "Alto", "Bom"), //Sample2
            SampleItem(false, sample3_value_input, sample3_area_input, 5, "Normal", "Bom"), //Sample3
        )
        detailsPresenter.takeSamples(this, sampleList)
    }
}