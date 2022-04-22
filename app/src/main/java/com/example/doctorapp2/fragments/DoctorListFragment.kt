package com.example.doctorapp2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.doctorapp2.DoctorAdapter
import com.example.doctorapp2.viewModel.DoctorViewModel
import com.example.doctorapp2.databinding.FragmentDoctorListBinding

class DoctorListFragment : Fragment() {

    private val doctorViewModel: DoctorViewModel by viewModels()

    private var _binding: FragmentDoctorListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDoctorListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.title = "Doctor App"

        doctorViewModel.testData()

        val adapter = DoctorAdapter(doctorViewModel.doctorList) {
            navigateToSecondFragment(it) }
        binding.doctorRv.adapter = adapter


        //adapter.submitList(doctorViewModel.doctorList2)

        adapter.submitList(doctorViewModel.doctorList)
    }

    private fun navigateToSecondFragment(id: Int) {
        findNavController().navigate(
            DoctorListFragmentDirections
                .actionDoctorListFragmentToDoctorFragment(id)
        )
    }
}