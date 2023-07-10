package com.example.companies.ui.fragment.reports

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.companies.databinding.FragmentReportsBinding
import com.example.companies.ui.adapter.report.ReportsAdapter
import com.example.companies.ui.adapter.report.reportAdapterDelegate
import com.example.companies.ui.decoration.VerticalListItemDecoration
import com.example.companies.ui.utils.MultiViewModelFactory
import com.example.companies.utils.appComponent
import javax.inject.Inject

class ReportsFragment : Fragment() {

    private var _binding: FragmentReportsBinding? = null
    private val binding get() = _binding!!

    private val adapter = ReportsAdapter(
        reportAdapterDelegate { viewModel.onReportClick(it.report) }
    )

    @Inject
    lateinit var viewModelFactory: MultiViewModelFactory
    private val viewModel: ReportsViewModel by viewModels {
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
        _binding = FragmentReportsBinding.inflate(inflater, container, false)

        adapter.items = viewModel.companiesReportsLive.value

        setUpBinding()
        setUpObserves()

        return binding.root
    }

    private fun setUpBinding() {
        setUpReportsContainer()
    }

    private fun setUpReportsContainer() = with(binding) {
        reportsContainer.layoutManager = LinearLayoutManager(context)
        reportsContainer.adapter = adapter
        reportsContainer.addItemDecoration(
            VerticalListItemDecoration(
                vertical = 10,
                horizontal = 20,
                betweenItem = 10,
            )
        )
    }

    private fun setUpObserves() {
        setUpObserveCompaniesReports()
    }

    private fun setUpObserveCompaniesReports() {
        viewModel.companiesReportsLive.observe(viewLifecycleOwner) {
            adapter.notifyItemRangeChanged(0, it.count())
        }
    }
}