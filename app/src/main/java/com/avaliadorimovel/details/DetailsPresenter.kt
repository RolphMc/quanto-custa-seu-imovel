package com.avaliadorimovel.details

import android.content.Context
import android.widget.ArrayAdapter.createFromResource
import android.widget.Spinner
import com.avaliadorimovel.R
import com.avaliadorimovel.details.interfaces.InterfaceDetailsInteractor
import com.avaliadorimovel.details.interfaces.InterfaceDetailsPresenter

class DetailsPresenter (var detailsInteractor: InterfaceDetailsInteractor): InterfaceDetailsPresenter {

    override fun carregarSpinnersParkingSpace(context: Context, spinner: Spinner){
        createFromResource(context,
                R.array.number_parking_space,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

    override fun carregarFinishPattern() {
        detailsInteractor.dataFinishPattern()
    }

    override fun carregarConservationState() {
        detailsInteractor.dataConservationState()
    }


}