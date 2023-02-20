package com.herdal.mealdb.di

import com.herdal.mealdb.data.data_source.CategoryDataSource
import com.herdal.mealdb.data.data_source.MealDataSource
import com.herdal.mealdb.data.local.data_source.CategoryLocalDataSource
import com.herdal.mealdb.data.local.data_source.MealLocalDataSource
import com.herdal.mealdb.data.remote.data_source.CategoryRemoteDataSource
import com.herdal.mealdb.data.remote.data_source.MealRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@[Module InstallIn(SingletonComponent::class)]
abstract class DataSourceModule {

    @Binds
    abstract fun bindCategoryRemoteDataSource(categoryRemoteDataSource: CategoryRemoteDataSource): CategoryDataSource.Remote

    @Binds
    abstract fun bindCategoryLocalDataSource(categoryLocalDataSource: CategoryLocalDataSource): CategoryDataSource.Local

    @Binds
    abstract fun bindMealRemoteDataSource(mealRemoteDataSource: MealRemoteDataSource): MealDataSource.Remote

    @Binds
    abstract fun bindMealLocalDataSource(mealLocalDataSource: MealLocalDataSource): MealDataSource.Local
}