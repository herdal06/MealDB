package com.herdal.mealdb

import Versions

object Libs {
    object AndroidX {
        const val core = "androidx.core:core-ktx:" + Versions.coreKtx
        const val appCompat = "androidx.appcompat:appcompat:" + Versions.appCompat
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:" + Versions.constraint
        const val vmLifeCycle = "androidx.lifecycle:lifecycle-viewmodel-ktx:" + Versions.viewModel
        const val navigation = "androidx.navigation:navigation-fragment-ktx:" + Versions.navigation
        const val navigationUI = "androidx.navigation:navigation-ui-ktx:" + Versions.navigation
        const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:" + Versions.livedata
        const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:" + Versions.runtime
        const val extensions = "androidx.lifecycle:lifecycle-extensions:" + Versions.extensions
        const val safeArgs =
            "androidx.navigation:navigation-safe-args-gradle-plugin:" + Versions.safeArgs
        const val swipe_refresh_layout =
            "androidx.swiperefreshlayout:swiperefreshlayout:" + Versions.swipe_refresh_layout
    }

    object Google {
        const val material = "com.google.android.material:material:" + Versions.material
        const val gson = "com.google.code.gson:gson:" + Versions.gson
    }

    object Hilt {
        const val android = "com.google.dagger:hilt-android:" + Versions.hilt
        const val compiler = "com.google.dagger:hilt-android-compiler:" + Versions.hiltCompiler
        const val plugin = "com.google.dagger:hilt-android-gradle-plugin:" + Versions.hilt
    }

    object Network {
        const val retrofit = "com.squareup.retrofit2:retrofit:" + Versions.retrofit
        const val moshiConverter = "com.squareup.retrofit2:converter-moshi:" + Versions.retrofit
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:" + Versions.retrofit
        const val okhttp = "com.squareup.okhttp3:okhttp:" + Versions.ok_http
        const val interceptor = "com.squareup.okhttp3:logging-interceptor:" + Versions.ok_http
        const val moshi = "com.squareup.moshi:moshi-kotlin:" + Versions.moshi
        const val codegen = "com.squareup.moshi:moshi-kotlin-codegen:" + Versions.moshi
    }

    object Storage {
        const val dataStore = "androidx.datastore:datastore-preferences:" + Versions.dataStore

        object Room {
            const val ktx = "androidx.room:room-ktx:" + Versions.room
            const val runtime = "androidx.room:room-runtime:" + Versions.room
            const val compiler = "androidx.room:room-compiler:" + Versions.room
        }
    }

    object Image {
        const val glide = "com.github.bumptech.glide:glide:" + Versions.glide
        const val compiler = "com.github.bumptech.glide:compiler:" + Versions.glide
    }

    object Test {
        const val junit = "junit:junit:" + Versions.junit
        const val testExt = "androidx.test.ext:junit:" + Versions.testExt
        const val espresso = "androidx.test.espresso:espresso-core:" + Versions.espresso
    }

    object Log {
        const val logger = "com.orhanobut:logger:" + Versions.logger
        const val timber = "com.jakewharton.timber:timber:" + Versions.timber
    }

    object View {
        const val lottie = "com.airbnb.android:lottie:" + Versions.lottie
        const val shimmerEffect = "com.facebook.shimmer:shimmer:" + Versions.shimmer
    }

    object LeakDetection {
        const val leakCanary = "com.squareup.leakcanary:leakcanary-android:" + Versions.leakCanary
    }

    object RecyclerView {
        const val epoxy = "com.airbnb.android:epoxy:" + Versions.epoxy
        const val epoxyProcessor = "com.airbnb.android:epoxy-processor:" + Versions.epoxy
        const val rvAnimators = "jp.wasabeef:recyclerview-animators:" + Versions.rvAnimators
    }
}