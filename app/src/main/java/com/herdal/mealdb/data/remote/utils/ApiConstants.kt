package com.herdal.mealdb.data.remote.utils

object ApiConstants {
    const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

    object Endpoints {
        const val CATEGORIES = "categories.php"
        const val MEAL_DETAILS = "lookup.php"
        const val SEARCH_MEALS = "search.php"
        const val MEALS = "filter.php"
    }
}