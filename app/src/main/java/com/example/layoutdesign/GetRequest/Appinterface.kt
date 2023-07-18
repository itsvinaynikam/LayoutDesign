package com.example.layoutdesign.GetRequest

import retrofit2.Call
import retrofit2.http.GET

interface Appinterface
{
    @GET("users?page=2")
fun alllist():Call<getmainResponce>

}