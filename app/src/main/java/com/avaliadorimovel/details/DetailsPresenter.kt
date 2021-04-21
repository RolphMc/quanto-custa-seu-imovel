package com.avaliadorimovel.details

import com.avaliadorimovel.details.interfaces.InterfaceDetailsInteract
import com.avaliadorimovel.details.interfaces.InterfaceDetailsPresenter
import com.avaliadorimovel.details.interfaces.models.InterfaceFactorList
import com.avaliadorimovel.details.repository.ConfidenceIntervalData
import com.avaliadorimovel.details.repository.HomogenizeFactorList
import com.avaliadorimovel.details.repository.LimitsData
import com.avaliadorimovel.details.repository.SampleItem
import java.text.DecimalFormat

class DetailsPresenter (val view: DetailsActivity): InterfaceDetailsPresenter {

    var detailsInteract: InterfaceDetailsInteract

    init {
        detailsInteract = DetailsInteract(this)
    }

    override fun dataValidation(sampleList: ArrayList<SampleItem>){
        if(detailsInteract.thereBlankfields(sampleList)){
            view.onValidationError()
        }
    }

    override fun treatParkingInput(sampleParking: Int): Int {
        return detailsInteract.convertParkingFactor(sampleParking)
    }

    override fun treatPatternInput(samplePattern: String): Double{
        return detailsInteract.convertPatternFactor(samplePattern)
    }

    override fun treatConservationInput(sampleConservation: String): Double{
        return detailsInteract.convertConservationFactor(sampleConservation)
    }

    override fun takeSamples(sampleList: ArrayList<SampleItem>){

        val factorList: MutableList<InterfaceFactorList> = detailsInteract.calculateFactors(sampleList)

        val homogenizeFactorList: MutableList<HomogenizeFactorList> = detailsInteract.homogenizeTheSample(factorList)

        val arithmeticMean: Double = detailsInteract.getArithmeticMean(homogenizeFactorList)

        val limits: LimitsData = detailsInteract.calculateTheLimits(arithmeticMean) //usar em breve

        val standardDeviation: Double = detailsInteract.calculateStandardDeviation(homogenizeFactorList, arithmeticMean)

        val coefficientOfVariation: Double = detailsInteract.calcutaleCoefficienteOfVariation(standardDeviation, arithmeticMean) //usar em breve

        val tStudentGrade2: Double = detailsInteract.calculateTStudentG2(homogenizeFactorList.size-1)

        val confidenceInterval: ConfidenceIntervalData = detailsInteract.calculateConfidenceInterval(standardDeviation, tStudentGrade2, homogenizeFactorList.size, arithmeticMean)

        val unitaryValue: Double = detailsInteract.roundValue(arithmeticMean)

        val reliability: Double = detailsInteract.checkReliability(confidenceInterval.higherConfidenceIinterval)

        val marketValueOfThePropety: Double = detailsInteract.calculateValueOfThePropety(unitaryValue,sampleList[0].areaSample, reliability)

        val decimalFormat = DecimalFormat("#,000.00")

        val result: String = decimalFormat.format(detailsInteract.roundValue(marketValueOfThePropety))

        view.navigateToResult(result)
    }

    override fun onError() {

    }

    override fun onSuccess() {
        TODO("Not yet implemented")
    }

}