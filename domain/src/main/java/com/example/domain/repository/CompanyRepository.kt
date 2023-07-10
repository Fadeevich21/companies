package com.example.domain.repository

import com.example.domain.model.Company

interface CompanyRepository {

    suspend fun getAllCompanies(): List<Company>
}