package com.example.companies.ui.fragment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.companies.databinding.FragmentMainBinding
import com.example.companies.utils.appComponent

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by viewModels {
        appComponent.viewModelFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        setUpBinding()

        return binding.root
    }

    private fun setUpBinding() {
        setUpButtons()
        setUpObservers()
    }

    private fun setUpButtons() {
        binding.apply {
            allCompanies.setOnClickListener { viewModel.onClickAllCompaniesListener() }
            reviews.setOnClickListener { viewModel.onClickReviewsListener() }
            analysisReports.setOnClickListener { viewModel.onClickAnalysisReportsListener() }
            favoriteCompanies.setOnClickListener { viewModel.onClickFavoriteCompaniesListener() }
        }
    }

    private fun setUpObservers() {
        setUpObserveActionNavigate()
    }

    private fun setUpObserveActionNavigate() {
        viewModel.actionNavigateLive.observe(viewLifecycleOwner) { event ->
            event.getContentIfNotHandled()?.let { action ->
                findNavController().navigate(action)
            }
        }
    }
}