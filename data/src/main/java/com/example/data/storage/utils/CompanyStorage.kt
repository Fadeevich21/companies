package com.example.data.storage.utils

import com.example.data.storage.model.CompanyDto
import java.io.InputStream

interface CompanyStorage {

    suspend fun getAllCompanies(): List<CompanyDto>
}