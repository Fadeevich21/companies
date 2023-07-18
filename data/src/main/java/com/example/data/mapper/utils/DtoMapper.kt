package com.example.data.mapper.utils

interface DtoMapper<Dto, DomainModel> {

    fun mapFromDto(dto: Dto): DomainModel
    fun mapToDto(domainModel: DomainModel): Dto

    fun fromDtoList(initial: List<Dto>): List<DomainModel> {
        return initial.map { mapFromDto(it) }
    }

    fun toDtoList(initial: List<DomainModel>): List<Dto> {
        return initial.map { mapToDto(it) }
    }
}