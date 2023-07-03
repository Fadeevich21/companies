package com.example.domain.useCase.model

import com.example.domain.useCase.GetAllCompaniesUseCase
import javax.inject.Inject

data class CompanyUseCases @Inject constructor(
    val getAllCompaniesUseCase: GetAllCompaniesUseCase,
)
