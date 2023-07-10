package com.example.companies.ui.fragment.companiesAnalysisInfo

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.companies.model.CompanyCompanyAnalysisInfo
import com.example.domain.model.CompanyAnalysisInfo
import com.example.domain.useCase.model.CompanyUseCases
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import javax.inject.Inject

class CompaniesAnalysisInfoViewModel @Inject constructor(
    private val companyUseCases: CompanyUseCases
) : ViewModel() {

    private val companiesCompaniesAnalysisInfo = mutableListOf<CompanyCompanyAnalysisInfo>()
    private var companiesCompaniesAnalysisInfoLiveMutable =
        MutableLiveData<List<CompanyCompanyAnalysisInfo>>()
    val companiesCompaniesAnalysisInfoLive: LiveData<List<CompanyCompanyAnalysisInfo>> =
        companiesCompaniesAnalysisInfoLiveMutable

    init {
        loadCompaniesCompaniesAnalysisInfo()
    }

    fun onCompanyAnalysisInfoClick(companyAnalysisInfo: CompanyAnalysisInfo) {
        TODO("Not yet implemented")
    }

    @SuppressLint("SimpleDateFormat")
    private fun loadCompaniesCompaniesAnalysisInfo() = viewModelScope.launch {
        companiesCompaniesAnalysisInfo.clear()
        companiesCompaniesAnalysisInfo.addAll(
            companyUseCases.getAllCompaniesUseCase().map { company ->
                company.companyAnalysisInfo.map { companyAnalysisInfo ->
                    CompanyCompanyAnalysisInfo(company, companyAnalysisInfo)
                }.sortedBy {
                    SimpleDateFormat("MM/dd/yyyy").parse(it.companyAnalysisInfo.date)
                }
            }.flatten()
        )

        companiesCompaniesAnalysisInfoLiveMutable.value = companiesCompaniesAnalysisInfo
    }
}