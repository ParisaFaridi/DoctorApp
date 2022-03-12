package com.example.doctorapp2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.doctorapp2.databinding.FragmentDoctorBinding

class DoctorFragment : Fragment() {

    private val doctorViewModel: DoctorViewModel by viewModels()
    private val args: DoctorFragmentArgs by navArgs()

    private var _binding: FragmentDoctorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDoctorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        doctorViewModel.testData()
        val id = args.docId
        binding.apply {
            tvName.text = doctorViewModel.doctorList[id].name
            tvProfession.text = doctorViewModel.doctorList[id].profession
            tvPhone.text = doctorViewModel.doctorList[id].phone
            tvCity.text = doctorViewModel.doctorList[id].address
            tvStatus.text = doctorViewModel.doctorList[id].status.toString()
        }
        activity?.title = doctorViewModel.doctorList[id].name


    }
}