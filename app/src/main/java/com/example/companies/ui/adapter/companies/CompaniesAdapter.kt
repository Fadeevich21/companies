package com.example.companies.ui.adapter.companies

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.model.Company
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class CompaniesAdapter(vararg adapterDelegates: AdapterDelegate<List<Company>>) :
    AsyncListDifferDelegationAdapter<Company>(CompanyComparator()) {

    init {
        for (adapterDelegate in adapterDelegates) {
            delegatesManager.addDelegate(adapterDelegate)
        }
    }

    private class CompanyComparator : DiffUtil.ItemCallback<Company>() {

        override fun areItemsTheSame(oldItem: Company, newItem: Company): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Company, newItem: Company): Boolean {
            return oldItem.name == newItem.name
        }
    }
}