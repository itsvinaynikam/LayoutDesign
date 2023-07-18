package com.example.layoutdesign.GetRequest

import androidx.room.Entity
import androidx.room.PrimaryKey


data class GetUser
    (
    var id:Int=0,
    var email:String,
    var first_name:String,
    var last_name:String,
    var avatar:String
    )
