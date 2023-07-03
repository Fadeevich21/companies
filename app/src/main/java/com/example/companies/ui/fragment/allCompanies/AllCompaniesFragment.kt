package com.example.companies.ui.fragment.allCompanies

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.companies.databinding.FragmentAllCompaniesBinding
import com.example.companies.ui.adapter.CompaniesAdapter
import com.example.companies.ui.adapter.companyAdapterDelegate
import com.example.companies.ui.decoration.VerticalListItemDecoration
import com.example.companies.ui.utils.MultiViewModelFactory
import com.example.companies.utils.appComponent
import javax.inject.Inject

class AllCompaniesFragment : Fragment() {

    private var _binding: FragmentAllCompaniesBinding? = null
    private val binding get() = _binding!!

    private val adapter = CompaniesAdapter(
        companyAdapterDelegate { viewModel.onCompanyClick(it) }
    )

    @Inject
    lateinit var viewModelFactory: MultiViewModelFactory

    private val viewModel: AllCompaniesViewModel by viewModels {
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
        _binding = FragmentAllCompaniesBinding.inflate(inflater, container, false)

        adapter.items = viewModel.companiesLive.value

        setUpBinding()
        setUpObserves()

        return binding.root
    }

    private fun setUpBinding() {
        setUpCompaniesContainer()
    }

    private fun setUpCompaniesContainer() = with(binding) {
        companiesContainer.layoutManager = LinearLayoutManager(context)
        companiesContainer.adapter = adapter
        companiesContainer.addItemDecoration(
            VerticalListItemDecoration(
                vertical = 10,
                horizontal = 20,
                betweenItem = 10,
            )
        )
    }

    private fun setUpObserves() {
        setUpObserveCompanies()
        setUpObserveActionNavigate()
    }

    private fun setUpObserveCompanies() {
        viewModel.companiesLive.observe(viewLifecycleOwner) {
            adapter.notifyItemRangeChanged(0, it.count())
        }
    }

    private fun setUpObserveActionNavigate() {
        viewModel.actionNavigateLive.observe(viewLifecycleOwner) { event ->
            event.getContentIfNotHandled()?.let { action ->
                findNavController().navigate(action)
            }
        }
    }
}