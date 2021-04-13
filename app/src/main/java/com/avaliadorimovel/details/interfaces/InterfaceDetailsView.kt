package com.avaliadorimovel.details.interfaces

interface InterfaceDetailsView {
    fun setControls()
    fun createSamples()
    fun onValidationError()
    fun navigateToResult(result: String)
}