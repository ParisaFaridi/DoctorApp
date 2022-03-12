package com.example.doctorapp2

import androidx.lifecycle.ViewModel

class DoctorViewModel:ViewModel() {

    var doctorList= arrayListOf<Doctor>()

    fun testData(){
        doctorList.clear()
        val doc1=Doctor("امیر احسانی",0,"تهران","متخصص پوست",
            "44852347",Status.Online)
        val doc2=Doctor("محمد صادقیان",1,"تهران","ارتوپد",
            "66889925",Status.Online)
        val doc3=Doctor("زهرا حسینی",2,"تهران","روان پزشک",
            "22123456",Status.Offline)

        doctorList.add(doc1)
        doctorList.add(doc2)
        doctorList.add(doc3)

    }
}