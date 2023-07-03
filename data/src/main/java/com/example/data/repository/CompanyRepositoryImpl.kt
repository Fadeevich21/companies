package com.example.data.repository

import com.example.data.storage.utils.CompanyStorage
import com.example.data.mapper.CompanyMapper
import com.example.domain.model.Company
import com.example.domain.repository.CompanyRepository
import javax.inject.Inject

class CompanyRepositoryImpl @Inject constructor(
    private val companyStorage: CompanyStorage,
    private val companyMapper: CompanyMapper,
) : CompanyRepository {

    override suspend fun getAllCompanies(): List<Company> {
        val companiesDto = companyStorage.getAllCompanies()
        return companyMapper.fromDtoList(companiesDto)
    }
}