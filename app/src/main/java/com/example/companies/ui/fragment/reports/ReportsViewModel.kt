package com.example.companies.ui.fragment.reports

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.companies.model.CompanyReport
import com.example.domain.model.Report
import com.example.domain.useCase.model.CompanyUseCases
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import javax.inject.Inject

class ReportsViewModel @Inject constructor(
    private val companyUseCases: CompanyUseCases
) : ViewModel() {

    private val companiesReports = mutableListOf<CompanyReport>()
    private var companiesReportsLiveMutable = MutableLiveData<List<CompanyReport>>()
    val companiesReportsLive: LiveData<List<CompanyReport>> = companiesReportsLiveMutable

    init {
        loadCompaniesReports()
    }

    fun onReportClick(report: Report) {
        TODO("Not yet implemented")
    }

    @SuppressLint("SimpleDateFormat")
    private fun loadCompaniesReports() = viewModelScope.launch {
        companiesReports.clear()
        companiesReports.addAll(companyUseCases.getAllCompaniesUseCase().map { company ->
            company.reports.map { report ->
                CompanyReport(company, report)
            }.sortedBy {
                SimpleDateFormat("MM/dd/yyyy").parse(it.report.date)
            }
        }.flatten())

        companiesReportsLiveMutable.value = companiesReports
    }
}