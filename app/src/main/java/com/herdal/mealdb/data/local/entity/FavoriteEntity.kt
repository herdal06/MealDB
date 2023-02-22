package com.herdal.mealdb.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_meals")
data class FavoriteEntity(
    @PrimaryKey
    val id: String,
    @ColumnInfo(name = "strMeal")
    val name: String,
    @ColumnInfo(name = "strMealThumb")
    val thumbnail: String?,
    @ColumnInfo(name = "is_favorite")
    val isFavorite: Boolean? = false
)