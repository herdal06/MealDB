package com.herdal.mealdb.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.herdal.mealdb.data.local.dao.CategoryDao
import com.herdal.mealdb.data.local.entity.CategoryEntity

@Database(
    entities = [CategoryEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
}