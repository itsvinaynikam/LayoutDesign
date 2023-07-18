package com.example.layoutdesign.Network

import com.example.layoutdesign.PostRequestModel.PostUser
import com.example.layoutdesign.PostRequestModel.RegisterResponce
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

sealed interface apiservice
{
    //@POST("set your Api")
    //fun registerresponce(@Body posrequesttuser: posttUser):Call<RegisterResponce>

    @POST("set your Api")
    fun registerresponce(@Body posrequesttuser: PostUser):Call<RegisterResponce>

    @POST("set your Api")
    fun verifictionEmail(@Body json: JsonObject):Call<RegisterResponce>


    @POST("set your Api")
    fun logingEmail(@Body json: JsonObject):Call<RegisterResponce>



}