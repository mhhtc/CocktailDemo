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

class DetailRepository {

    private var apiclient: ClientServices? = null

    init {
        apiclient = ClientAPI.client.create(ClientServices::class.java)
    }

    fun getCocktailDetailData(drinkId:Int): LiveData<DrinkItem> {
        val mutableData = MutableLiveData<DrinkItem>()
        val call = apiclient?.getCocktailDetail(drinkId)
        call?.enqueue(object : Callback<DrinkResponse> {
            override fun onFailure(call: Call<DrinkResponse>, t: Throwable?) {
                Log.d("failure", t.toString())
            }
            override fun onResponse(call: Call<DrinkResponse>, response: Response<DrinkResponse>?) {
                if (response?.isSuccessful!!) {
                    val result: DrinkResponse = response.body() as DrinkResponse
                    mutableData.value = result.drinks?.get(0)
                }
            }
        })
        return mutableData
    }
}