package com.miguelhhtc.cocktaildemo.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.miguelhhtc.cocktaildemo.model.DrinkItem
import com.miguelhhtc.cocktaildemo.repository.MainRepository

private const val TAG: String = "MainViewModel"

class MainViewModel : ViewModel() {

    private val repo = MainRepository()
    private val mutableData = MutableLiveData<MutableList<DrinkItem>>()

    init {
        Log.d(TAG, "Init")

        setup()
    }

    fun setup() {
        repo.getCocktailData().observeForever {
            mutableData.value = it
        }
    }

    fun fetchCocktailData(): LiveData<MutableList<DrinkItem>> {
        return mutableData
    }

    fun fetchCocktailFilteredData(drinkName:String){
        repo.getCocktailFilteredList(drinkName).observeForever{
            mutableData.value = it
        }
    }


}