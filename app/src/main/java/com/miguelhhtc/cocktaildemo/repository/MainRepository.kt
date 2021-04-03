package com.miguelhhtc.cocktaildemo.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.miguelhhtc.cocktaildemo.model.DrinkResponse
import com.miguelhhtc.cocktaildemo.model.DrinkItem
import com.miguelhhtc.cocktaildemo.network.ClientAPI
import com.miguelhhtc.cocktaildemo.network.ClientServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository {

    private var apiclient: ClientServices? = null

    init {
        apiclient = ClientAPI.client.create(ClientServices::class.java)
    }

    fun getCocktailData(): LiveData<MutableList<DrinkItem>> {
        val mutableData = MutableLiveData<MutableList<DrinkItem>>()
        val call = apiclient?.getCocktailList()
        call?.enqueue(object : Callback<DrinkResponse> {
            override fun onFailure(call: Call<DrinkResponse>, t: Throwable?) {
                Log.d("failure", t.toString())
            }
            override fun onResponse(call: Call<DrinkResponse>, response: Response<DrinkResponse>?) {
                if (response?.isSuccessful!!) {
                    val resultsList: DrinkResponse = response.body() as DrinkResponse
                    mutableData.value = resultsList.drinks as MutableList<DrinkItem>
                }
            }
        })
        return mutableData
    }


    fun getCocktailFilteredList(drinkName:String): LiveData<MutableList<DrinkItem>> {
        val mutableData = MutableLiveData<MutableList<DrinkItem>>()
        val call = apiclient?.getCocktailFilteredList(drinkName)
        call?.enqueue(object : Callback<DrinkResponse> {
            override fun onFailure(call: Call<DrinkResponse>, t: Throwable?) {
                Log.d("failure", t.toString())
            }
            override fun onResponse(call: Call<DrinkResponse>, response: Response<DrinkResponse>?) {
                if (response?.isSuccessful!!) {
                    val resultsList: DrinkResponse = response.body() as DrinkResponse
                    try {
                        mutableData.value = resultsList.drinks as MutableList<DrinkItem>
                    }catch (e: Exception){}
                }
            }
        })
        return mutableData
    }

}