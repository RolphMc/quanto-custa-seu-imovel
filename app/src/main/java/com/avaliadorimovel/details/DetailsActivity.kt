package com.avaliadorimovel.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.avaliadorimovel.R
import com.avaliadorimovel.details.interfaces.InterfaceDetailsView
import com.avaliadorimovel.details.repository.SampleItem
import com.avaliadorimovel.result.ResultActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity(), InterfaceDetailsView{

    private val detailsPresenter = DetailsPresenter(this) //resolver referência

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        setControls()
        calculate_result.setOnClickListener{createSamples()}
    }

    override fun setControls() {
        listOf(parking_space_input, sample1_parking_space_input, sample2_parking_space_input,
                sample3_parking_space_input).forEach { spinner->
            dataNumberParkingSpaces(this, spinner)
        }

//        dataNumberParkingSpaces(this, parking_space_input)
//        dataNumberParkingSpaces(this, sample1_parking_space_input)
//        dataNumberParkingSpaces(this, sample2_parking_space_input)
//        dataNumberParkingSpaces(this, sample3_parking_space_input)

        dataFinishPattern(this, finishing_pattern_input)
        dataFinishPattern(this, sample1_finishing_pattern_input)
        dataFinishPattern(this, sample2_finishing_pattern_input)
        dataFinishPattern(this, sample3_finishing_pattern_input)

        dataConservationState(this, conservation_state_input)
        dataConservationState(this, sample1_conservation_state_input)
        dataConservationState(this, sample2_conservation_state_input)
        dataConservationState(this, sample3_conservation_state_input)
     }

    override fun createSamples() {
        //código funcional com Spinners
        val sampleList = arrayListOf(
            SampleItem(true, null, paradigm_area_input.pegarValorInt(), parking_space_input.pegarValorInt(), finishing_pattern_input.pegarValorString(), conservation_state_input.pegarValorString()), //Paradgma
            SampleItem(false, sample1_value_input.pegarValorFloat(), sample1_area_input.pegarValorInt(), sample1_parking_space_input.pegarValorInt(), sample1_finishing_pattern_input.pegarValorString(), sample1_conservation_state_input.pegarValorString()), //Sample1
            SampleItem(false, sample2_value_input.pegarValorFloat(), sample2_area_input.pegarValorInt(), sample2_parking_space_input.pegarValorInt(), sample2_finishing_pattern_input.pegarValorString(), sample2_conservation_state_input.pegarValorString()), //Sample2
            SampleItem(false, sample3_value_input.pegarValorFloat(), sample3_area_input.pegarValorInt(), sample3_parking_space_input.pegarValorInt(), sample3_finishing_pattern_input.pegarValorString(), sample3_conservation_state_input.pegarValorString()), //Sample3
        )

//        //código Teste - sem Spinners
//        val sampleList = arrayListOf(
//            SampleItem(true, null, paradigm_area_input, 3, "Normal", "Bom"), //Paradgma
//            SampleItem(false, sample1_value_input, sample1_area_input, 2, "Normal", "Bom"), //Sample1
//            SampleItem(false, sample2_value_input, sample2_area_input, 2, "Alto", "Bom"), //Sample2
//            SampleItem(false, sample3_value_input, sample3_area_input, 5, "Normal", "Bom"), //Sample3
//        )
        detailsPresenter.takeSamples(sampleList)
    }

    override fun onValidationError() {
        Snackbar.make(custom_toast_container, "Houve um erro de validação", Snackbar.LENGTH_LONG)
    }

    fun dataNumberParkingSpaces(context: Context, spinner: Spinner){
        ArrayAdapter.createFromResource(context,
                R.array.number_parking_space,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

    fun dataFinishPattern(context: Context, spinner: Spinner) {
        ArrayAdapter.createFromResource(context,
                R.array.standard_finish,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

    fun dataConservationState(context: Context, spinner: Spinner) {
        ArrayAdapter.createFromResource(context,
                R.array.conservation_state,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

    override fun navigateToResult(result: Float) {
        startActivity(Intent(this, ResultActivity::class.java).apply {
            putExtras(Bundle().apply { putFloat("result", result) })
        })
    }
    
}

fun Spinner.pegarValorInt() = this.selectedItem.toString().toInt()
fun Spinner.pegarValorFloat() = this.selectedItem.toString().toFloat()
fun Spinner.pegarValorString() = this.selectedItem.toString()
fun EditText.pegarValorInt() = this.text.toString().toInt()
fun EditText.pegarValorFloat() = this.text.toString().toFloat()

