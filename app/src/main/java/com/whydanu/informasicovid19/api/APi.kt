package com.whydanu.informasicovid19.api

import android.telecom.Call
import com.whydanu.informasicovid19.model.IndonesiaResponse
import com.whydanu.informasicovid19.model.ProvinceResponse
import retrofit2.http.GET

interface APi {
    @GET("indonesia")
    fun getIndonesia(): retrofit2.Call<ArrayList<IndonesiaResponse>>

    @GET("indonesia/provinsi")
    fun  getProvince(): retrofit2.Call<ArrayList<ProvinceResponse>>
}