package com.avaliadorimovel.details

import com.avaliadorimovel.details.interfaces.InterfaceDetailsInteractor
import com.avaliadorimovel.details.interfaces.InterfaceDetailsPresenter
import com.avaliadorimovel.details.interfaces.repository.InterfaceFactorList
import com.avaliadorimovel.details.repository.HomogenizeFactorList
import com.avaliadorimovel.details.repository.LimitesList
import com.avaliadorimovel.details.repository.SampleItem

class DetailsPresenter (val view: DetailsActivity): InterfaceDetailsPresenter {

    var detailsInteractor: InterfaceDetailsInteractor

    init {
        detailsInteractor = DetailsInteractor(this)
    }

    override fun dataValidation(sampleList: ArrayList<SampleItem>){
        if(detailsInteractor.thereBlankfields(sampleList)){
            view.onValidationError()
        }
    }

    override fun treatParkingInput(sampleParking: Int): Int {
        return detailsInteractor.convertParkingFactor(sampleParking)
    }

    override fun treatPatternInput(samplePattern: String): Double{
        return detailsInteractor.convertPatternFactor(samplePattern)
    }

    override fun treatConservationInput(sampleConservation: String): Double{
        return detailsInteractor.convertConservationFactor(sampleConservation)
    }

    override fun takeSamples(sampleList: ArrayList<SampleItem>){

        val factorList: MutableList<InterfaceFactorList> = detailsInteractor.calculateFactors(sampleList)

        val homogenizeFactorList: MutableList<HomogenizeFactorList> = detailsInteractor.homogenizeTheSample(factorList)

        val arithmeticMean: Double = detailsInteractor.getArithmeticMean(homogenizeFactorList)

        val limits: LimitesList = detailsInteractor.calculateTheLimits(arithmeticMean)

        val standardDeviation: Double = detailsInteractor.calculateStandardDeviation(homogenizeFactorList, arithmeticMean)

        val result: Double = 0.0 //aguardando

        view.navigateToResult(result)
    }

    override fun onError() {

    }

    override fun onSuccess() {
        TODO("Not yet implemented")
    }

}