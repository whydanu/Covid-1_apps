package com.whydanu.informasicovid19.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val  Base_URL ="https://api.kawalcorona.com/"

    val instance : APi by lazy{
        val retrofit = Retrofit.Builder()
            .baseUrl(Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(APi::class.java)

    }
}