package com.sugarya.footer.interfaces

/**
 * Adapter里item点击响应
 */
interface OnSpinnerItemContainerClickListener {

    fun onItemClick(list: MutableList<ISpinnerItem>, position: Int)
}