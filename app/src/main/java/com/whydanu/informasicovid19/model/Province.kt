package com.whydanu.informasicovid19.model

import com.google.gson.annotations.SerializedName

data class Province(
    @SerializedName("Kode_Provi")
    val code : Int,
    @SerializedName ("Provinsi")
    val province : String,
    @SerializedName("Kasus_Posi")
    val positive :Int,
    @SerializedName("Kasus_Semb")
    val recover : Int,
    @SerializedName("Kasus_meni")
    val deadth : Int,
)