package com.vishnevskiypro.retrofitpractice8.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val api = Retrofit.Builder()
        .baseUrl("https://api.privatbank.ua")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ServiceApi::class.java)

}