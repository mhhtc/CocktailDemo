package com.miguelhhtc.cocktaildemo.network

import com.miguelhhtc.cocktaildemo.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClientAPI {

    companion object {
        private fun getBaseUrl(): String {
            return BuildConfig.API_URL
        }

        private var retrofit: Retrofit? = null
        val client: Retrofit
            get() {
                if (retrofit == null) {
                    retrofit = Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(getBaseUrl())
                        .build()
                }
                return retrofit!!
            }
    }

}