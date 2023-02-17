package com.herdal.mealdb.di

import com.herdal.mealdb.common.mapper.category.CategoryDtoMapper
import com.herdal.mealdb.common.mapper.category.CategoryEntityMapper
import com.herdal.mealdb.common.mapper.favorite.FavoriteEntityMapper
import com.herdal.mealdb.common.mapper.meal.MealDtoMapper
import com.herdal.mealdb.common.mapper.meal_details.MealDetailsDtoMapper
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

    @Provides
    @Singleton
    fun provideMealDtoMapper(
    ): MealDtoMapper = MealDtoMapper()

    @Provides
    @Singleton
    fun provideMealDetailsDtoMapper(
    ): MealDetailsDtoMapper = MealDetailsDtoMapper()

    @Provides
    @Singleton
    fun provideFavoriteEntityMapper(
    ): FavoriteEntityMapper = FavoriteEntityMapper()
}