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

        val testData = listOf(
            Doctor("امیر احسانی", 0, "تهران", "متخصص پوست", "44852347", Status.Online),
            Doctor("محمد صادقیان", 1, "تهران", "ارتوپد", "66889925", Status.Online),
            Doctor("زهرا حسینی", 2, "تهران", "روان پزشک", "22123456", Status.Offline)
        )
        val adapter = DoctorAdapter(testData)
        binding.doctorRv.adapter = adapter
        adapter.notifyDataSetChanged()

        doctorViewModel.testData()
        binding.btnDoc1.text =doctorViewModel.doctorList[0].name
        binding.btnDoc2.text =doctorViewModel.doctorList[1].name
        binding.btnDoc3.text =doctorViewModel.doctorList[2].name

        binding.apply {
            btnDoc1.setOnClickListener {navigateToSecondFragment(0)}
            btnDoc2.setOnClickListener {navigateToSecondFragment(1)}
            btnDoc3.setOnClickListener {navigateToSecondFragment(2)}
        }
    }

    private fun navigateToSecondFragment(id: Int) {
        findNavController().navigate(
            DoctorListFragmentDirections
                .actionDoctorListFragmentToDoctorFragment(id)
        )
    }
}