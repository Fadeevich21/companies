package com.example.domain.model

data class Company(
    var id: String,
    var name: String,
    var ticker: String,
    var country: String,
    var sector: String,
    var companyAnalysisInfo: List<CompanyAnalysisInfo>,
    var reports: List<Report>,
)
