package com.miguelhhtc.cocktaildemo.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.miguelhhtc.cocktaildemo.model.DrinkItem
import com.miguelhhtc.cocktaildemo.repository.DetailRepository

private const val TAG: String = "DetailViewModel"

class DetailViewModel : ViewModel() {

    private val repo = DetailRepository()

    fun fetchCocktailDetailData(drinkId: Int): LiveData<DrinkItem> {
        val mutableData = MutableLiveData<DrinkItem>()
        repo.getCocktailDetailData(drinkId).observeForever {
            mutableData.value = it
        }

        return mutableData
    }

}