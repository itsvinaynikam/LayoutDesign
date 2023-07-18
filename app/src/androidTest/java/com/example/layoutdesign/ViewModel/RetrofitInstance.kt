package com.example.layoutdesign.ViewModel

import com.example.layoutdesign.GetRequest.Appinterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance
{
    val api : Appinterface by lazy {
        Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Appinterface::class.java)
    }

}

