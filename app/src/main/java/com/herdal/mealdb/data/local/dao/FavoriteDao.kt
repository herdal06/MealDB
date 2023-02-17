package com.herdal.mealdb.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.herdal.mealdb.data.local.entity.FavoriteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {

    @Query("SELECT * FROM favorite_meals WHERE id=:id")
    fun isMealFavorite(id: String): FavoriteEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(favorite: FavoriteEntity)

    @Query("SELECT * FROM favorite_meals")
    fun getAll(): Flow<List<FavoriteEntity>>

    @Delete
    suspend fun delete(favorite: FavoriteEntity)
}