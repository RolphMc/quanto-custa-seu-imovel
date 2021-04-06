package com.avaliadorimovel.details

import android.app.AlertDialog
import android.content.Context
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.avaliadorimovel.R
import com.avaliadorimovel.details.interfaces.InterfaceDetailsInteractor
import com.avaliadorimovel.details.repository.SampleItem


class DetailsInteractor: InterfaceDetailsInteractor {

    override fun dataNumberParkingSpaces(context: Context, spinner: Spinner){
        ArrayAdapter.createFromResource(context,
                R.array.number_parking_space,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

    override fun dataFinishPattern(context: Context, spinner: Spinner) {
        ArrayAdapter.createFromResource(context,
                R.array.standard_finish,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

    override fun dataConservationState(context: Context, spinner: Spinner) {
        ArrayAdapter.createFromResource(context,
                R.array.conservation_state,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

    override fun calculateFactors(sampleList: ArrayList<SampleItem>) {

        // [CRIAR] converter em fatores itens dos Spinners

        // [CRIAR] lógica do cálculo do fator área
            //Fator área = áreaAmostra / áreaMotivo
            // se < 0.7 ou >= 1.3 = Fator área ^ 0.125
            // se não Fator área ^ 0.25

//        var listFactor = arrayListOf(
//                ListFactor(sampleList[0].finishPattern/sampleList[1].finishPattern) //Sample 1
//        )
    }

    override fun thereBlankfields(context: Context, sampleList: ArrayList<SampleItem>){
        //provisório
        AlertDialog.Builder(context)
            .setTitle("Campos Nulos")
            .setMessage("Verificação feita")
            .setPositiveButton(R.string.alertdialog_ok) { dialog, which -> dialog.dismiss() }
            .show()
        //necessário tratativa de erro para campos nulos
//        for(i in 1..sampleList.size){
//            if(
//                    sampleList[i].costSample!!.text.equals("") ||
//                    sampleList[i].areaSample.text.equals("") ||
//                    sampleList[i].parkingSpace == null ||
//                    sampleList[i].finishPattern == null ||
//                    sampleList[i].conservationState == null
//            ){
//                AlertDialog.Builder(context)
//                    .setTitle(R.string.alertdialog_title_campos_vazios)
//                    .setMessage(R.string.alertdialog_campo_vazio)
//                    .setPositiveButton(R.string.alertdialog_ok) { dialog, which -> dialog.dismiss() }
//                    .show()
//                break
//            }
//        }
    }
}