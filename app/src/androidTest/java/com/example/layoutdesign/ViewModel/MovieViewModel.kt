package com.example.layoutdesign.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.layoutdesign.GetRequest.GetUser
import com.example.layoutdesign.GetRequest.getmainResponce
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MovieViewModel : ViewModel() {
    private var movieLiveData = MutableLiveData<List<GetUser>>()

    fun getPopularMovies() {
        RetrofitInstance.api.alllist().enqueue(object  :
            Callback<getmainResponce> {
            override fun onResponse(call: Call<getmainResponce>, response: Response<getmainResponce>) {
                if (response.body()!=null)
                {

                    movieLiveData.value = response.body()!!.getUserlist
                }
                else{
                    return
                }
            }
            override fun onFailure(call: Call<getmainResponce>, t: Throwable) {

            }
        })
    }
    fun observeMovieLiveData() : LiveData<List<GetUser>>
    {
        return movieLiveData
    }
}