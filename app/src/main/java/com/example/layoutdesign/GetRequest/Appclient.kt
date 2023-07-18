package com.example.layoutdesign.GetRequest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Appclient {


    companion object
    {
        var retrofit: Retrofit?=null

        fun initt():Appinterface
        {
          if (retrofit==null)
          {

              retrofit = Retrofit.Builder()
                  .baseUrl("https://reqres.in/api/")
                  .addConverterFactory(GsonConverterFactory.create())
                  .build()


          }
            return retrofit!!.create(Appinterface::class.java)

        }

    }


}