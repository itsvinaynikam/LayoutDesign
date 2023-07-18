package com.example.layoutdesign.GetRequest

import com.google.gson.annotations.SerializedName

data class getmainResponce(
 var page:Int,
var per_page:Int,
var total:Int,
var total_pages:Int,
 var support: Support,
 @SerializedName("data")
var getUserlist: MutableList<GetUser>
)
