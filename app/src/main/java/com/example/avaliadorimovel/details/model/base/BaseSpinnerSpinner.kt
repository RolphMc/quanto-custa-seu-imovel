package com.sugarya.footer.base

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.example.avaliadorimovel.details.interfaces.SpinnerMode
import com.example.avaliadorimovel.details.model.BaseFooterProperty
import com.sugarya.footer.interfaces.ISpinnerMode

abstract class BaseSpinnerSpinner<out T: BaseFooterProperty> : RelativeLayout, ISpinnerMode {

    abstract val baseFooterViewProperty: T

    var computedEndingHeight: Int = 0

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    protected fun setupFooterHeight(needHeight: Int) {
        val showHeight = needHeight + paddingTop + paddingBottom
        computedEndingHeight = showHeight
    }

    var mSpinnerMode: SpinnerMode?
        get() = baseFooterViewProperty.footerMode
        set(value) {}

    fun setSelectedOptionText(option: String){
        baseFooterViewProperty.selectedOptionText = option
    }
}