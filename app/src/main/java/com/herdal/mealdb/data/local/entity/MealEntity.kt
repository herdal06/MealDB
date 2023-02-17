package com.herdal.mealdb.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meals")
data class MealEntity(
    @PrimaryKey(autoGenerate = true)
    val id: String,
    @ColumnInfo(name = "area")
    val area: String,
    @ColumnInfo(name = "category")
    val category: String,
    @ColumnInfo(name = "instruction")
    val instruction: String,
    @ColumnInfo(name = "strIngredient1")
    val strIngredient1: String,
    @ColumnInfo(name = "strIngredient2")
    val strIngredient2: String,
    @ColumnInfo(name = "strIngredient3")
    val strIngredient3: String,
    @ColumnInfo(name = "strIngredient4")
    val strIngredient4: String,
    @ColumnInfo(name = "strIngredient5")
    val strIngredient5: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "thumbnail")
    val thumbnail: String,
    @ColumnInfo(name = "youtube_link")
    val youtubeLink: String,
    @ColumnInfo(name = "is_favorite")
    var isFavorite: Boolean = false
)