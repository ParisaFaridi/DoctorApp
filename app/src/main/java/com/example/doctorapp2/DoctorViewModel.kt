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
        val doc4=Doctor("محمد محمدی",3,"تهران","روان پزشک",
            "22123456",Status.Offline)
        val doc5=Doctor("فاطمه صادقی",4,"تهران","روان پزشک",
            "22123456",Status.Offline)
        val doc6=Doctor("g",5,"تهران","روان پزشک",
            "22123456",Status.Offline)
        val doc7=Doctor("زهرا",6,"تهران","روان پزشک",
            "22123456",Status.Offline)
        val doc8=Doctor("حسینی",7,"تهران","روان پزشک",
            "22123456",Status.Offline)

        doctorList.add(doc1)
        doctorList.add(doc2)
        doctorList.add(doc3)
        doctorList.add(doc4)
        doctorList.add(doc5)
        doctorList.add(doc6)
        doctorList.add(doc7)
        doctorList.add(doc8)

    }
}