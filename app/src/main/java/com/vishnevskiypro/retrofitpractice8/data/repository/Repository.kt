package com.vishnevskiypro.retrofitpractice8.data.repository

import com.vishnevskiypro.retrofitpractice8.data.api.RetrofitInstance
import com.vishnevskiypro.retrofitpractice8.models.beznal.Beznal
import com.vishnevskiypro.retrofitpractice8.models.nal.Nalichka
import retrofit2.Response

class Repository {

    suspend fun getNalFromRetro(): Response<Nalichka>{
        return RetrofitInstance.api.getNalFromNetwork()
    }

    suspend fun getBeznalFromRetro(): Response<Beznal>{
        return RetrofitInstance.api.getBeznalFromNetwork()
    }

}