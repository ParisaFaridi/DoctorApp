package com.example.doctorapp2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.doctorapp2.databinding.FragmentCheckPatientBinding

var ANSWERED = false
class CheckPatientFragment : Fragment() {

    private lateinit var binding: FragmentCheckPatientBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCheckPatientBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSubmit.setOnClickListener {
            if (!binding.checkBox1.isChecked) {
                Toast.makeText(activity,
                    "اگر اکنون امکان صحبت ندارید میتوانید بعدا وقت خود را رزرو کنید!",
                    Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }else{
                ANSWERED = true
                findNavController().popBackStack()
            }

        }
    }

}