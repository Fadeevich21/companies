package com.example.companies.ui.fragment.allCompanies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.example.companies.ui.utils.Event
import com.example.domain.model.Company
import com.example.domain.useCase.model.CompanyUseCases
import kotlinx.coroutines.launch
import javax.inject.Inject

class AllCompaniesViewModel @Inject constructor(
    private val companyUseCases: CompanyUseCases
) : ViewModel() {

    private var actionNavigateLiveMutable = MutableLiveData<Event<NavDirections>>()
    val actionNavigateLive: LiveData<Event<NavDirections>> = actionNavigateLiveMutable

    private val companies = mutableListOf<Company>()
    private var companiesLiveMutable = MutableLiveData<List<Company>>()
    val companiesLive: LiveData<List<Company>> = companiesLiveMutable

    init {
        loadCompanies()
    }

    private fun loadCompanies() = viewModelScope.launch {
        companies.clear()
        companies.addAll(companyUseCases.getAllCompaniesUseCase())
        companiesLiveMutable.value = companies
    }

    fun onCompanyClick(company: Company) {
        TODO("Not yet implemented")
    }
}