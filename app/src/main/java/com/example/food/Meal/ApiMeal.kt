package com.example.food.Code_Main_interface

import MealResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query



 val the_retrofit = Retrofit.Builder().baseUrl("http://www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()



val recipeMealService = the_retrofit.create(ApiMealService::class.java)





interface ApiMealService {
    @GET("search.php")
    suspend fun getComponents(@Query("s") search: String): MealResponse
}

//www.themealdb.com/api/json/v1/1/search.php?s=Arrabiata