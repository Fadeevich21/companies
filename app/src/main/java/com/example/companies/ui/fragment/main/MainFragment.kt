package com.example.companies.ui.fragment.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.companies.databinding.FragmentMainBinding
import com.example.companies.ui.utils.MultiViewModelFactory
import com.example.companies.utils.appComponent
import javax.inject.Inject

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: MultiViewModelFactory
    private val viewModel: MainViewModel by viewModels {
        viewModelFactory
    }

    override fun onAttach(context: Context) {
        appComponent.inject(this)

        super.onAttach(context)
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
        setUpObserves()
    }

    private fun setUpButtons() {
        binding.apply {
            allCompanies.setOnClickListener { viewModel.onClickAllCompaniesListener() }
            reports.setOnClickListener { viewModel.onClickReportsListener() }
            companyAnalysisInfo.setOnClickListener { viewModel.onClickCompanyAnalysisInfoListener() }
            favoriteCompanies.setOnClickListener { viewModel.onClickFavoriteCompaniesListener() }
        }
    }

    private fun setUpObserves() {
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