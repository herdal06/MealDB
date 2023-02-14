package com.herdal.mealdb.common.mapper

interface Mapper<T, DomainModel> {
    fun toDomain(t: T): DomainModel
    fun fromDomain(domainModel: DomainModel): T
}