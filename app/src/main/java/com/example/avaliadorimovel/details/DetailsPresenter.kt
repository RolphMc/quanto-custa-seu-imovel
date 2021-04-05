package com.example.avaliadorimovel.details

import android.content.Intent
import android.widget.EditText
import android.widget.Spinner
import androidx.core.content.ContextCompat.startActivity
import com.example.avaliadorimovel.result.ResultActivity

class DetailsPresenter (var detailsView: DetailsView?, var detailsInteractor: DetailsInteractor): DetailsInteractor.calculationSuccess{

    private val interactor = DetailsInteractor()

    fun createSamples(
        paradigm: Boolean,
        costImmobile: EditText?,
        areaImmobile: EditText,
        parkingSpaces: Spinner,
        finishStandart: Spinner,
        conservationState: Spinner,
    ): CreateSample {
        return interactor.createSamples(paradigm, interactor.convertToFloat(costImmobile), interactor.convertToInt(areaImmobile), interactor.convertToInt(parkingSpaces), interactor.convertToFloat(finishStandart), interactor.convertToFloat(conservationState))
    }
    override fun onError() {
        TODO("Not yet implemented")
    }

    override fun onSuccess() {
        startActivity(Intent(this, ResultActivity::class.java))
    }
}