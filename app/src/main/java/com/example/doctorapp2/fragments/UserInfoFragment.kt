package com.example.doctorapp2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.doctorapp2.R
import com.example.doctorapp2.databinding.FragmentUserInfoBinding


class UserInfoFragment : Fragment() {

    private lateinit var binding: FragmentUserInfoBinding
    private val args: UserInfoFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (ANSWERED){
            binding.tvDoctorWillCallYou.visibility = View.VISIBLE
            disableEditTexts()
        }

        val docName = args.docName
        (" دکتر $docName با شما تماس خواهد گرفت").also { binding.tvDoctorWillCallYou.text = it }
        binding.btnCallMeDoc.setOnClickListener {
            if (isNotValid()) {
                setErrors()
                return@setOnClickListener
            }
            findNavController().navigate(R.id.action_userInfoFragment_to_checkPatientFragment)
        }
    }

    private fun setErrors() {
        if (binding.etPatientName.text.isNullOrBlank())
            binding.etPatientName.error = "پر کردن این فیلد الزامی است"
        if(binding.etPatientPhone.text.isNullOrBlank())
            binding.etPatientPhone.error = "پر کردن این فیلد الزامی است"
    }

    private fun isNotValid(): Boolean {
        return (binding.etPatientName.text.isNullOrBlank() || binding.etPatientPhone.text.isNullOrBlank() )
    }
    private fun disableEditTexts(){
        binding.apply {
            etPatientName.isClickable = false
            etPatientName.isCursorVisible = false
            etPatientName.isFocusable = false
            etPatientName.isFocusableInTouchMode = false

            etPatientPhone.isClickable = false
            etPatientPhone.isCursorVisible = false
            etPatientPhone.isFocusable = false
            etPatientPhone.isFocusableInTouchMode = false
        }
    }

}