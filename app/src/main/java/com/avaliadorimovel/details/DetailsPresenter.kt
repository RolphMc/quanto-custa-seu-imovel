package com.avaliadorimovel.details

import com.avaliadorimovel.details.interfaces.InterfaceDetailsInteractor
import com.avaliadorimovel.details.interfaces.InterfaceDetailsPresenter
import com.avaliadorimovel.details.interfaces.repository.InterfaceFactorList
import com.avaliadorimovel.details.repository.ConfidenceIntervalData
import com.avaliadorimovel.details.repository.HomogenizeFactorList
import com.avaliadorimovel.details.repository.LimitsData
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

        val limits: LimitsData = detailsInteractor.calculateTheLimits(arithmeticMean)

        val standardDeviation: Double = detailsInteractor.calculateStandardDeviation(homogenizeFactorList, arithmeticMean)

        val coefficientOfVariation: Double = detailsInteractor.calcutaleCoefficienteOfVariation(standardDeviation, arithmeticMean)

        val tStudentGrade2: Double = detailsInteractor.calculateTStudentG2(homogenizeFactorList.size-1)

        val confidenceInterval: ConfidenceIntervalData = detailsInteractor.calculateConfidenceInterval(standardDeviation, tStudentGrade2, homogenizeFactorList.size, arithmeticMean)

        

        val result: Double = 0.0 //aguardando

        view.navigateToResult(result)
    }

    override fun onError() {

    }

    override fun onSuccess() {
        TODO("Not yet implemented")
    }

}