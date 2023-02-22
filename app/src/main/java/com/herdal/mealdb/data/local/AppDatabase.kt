package com.herdal.mealdb.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.herdal.mealdb.data.local.dao.CategoryDao
import com.herdal.mealdb.data.local.dao.FavoriteDao
import com.herdal.mealdb.data.local.entity.CategoryEntity
import com.herdal.mealdb.data.local.entity.FavoriteEntity

@Database(
    entities = [
        CategoryEntity::class,
        FavoriteEntity::class
    ],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun favoriteDao(): FavoriteDao
}