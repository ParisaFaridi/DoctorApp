package com.example.doctorapp2.viewModel

import androidx.lifecycle.ViewModel
import com.example.doctorapp2.Consultancy
import com.example.doctorapp2.ConsultancyType

class ConsultancyViewModel:ViewModel() {

    val consultancyList = arrayListOf(
        Consultancy(1 , 30 , 100000, ConsultancyType.Phone),
        Consultancy(2 , 60 , 250000, ConsultancyType.Video),
        Consultancy(3 , 90 , 300000, ConsultancyType.Phone)
    )

}
