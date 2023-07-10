package com.example.data.mapper

import com.example.data.mapper.utils.DtoMapper
import com.example.data.storage.model.CompanyAnalysisInfoDto
import com.example.domain.model.CompanyAnalysisInfo
import javax.inject.Inject

class CompanyAnalysisInfoMapper @Inject constructor() :
    DtoMapper<CompanyAnalysisInfoDto, CompanyAnalysisInfo> {

    override fun mapFromDto(dto: CompanyAnalysisInfoDto): CompanyAnalysisInfo {
        return CompanyAnalysisInfo(
            date = dto.date,
            url = dto.url,
        )
    }

    override fun mapToDto(domainModel: CompanyAnalysisInfo): CompanyAnalysisInfoDto {
        return CompanyAnalysisInfoDto(
            date = domainModel.date,
            url = domainModel.url,
        )
    }
}