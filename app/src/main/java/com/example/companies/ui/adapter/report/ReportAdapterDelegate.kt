package com.example.companies.ui.adapter.report

import android.annotation.SuppressLint
import com.example.companies.databinding.ItemReportBinding
import com.example.companies.model.CompanyReport
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import java.text.SimpleDateFormat

@SuppressLint("SimpleDateFormat")
fun reportAdapterDelegate(itemClickedListener: (CompanyReport) -> Unit) =
    adapterDelegateViewBinding<CompanyReport, CompanyReport, ItemReportBinding>({ layoutInflater, root ->
        ItemReportBinding.inflate(layoutInflater, root, false)
    }) {

        binding.root.setOnClickListener {
            itemClickedListener(item)
        }

        bind {
            with(binding) {
                companyName.text = item.company.name
                companyTicker.text = item.company.ticker

                val date = SimpleDateFormat("MM/dd/yyyy").parse(item.report.date)
                val dateString = SimpleDateFormat("dd.MM.yyyy").format(date!!)
                reportDate.text = dateString
            }
        }
    }