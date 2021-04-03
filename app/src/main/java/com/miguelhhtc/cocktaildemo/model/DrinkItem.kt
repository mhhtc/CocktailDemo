package com.miguelhhtc.cocktaildemo.model

import com.google.gson.annotations.SerializedName

data class DrinkItem(

    @field:SerializedName("strImageSource")
    val strImageSource: String? = null,

    @field:SerializedName("strIngredient10")
    val strIngredient10: String? = null,

    @field:SerializedName("strDrink")
    val strDrink: String? = null,

    @field:SerializedName("strIngredient12")
    val strIngredient12: String? = null,

    @field:SerializedName("strIngredient11")
    val strIngredient11: String? = null,

    @field:SerializedName("strIngredient14")
    val strIngredient14: String? = null,

    @field:SerializedName("strCategory")
    val strCategory: String? = null,

    @field:SerializedName("strAlcoholic")
    val strAlcoholic: String? = null,

    @field:SerializedName("strIngredient13")
    val strIngredient13: String? = null,

    @field:SerializedName("strIngredient15")
    val strIngredient15: String? = null,

    @field:SerializedName("strCreativeCommonsConfirmed")
    val strCreativeCommonsConfirmed: String? = null,

    @field:SerializedName("strIBA")
    val strIBA: String? = null,

    @field:SerializedName("strVideo")
    val strVideo: Any? = null,

    @field:SerializedName("strTags")
    val strTags: String? = null,

    @field:SerializedName("strInstructions")
    val strInstructions: String? = null,

    @field:SerializedName("strIngredient1")
    val strIngredient1: String? = null,

    @field:SerializedName("strIngredient3")
    val strIngredient3: String? = null,

    @field:SerializedName("strIngredient2")
    val strIngredient2: String? = null,

    @field:SerializedName("strIngredient5")
    val strIngredient5: String? = null,

    @field:SerializedName("strIngredient4")
    val strIngredient4: String? = null,

    @field:SerializedName("strIngredient7")
    val strIngredient7: String? = null,

    @field:SerializedName("strIngredient6")
    val strIngredient6: String? = null,

    @field:SerializedName("strIngredient9")
    val strIngredient9: String? = null,

    @field:SerializedName("strInstructionsFR")
    val strInstructionsFR: Any? = null,

    @field:SerializedName("strIngredient8")
    val strIngredient8: String? = null,

    @field:SerializedName("idDrink")
    val idDrink: Int? = null,

    @field:SerializedName("strInstructionsES")
    val strInstructionsES: Any? = null,

    @field:SerializedName("strInstructionsIT")
    val strInstructionsIT: String? = null,

    @field:SerializedName("strGlass")
    val strGlass: String? = null,

    @field:SerializedName("strMeasure12")
    val strMeasure12: Any? = null,

    @field:SerializedName("strMeasure13")
    val strMeasure13: Any? = null,

    @field:SerializedName("strMeasure10")
    val strMeasure10: Any? = null,

    @field:SerializedName("strMeasure11")
    val strMeasure11: Any? = null,

    @field:SerializedName("strImageAttribution")
    val strImageAttribution: String? = null,

    @field:SerializedName("dateModified")
    val dateModified: String? = null,

    @field:SerializedName("strDrinkAlternate")
    val strDrinkAlternate: Any? = null,

    @field:SerializedName("strDrinkThumb")
    val strDrinkThumb: String? = null,

    @field:SerializedName("strInstructionsZH-HANT")
    val strInstructionsZHHANT: Any? = null,

    @field:SerializedName("strMeasure9")
    val strMeasure9: Any? = null,

    @field:SerializedName("strMeasure7")
    val strMeasure7: Any? = null,

    @field:SerializedName("strMeasure8")
    val strMeasure8: Any? = null,

    @field:SerializedName("strMeasure5")
    val strMeasure5: Any? = null,

    @field:SerializedName("strMeasure6")
    val strMeasure6: Any? = null,

    @field:SerializedName("strMeasure3")
    val strMeasure3: String? = null,

    @field:SerializedName("strMeasure4")
    val strMeasure4: Any? = null,

    @field:SerializedName("strMeasure1")
    val strMeasure1: String? = null,

    @field:SerializedName("strMeasure2")
    val strMeasure2: String? = null,

    @field:SerializedName("strInstructionsZH-HANS")
    val strInstructionsZHHANS: Any? = null,

    @field:SerializedName("strMeasure14")
    val strMeasure14: Any? = null,

    @field:SerializedName("strMeasure15")
    val strMeasure15: Any? = null
){
    fun getIngredientsList():List<String>{
        val ingredients: List<String?> = listOf(
            strIngredient1,
            strIngredient2,
            strIngredient3,
            strIngredient4,
            strIngredient5,
            strIngredient6,
            strIngredient7,
            strIngredient8,
            strIngredient9,
            strIngredient10,
            strIngredient11,
            strIngredient12,
            strIngredient13,
            strIngredient14,
            strIngredient15
        )

        return ingredients.distinct().filterNotNull()
    }

}