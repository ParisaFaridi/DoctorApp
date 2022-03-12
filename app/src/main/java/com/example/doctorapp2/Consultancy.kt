package com.example.doctorapp2

data class Consultancy (val id : Int,
                        val time : Int,
                        val price : Int,
                        val type : ConsultancyType
)

enum class ConsultancyType{
    Phone , Video
}