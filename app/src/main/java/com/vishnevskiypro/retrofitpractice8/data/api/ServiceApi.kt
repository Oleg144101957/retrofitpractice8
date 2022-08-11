package com.vishnevskiypro.retrofitpractice8.data.api

import com.vishnevskiypro.retrofitpractice8.models.beznal.Beznal
import com.vishnevskiypro.retrofitpractice8.models.nal.Nalichka
import retrofit2.Response
import retrofit2.http.GET

interface ServiceApi {

    @GET("/p24api/pubinfo?json&exchange&coursid=5")
    suspend fun getNalFromNetwork(): Response<Nalichka>

    @GET("/p24api/pubinfo?exchange&json&coursid=11")
    suspend fun getBeznalFromNetwork(): Response<Beznal>


}