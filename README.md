<h1 align="center">🍔 MealDB</h1>

<p align="center">  
MealDB is an android application using Free Meal API based on MVVM with a clean architecture.
<br/>
<p align="center">For API Documentation: <a href="https://www.themealdb.com/api.php">Click here</a></p>
</p>


### App Screenshots

| home screen | categories | meal detail |
|:-:|:-:|:-:|
| <img src="https://github.com/herdal06/MealDB/blob/master/arts/home.png?raw=true" alt="drawing" width="250"/> | <img src="https://github.com/herdal06/MealDB/blob/master/arts/categories.png?raw=true" alt="drawing" width="250"/> | <img src="https://github.com/herdal06/MealDB/blob/master/arts/meal_detail.png?raw=true" alt="drawing" width="250"/> 
| search meals | favorite meals |
| <img src="https://github.com/herdal06/MealDB/blob/master/arts/search_meals.png?raw=true" alt="drawing" width="250"/> | <img src="https://github.com/herdal06/MealDB/blob/master/arts/fav_meals.png?raw=true://github.com/herdal06/HekMovie/blob/master/arts/6.png?raw=true" alt="drawing" width="250"/> 

### App Gif

<img src="https://github.com/herdal06/MealDB/blob/master/arts/appvideo.gif?raw=true"  width="250"/>

## Tech stack
* ✅ MVVM with Clean Architecture
* ✅ [Kotlin Flow][33] - In coroutines, a flow is a type that can emit multiple values sequentially, as opposed to suspend functions that return only a single value.
* ✅ [LiveData][31] - is an observable data holder class. Unlike a regular observable, LiveData is lifecycle-aware, meaning it respects the lifecycle of other app components, such as activities, fragments, or services.
* ✅ [Coroutines][51] - A concurrency design pattern that you can use on Android to simplify code that executes asynchronously.
* ✅ [Navigation Component][24] - Handle everything needed for in-app navigation. asynchronous tasks for optimal execution.
* ✅ [Safe-Args][25] - For passing data between destinations
* ✅ [Dagger-Hilt][93] - A dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in your project.
* ✅ [ViewModel][17] - Easily schedule asynchronous tasks for optimal execution.
* ✅ [Retrofit][90]- Retrofit is a REST client for Java/ Kotlin and Android by Square inc under Apache 2.0 license. Its a simple network library that is used for network transactions. By using this library we can seamlessly capture JSON response from web service/web API.
* ✅ [OkHttp][23] - Doing HTTP efficiently makes your stuff load faster and saves bandwidth.
* ✅ [Room][32] - The Room persistence library provides an abstraction layer over SQLite to allow for more robust database access while harnessing the full power of SQLite.
* ✅ [Moshi][95] - A modern JSON library for Kotlin and Java.
* ✅ [View Binding][11] - a feature that allows you to more easily write code that interacts with views.
* ✅ [Data Binding][86] - The Data Binding Library is a support library that allows you to bind UI components in your layouts to data sources in your app using a declarative format rather than programmatically.
* ✅ [Lifecycle][22] - As a user navigates through, out of, and back to your app, the Activity instances in your app transition through different states in their lifecycle.
* ✅ [Epoxy][21] - Epoxy is an Android library for building complex screens in a RecyclerView. Models are automatically generated from custom views or databinding layouts via annotation processing. These models are then used in an EpoxyController to declare what items to show in the RecyclerView.
* ✅ [recyclerview-animators][12] - RecyclerView Animators is an Android library that allows developers to easily create RecyclerView with animations.
* ✅ [Glide][27] - for image loading framework for Android that wraps media decoding, memory and disk caching, and resource pooling into a simple and easy to use interface.
* ✅ [Timber][9] - This is a logger with a small, extensible API which provides utility on top of Android's normal Log class.
* ✅ [leakcanary][14] - A memory leak detection library for Android.

[11]: https://developer.android.com/topic/libraries/view-binding
[92]: https://coil-kt.github.io/coil/
[93]: https://developer.android.com/training/dependency-injection/hilt-android
[51]: https://developer.android.com/kotlin/coroutines
[90]: https://square.github.io/retrofit/
[33]: https://developer.android.com/kotlin/flow
[22]: https://developer.android.com/guide/components/activities/activity-lifecycle
[17]: https://developer.android.com/topic/libraries/architecture/viewmodel?gclid=Cj0KCQiA4uCcBhDdARIsAH5jyUlE1HL0TNxXu5b4pw6DEMOlRccWdVnqiRcLji7OHsDN6trNOKa-sdgaAr6rEALw_wcB&gclsrc=aw.ds
[23]: https://square.github.io/okhttp/
[24]: https://developer.android.com/guide/navigation/navigation-getting-started
[25]: https://developer.android.com/guide/navigation/navigation-pass-data
[31]: https://developer.android.com/topic/libraries/architecture/livedata
[27]: https://github.com/bumptech/glide
[86]: https://developer.android.com/topic/libraries/data-binding
[95]: https://github.com/square/moshi
[9]: https://github.com/JakeWharton/timber
[21]: https://github.com/airbnb/epoxy
[12]: https://github.com/wasabeef/recyclerview-animators
[14]: https://github.com/square/leakcanary
[32]: https://developer.android.com/training/data-storage/room
