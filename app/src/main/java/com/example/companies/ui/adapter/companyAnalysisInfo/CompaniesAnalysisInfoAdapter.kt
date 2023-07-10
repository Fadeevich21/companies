package com.example.companies.ui.adapter.companyAnalysisInfo

import androidx.recyclerview.widget.DiffUtil
import com.example.companies.model.CompanyCompanyAnalysisInfo
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class CompaniesAnalysisInfoAdapter(
    vararg adapterDelegates: AdapterDelegate<List<CompanyCompanyAnalysisInfo>>
) : AsyncListDifferDelegationAdapter<CompanyCompanyAnalysisInfo>(ReportComparator()) {

    init {
        for (adapterDelegate in adapterDelegates) {
            delegatesManager.addDelegate(adapterDelegate)
        }
    }

    private class ReportComparator : DiffUtil.ItemCallback<CompanyCompanyAnalysisInfo>() {

        override fun areItemsTheSame(
            oldItem: CompanyCompanyAnalysisInfo, newItem: CompanyCompanyAnalysisInfo
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: CompanyCompanyAnalysisInfo, newItem: CompanyCompanyAnalysisInfo
        ): Boolean {
            return oldItem.companyAnalysisInfo.date == newItem.companyAnalysisInfo.date
        }
    }
}