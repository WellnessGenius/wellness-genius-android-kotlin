package com.wellnessgenius.android.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.wellnessgenius.android.databinding.FragmentDashboardBinding
import com.wellnessgenius.android.viewmodels.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DashboardViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupObservers()
        
        // Load health data
        viewModel.loadHealthData()
    }

    private fun setupObservers() {
        viewModel.userName.observe(viewLifecycleOwner) { name ->
            binding.greetingTextView.text = "Hello, $name!"
        }
        
        viewModel.stepCount.observe(viewLifecycleOwner) { steps ->
            binding.stepsValueTextView.text = steps.toString()
        }
        
        viewModel.calories.observe(viewLifecycleOwner) { calories ->
            binding.caloriesValueTextView.text = calories.toString()
        }
        
        viewModel.heartRate.observe(viewLifecycleOwner) { heartRate ->
            binding.heartRateValueTextView.text = heartRate.toString()
        }
        
        viewModel.bioAge.observe(viewLifecycleOwner) { bioAge ->
            binding.bioAgeValueTextView.text = bioAge.toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
