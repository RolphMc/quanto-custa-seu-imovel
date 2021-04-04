package com.avaliadorimovel.details

import android.widget.RelativeLayout
import com.avaliadorimovel.details.interfaces.InterfaceDetailsInteractor
import com.avaliadorimovel.details.repository.ContainerParking
import com.sugarya.footer.SpinnerLinearFooter

class DetailsInteractor(): InterfaceDetailsInteractor {

    interface calculationSuccess {
        fun onError()
        fun onSuccess()
    }

    override fun dataNumberParkingSpaces<T>(List<T> dataSpinners) {
        val parkingSpacesList = arrayListOf(
                ContainerParking(0f,"Nenhuma"),
                ContainerParking(95f, "0"),
                ContainerParking(100f,"1"),
                ContainerParking(105f,"2"),
                ContainerParking(110f,"3"),
                ContainerParking(115f,"4"),
                ContainerParking(120f,"5"),
                ContainerParking(125f,"6"),
                ContainerParking(130f,"7"),
                ContainerParking(135f,"8"),
                ContainerParking(140f,"9"),
                ContainerParking(145f,"10"),
        )
        spinnerGridFooter.setNewData(parkingSpacesList)
    }

    override fun dataFinishPattern() {
        TODO("Not yet implemented")
    }

    override fun dataConservationState() {
        TODO("Not yet implemented")
    }
}