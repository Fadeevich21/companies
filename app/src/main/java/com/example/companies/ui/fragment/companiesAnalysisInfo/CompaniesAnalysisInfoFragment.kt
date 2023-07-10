package com.example.companies.ui.fragment.companiesAnalysisInfo

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.companies.databinding.FragmentCompaniesAnalysisInfoBinding
import com.example.companies.ui.adapter.companyAnalysisInfo.CompaniesAnalysisInfoAdapter
import com.example.companies.ui.adapter.companyAnalysisInfo.companyAnalysisInfoAdapterDelegate
import com.example.companies.ui.decoration.VerticalListItemDecoration
import com.example.companies.ui.utils.MultiViewModelFactory
import com.example.companies.utils.appComponent
import javax.inject.Inject

class CompaniesAnalysisInfoFragment : Fragment() {

    private var _binding: FragmentCompaniesAnalysisInfoBinding? = null
    private val binding get() = _binding!!

    private val adapter = CompaniesAnalysisInfoAdapter(companyAnalysisInfoAdapterDelegate {
        viewModel.onCompanyAnalysisInfoClick(it.companyAnalysisInfo)
    })

    @Inject
    lateinit var viewModelFactory: MultiViewModelFactory
    private val viewModel: CompaniesAnalysisInfoViewModel by viewModels {
        viewModelFactory
    }

    override fun onAttach(context: Context) {
        appComponent.inject(this)

        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCompaniesAnalysisInfoBinding.inflate(inflater, container, false)

        adapter.items = viewModel.companiesCompaniesAnalysisInfoLive.value

        setUpBinding()
        setUpObserves()

        return binding.root
    }

    private fun setUpBinding() {
        setUpReportsContainer()
    }

    private fun setUpReportsContainer() = with(binding) {
        companiesAnalysisInfoContainer.layoutManager = LinearLayoutManager(context)
        companiesAnalysisInfoContainer.adapter = adapter
        companiesAnalysisInfoContainer.addItemDecoration(
            VerticalListItemDecoration(
                vertical = 10,
                horizontal = 20,
                betweenItem = 10,
            )
        )
    }

    private fun setUpObserves() {
        setUpObserveCompaniesCompaniesAnalysisInfo()
    }

    private fun setUpObserveCompaniesCompaniesAnalysisInfo() {
        viewModel.companiesCompaniesAnalysisInfoLive.observe(viewLifecycleOwner) {
            adapter.notifyItemRangeChanged(0, it.count())
        }
    }
}