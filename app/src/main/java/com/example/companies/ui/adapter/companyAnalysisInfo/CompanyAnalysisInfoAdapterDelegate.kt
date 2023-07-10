package com.example.companies.ui.adapter.companyAnalysisInfo

import android.annotation.SuppressLint
import com.example.companies.databinding.ItemCompanyAnalysisInfoBinding
import com.example.companies.model.CompanyCompanyAnalysisInfo
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import java.text.SimpleDateFormat

@SuppressLint("SimpleDateFormat")
fun companyAnalysisInfoAdapterDelegate(itemClickedListener: (CompanyCompanyAnalysisInfo) -> Unit) =
    adapterDelegateViewBinding<CompanyCompanyAnalysisInfo, CompanyCompanyAnalysisInfo, ItemCompanyAnalysisInfoBinding>(
        { layoutInflater, root ->
            ItemCompanyAnalysisInfoBinding.inflate(layoutInflater, root, false)
        }) {

        binding.root.setOnClickListener {
            itemClickedListener(item)
        }

        bind {
            with(binding) {
                companyName.text = item.company.name
                companyTicker.text = item.company.ticker

                val date = SimpleDateFormat("MM/dd/yyyy").parse(item.companyAnalysisInfo.date)
                val dateString = SimpleDateFormat("dd.MM.yyyy").format(date!!)
                companyAnalysisInfoDate.text = dateString
            }
        }
    }