package com.example.doctorapp2

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.doctorapp2.databinding.FragmentOnlineVisitBinding

class OnlineVisitFragment : Fragment() {

    private val consultancyViewModel :ConsultancyViewModel by viewModels()
    private var _binding: FragmentOnlineVisitBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding = FragmentOnlineVisitBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            tvTime1.text = "مشاوره تلفنی "+consultancyViewModel.consultancyList[0].time.toString()+" دقیقه ای: "
            tvTime2.text =  "مشاوره تلفنی "+consultancyViewModel.consultancyList[1].time.toString()+" دقیقه ای: "
            tvTime3.text = "مشاوره تلفنی "+consultancyViewModel.consultancyList[2].time.toString()+" دقیقه ای: "

            tvPrice1.text = consultancyViewModel.consultancyList[0].price.toString() +" تومان "
            tvPrice2.text = consultancyViewModel.consultancyList[1].price.toString() +" تومان "
            tvPrice3.text = consultancyViewModel.consultancyList[2].price.toString() +" تومان "
        }

        binding.llFirstOption.setOnClickListener { goToUserInfoFragment()}
        binding.llSecondOption.setOnClickListener { goToUserInfoFragment() }
        binding.llThirdOption.setOnClickListener { goToUserInfoFragment() }
    }
    private fun goToUserInfoFragment(){
        findNavController().navigate(R.id.action_onlineVisitFragment_to_userInfoFragment)
    }
}