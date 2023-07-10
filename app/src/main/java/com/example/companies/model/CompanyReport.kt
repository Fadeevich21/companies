package com.example.companies.model

import com.example.domain.model.Company
import com.example.domain.model.Report

data class CompanyReport(
    val company: Company,
    val report: Report,
)
