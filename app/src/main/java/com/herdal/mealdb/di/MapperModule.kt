package com.herdal.mealdb.di

import com.herdal.mealdb.common.mapper.category.CategoryDtoMapper
import com.herdal.mealdb.common.mapper.category.CategoryEntityMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
object MapperModule {

    @Provides
    @Singleton
    fun provideCategoryDtoMapper(
    ): CategoryDtoMapper = CategoryDtoMapper()

    @Provides
    @Singleton
    fun provideCategoryEntity(
    ): CategoryEntityMapper = CategoryEntityMapper()
}