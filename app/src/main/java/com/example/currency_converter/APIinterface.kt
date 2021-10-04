package com.example.currency_converter

import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {
    @GET("sar.json")
    fun getrates(): Call<currencyData>?
}