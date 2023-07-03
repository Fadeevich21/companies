package com.example.data.storage.model

data class CompanyDto(
    val id: String,
    val name: String,
    val ticker: String,
    val country: String,
    val sector: String,
    val companyAnalysisInfo: List<CompanyAnalysisInfoDto>,
    val reports: List<ReportDto>,
)
