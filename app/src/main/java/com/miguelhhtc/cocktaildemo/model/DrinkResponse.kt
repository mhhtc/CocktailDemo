package com.miguelhhtc.cocktaildemo.model

import com.google.gson.annotations.SerializedName

data class DrinkResponse(
	@field:SerializedName("drinks")
	val drinks: List<DrinkItem?>? = null
)

