package com.example.companies.ui.adapter

import com.example.companies.R
import com.example.companies.databinding.ItemCompanyBinding
import com.example.domain.model.Company
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun companyAdapterDelegate(itemClickedListener: (Company) -> Unit) =
    adapterDelegateViewBinding<Company, Company, ItemCompanyBinding>({ layoutInflater, root ->
        ItemCompanyBinding.inflate(
            layoutInflater, root, false
        )
    }) {

        binding.root.setOnClickListener {
            itemClickedListener(item)
        }

        bind {
            with(binding) {
                companyName.text = item.name
                companyTicker.text = item.ticker
                companyReportsNumber.text =
                    getString(R.string.company_reports_number, item.reports.count())
                companyAnalysisInfoNumber.text = getString(
                    R.string.company_analysis_info_number,
                    item.companyAnalysisInfo.count()
                )
            }
        }
    }