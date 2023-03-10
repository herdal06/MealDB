package com.herdal.mealdb.di

import com.herdal.mealdb.data.repository.CategoryRepositoryImpl
import com.herdal.mealdb.data.repository.MealRepositoryImpl
import com.herdal.mealdb.domain.repository.CategoryRepository
import com.herdal.mealdb.domain.repository.MealRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@[Module InstallIn(SingletonComponent::class)]
abstract class RepositoryModule {

    @Binds
    abstract fun bindCategoryRepository(categoryRepositoryImpl: CategoryRepositoryImpl): CategoryRepository

    @Binds
    abstract fun bindMealRepository(mealRepositoryImpl: MealRepositoryImpl): MealRepository
}