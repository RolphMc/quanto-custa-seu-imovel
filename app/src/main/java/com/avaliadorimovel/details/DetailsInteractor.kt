package com.avaliadorimovel.details

import com.avaliadorimovel.R
import android.content.Context
import android.widget.ArrayAdapter
import com.avaliadorimovel.details.interfaces.InterfaceDetailsInteractor
import com.avaliadorimovel.details.repository.ContainerParking

class DetailsInteractor(): InterfaceDetailsInteractor {
    var parkingSpacesList = arrayListOf<ContainerParking>()

    interface calculationSuccess {
        fun onError()
        fun onSuccess()
    }

    override fun dataNumberParkingSpaces(context: Context){
        ArrayAdapter.createFromResource(context,
                ,
                R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

//        parkingSpacesList = arrayListOf(
//                ContainerParking(0f,"Nenhuma"),
//                ContainerParking(95f, "0"),
//                ContainerParking(100f,"1"),
//                ContainerParking(105f,"2"),
//                ContainerParking(110f,"3"),
//                ContainerParking(115f,"4"),
//                ContainerParking(120f,"5"),
//                ContainerParking(125f,"6"),
//                ContainerParking(130f,"7"),
//                ContainerParking(135f,"8"),
//                ContainerParking(140f,"9"),
//                ContainerParking(145f,"10"),
//        )
//        return parkingSpacesList
    }

    override fun dataFinishPattern() {
        TODO("Not yet implemented")
    }

    override fun dataConservationState() {
        TODO("Not yet implemented")
    }
}