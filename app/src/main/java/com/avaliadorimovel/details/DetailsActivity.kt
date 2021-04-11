package com.avaliadorimovel.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.avaliadorimovel.R
import com.avaliadorimovel.details.interfaces.InterfaceDetailsView
import com.avaliadorimovel.details.repository.SampleItem
import com.avaliadorimovel.result.ResultActivity
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity(), InterfaceDetailsView{

    val detailsPresenter = DetailsPresenter(this) //resolver referência

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        setControls()
        button_apartamento.setOnClickListener{loadingDataForm()}
        calculate_result.setOnClickListener{createSamples()}
    }

    private fun loadingDataForm() {
        paradigm_area_input.setText("118")
        parking_space_input.setSelection(3)
        finishing_pattern_input.setSelection(3)
        conservation_state_input.setSelection(3)

        sample1_value_input.setText("798000")
        sample1_area_input.setText("120")
        sample1_parking_space_input.setSelection(2)
        sample1_finishing_pattern_input.setSelection(3)
        sample1_conservation_state_input.setSelection(3)

        sample2_value_input.setText("1454478")
        sample2_area_input.setText("131")
        sample2_parking_space_input.setSelection(2)
        sample2_finishing_pattern_input.setSelection(5)
        sample2_conservation_state_input.setSelection(3)

        sample3_value_input.setText("1100000")
        sample3_area_input.setText("100")
        sample3_parking_space_input.setSelection(5)
        sample3_finishing_pattern_input.setSelection(3)
        sample3_conservation_state_input.setSelection(3)
    }

    override fun setControls() {
        listOf(parking_space_input, sample1_parking_space_input, sample2_parking_space_input,
                sample3_parking_space_input).forEach { spinner->
            dataNumberParkingSpaces(this, spinner)
        }

        listOf(finishing_pattern_input, sample1_finishing_pattern_input, sample2_finishing_pattern_input,
                sample3_finishing_pattern_input).forEach { spinner->
            dataFinishPattern(this, spinner)
        }

        listOf(conservation_state_input, sample1_conservation_state_input, sample2_conservation_state_input,
                sample3_conservation_state_input).forEach { spinner->
            dataConservationState(this, spinner)
        }

     }

    override fun createSamples() {
        //código funcional com Spinners
        val sampleList = arrayListOf(
                SampleItem(     //Paradgma
                        true,
                        -1f,
                        paradigm_area_input.pegarValorInt(),
                        detailsPresenter.parkingFactor(parking_space_input.pegarValorInt()),
                        detailsPresenter.patternFactor(finishing_pattern_input.pegarValorString()),
                        detailsPresenter.conservationFactor(conservation_state_input.pegarValorString())),

                SampleItem(     //Sample1
                        false,
                        sample1_value_input.pegarValorFloat(),
                        sample1_area_input.pegarValorInt(),
                        detailsPresenter.parkingFactor(sample1_parking_space_input.pegarValorInt()),
                        detailsPresenter.patternFactor(sample1_finishing_pattern_input.pegarValorString()),
                        detailsPresenter.conservationFactor(sample1_conservation_state_input.pegarValorString())),

                SampleItem(     //Sample2
                        false,
                        sample2_value_input.pegarValorFloat(),
                        sample2_area_input.pegarValorInt(),
                        detailsPresenter.parkingFactor(sample2_parking_space_input.pegarValorInt()),
                        detailsPresenter.patternFactor(sample2_finishing_pattern_input.pegarValorString()),
                        detailsPresenter.conservationFactor(sample2_conservation_state_input.pegarValorString())),

                SampleItem(     //Sample3
                        false,
                        sample3_value_input.pegarValorFloat(),
                        sample3_area_input.pegarValorInt(),
                        detailsPresenter.parkingFactor(sample3_parking_space_input.pegarValorInt()),
                        detailsPresenter.patternFactor(sample3_finishing_pattern_input.pegarValorString()),
                        detailsPresenter.conservationFactor(sample3_conservation_state_input.pegarValorString())),
                )
        detailsPresenter.dataValidation(sampleList)
        detailsPresenter.takeSamples(sampleList)
    }

    override fun onValidationError() {
        Toast.makeText(this, "Há Campos Sem Preenchimento", Toast.LENGTH_LONG).show()
    }

    fun congrats(){ //CHAMAR AO ATINGIR OBJETIVOS
        Toast.makeText(this, "C O N G R A T U L A T I O N S", Toast.LENGTH_LONG).show()
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

    private fun Spinner.pegarValorInt() = if(this.selectedItem.toString().equals("Nenhum")) 0 else this.selectedItem.toString().toInt()
    private fun Spinner.pegarValorFloat() = if(this.selectedItem.toString().equals("Nenhum")) 0f else this.selectedItem.toString().toFloat()
    private fun Spinner.pegarValorString() = if(this.selectedItem.toString().equals("Nenhum")) "" else this.selectedItem.toString()
    private fun EditText.pegarValorInt() = if(this.text.toString().equals("")) 0 else this.text.toString().toInt()
    private fun EditText.pegarValorFloat() = if(this.text.toString().equals("")) 0f else this.text.toString().toFloat()

}