package com.example.companies.ui.adapter.companies

import android.annotation.SuppressLint
import com.example.companies.databinding.ItemCompanyBinding
import com.example.domain.model.Company
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

@SuppressLint("SetTextI18n")
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
                companyReportsNumber.text = "Отчёты: ${item.reports.count()}"
                companyAnalysisInfoNumber.text =
                    "Аналитические обзоры: ${item.companyAnalysisInfo.count()}"
            }
        }
    }