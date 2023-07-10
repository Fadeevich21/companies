package com.example.data.mapper

import com.example.data.mapper.utils.DtoMapper
import com.example.data.storage.model.CompanyDto
import com.example.domain.model.Company
import javax.inject.Inject

class CompanyMapper @Inject constructor(
    private val companyAnalysisInfoMapper: CompanyAnalysisInfoMapper,
    private val reportMapper: ReportMapper,
) : DtoMapper<CompanyDto, Company> {

    override fun mapFromDto(dto: CompanyDto): Company {
        return Company(
            id = dto.id,
            name = dto.name,
            ticker = dto.ticker,
            country = dto.country,
            sector = dto.sector,
            companyAnalysisInfo = companyAnalysisInfoMapper.fromDtoList(dto.companyAnalysisInfo),
            reports = reportMapper.fromDtoList(dto.reports),
        )
    }

    override fun mapToDto(domainModel: Company): CompanyDto {
        return CompanyDto(
            id = domainModel.id,
            name = domainModel.name,
            ticker = domainModel.ticker,
            country = domainModel.country,
            sector = domainModel.sector,
            companyAnalysisInfo = companyAnalysisInfoMapper.toDtoList(domainModel.companyAnalysisInfo),
            reports = reportMapper.toDtoList(domainModel.reports),
        )
    }
}