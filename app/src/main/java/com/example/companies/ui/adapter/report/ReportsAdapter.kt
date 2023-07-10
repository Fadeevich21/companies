package com.example.companies.ui.adapter.report

import androidx.recyclerview.widget.DiffUtil
import com.example.companies.model.CompanyReport
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class ReportsAdapter(vararg adapterDelegates: AdapterDelegate<List<CompanyReport>>) :
    AsyncListDifferDelegationAdapter<CompanyReport>(ReportComparator()) {

    init {
        for (adapterDelegate in adapterDelegates) {
            delegatesManager.addDelegate(adapterDelegate)
        }
    }

    private class ReportComparator : DiffUtil.ItemCallback<CompanyReport>() {

        override fun areItemsTheSame(oldItem: CompanyReport, newItem: CompanyReport): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: CompanyReport, newItem: CompanyReport): Boolean {
            return oldItem.report.date == newItem.report.date
        }
    }
}