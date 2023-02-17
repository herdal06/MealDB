package com.herdal.mealdb.data.local.data_source

import com.herdal.mealdb.data.data_source.MealDataSource
import com.herdal.mealdb.data.local.dao.FavoriteDao
import com.herdal.mealdb.data.local.entity.FavoriteEntity
import com.herdal.mealdb.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MealLocalDataSource @Inject constructor(
    private val favoriteDao: FavoriteDao,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : MealDataSource.Local {
    override suspend fun addToFavorite(favorite: FavoriteEntity) =
        withContext(ioDispatcher) {
            favoriteDao.insert(favorite)
        }

    override fun getAllFavorites(): Flow<List<FavoriteEntity>> {
        return favoriteDao.getAll()
    }

    override suspend fun deleteFavorite(favorite: FavoriteEntity) =
        withContext(ioDispatcher) {
            favoriteDao.delete(favorite)
        }

    override suspend fun isFavorite(mealId: String): Boolean =
        withContext(Dispatchers.IO) {
            favoriteDao.isMealFavorite(mealId) != null
        }
}