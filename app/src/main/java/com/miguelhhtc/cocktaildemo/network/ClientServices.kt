package com.miguelhhtc.cocktaildemo.network

import com.miguelhhtc.cocktaildemo.model.DrinkResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ClientServices {

    @GET("filter.php?c=Cocktail")
    fun getCocktailList(): Call<DrinkResponse>

    @GET("search.php")
    fun getCocktailFilteredList(@Query("f") drinkName: String): Call<DrinkResponse>

    @GET("lookup.php")
    fun getCocktailDetail(@Query("i") drinkId: Int): Call<DrinkResponse>

}