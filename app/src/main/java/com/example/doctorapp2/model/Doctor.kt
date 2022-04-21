package com.example.doctorapp2

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Doctor(var name:String, var id:Int, var address:String, var profession:String,
                  var phone: String,var status:Status):Parcelable
enum class Status{
    Online,Offline
}