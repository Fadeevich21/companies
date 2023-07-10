package com.example.domain.useCase

import com.example.domain.repository.CompanyRepository
import javax.inject.Inject

class GetAllCompaniesUseCase @Inject constructor(private val repository: CompanyRepository) {

    suspend operator fun invoke() =
        repository.getAllCompanies().sortedWith(compareBy { it.name }).filter { it.id.isNotBlank() }
}