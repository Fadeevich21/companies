package com.example.data.mapper

import com.example.data.mapper.utils.DtoMapper
import com.example.data.storage.model.ReportDto
import com.example.domain.model.Report
import javax.inject.Inject

class ReportMapper @Inject constructor() : DtoMapper<ReportDto, Report> {

    override fun mapFromDto(dto: ReportDto): Report {
        return Report(
            period = dto.period,
            date = dto.date,
            url = dto.url,
        )
    }

    override fun mapToDto(domainModel: Report): ReportDto {
        return ReportDto(
            period = domainModel.period,
            date = domainModel.date,
            url = domainModel.url,
        )
    }
}