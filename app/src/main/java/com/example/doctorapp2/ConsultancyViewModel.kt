package com.example.doctorapp2

import androidx.lifecycle.ViewModel

class ConsultancyViewModel:ViewModel() {

    val consultancyList = arrayListOf(
        Consultancy(1 , 30 , 100000, ConsultancyType.Phone),
        Consultancy(2 , 60 , 250000, ConsultancyType.Video),
        Consultancy(3 , 90 , 300000, ConsultancyType.Phone)
    )

}
