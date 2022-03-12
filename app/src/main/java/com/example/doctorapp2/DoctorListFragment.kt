package com.example.doctorapp2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.doctorapp2.databinding.FragmentDoctorListBinding

class DoctorListFragment : Fragment() {

    private val doctorListViewModel: DoctorNameViewModel by viewModels()

    private var _binding: FragmentDoctorListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        _binding = FragmentDoctorListBinding.inflate(inflater, container, false)
        return  binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        doctorListViewModel.testData()
        binding.btnDoc1.text =doctorListViewModel.doctorList[0].name
        binding.btnDoc2.text =doctorListViewModel.doctorList[1].name
        binding.btnDoc3.text =doctorListViewModel.doctorList[2].name

        binding.apply {
            btnDoc1.setOnClickListener {navigateToSecondFragment(0)}
            btnDoc2.setOnClickListener {navigateToSecondFragment(1)}
            btnDoc3.setOnClickListener {navigateToSecondFragment(2)}
        }
    }
    private fun navigateToSecondFragment(id:Int){
        findNavController().navigate(DoctorListFragmentDirections
            .actionDoctorListFragmentToDoctorFragment(id))
    }
}