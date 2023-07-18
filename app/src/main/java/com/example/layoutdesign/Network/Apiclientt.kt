package com.example.layoutdesign.Network

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Apiclientt {

    companion object{

        var retrofit:Retrofit?=null

        fun init():apiservice
        {


            if (retrofit==null)
            {
                retrofit = Retrofit.Builder()
                    .baseUrl("set your api ")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            }
            Log.e("dataresponceee", "onCreate:      3  "+retrofit )

            return  retrofit!!.create(apiservice::class.java)





        }


    }
}