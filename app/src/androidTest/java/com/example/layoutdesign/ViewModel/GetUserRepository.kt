package com.example.layoutdesign.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.layoutdesign.GetRequest.Appinterface
import com.example.layoutdesign.GetRequest.GetUser

class GetUserRepository(private val apiInterface:Appinterface) {
    private var userlistLiveData=MutableLiveData<GetUser>()

    val memes:LiveData<GetUser>
        get() = userlistLiveData

     fun getUser()
    {
        val resultt=apiInterface.alllist()

     }


}