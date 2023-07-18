package com.example.layoutdesign.PostRequestModel

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class buntyverifiedResponce
    (
    var userId:Int,
    var firstName:String,
    var lastName:String,
    var email:String,
    var phoneNumber:String,
    var providerType:String,
    var providerId:String,
    var verifiedAt:String,
    var aboutMe:String,
    var dateOfBirth:String,
    var age:Int,
    var gender:String,
    var sexualOrientation:String,
    var genderPreference:String,
    var schoolName:String,
    var isOnline:String,
    var lastLoginAt:String,
    var latitude:Int,
    var longitude:Int,
    var createdAt:Int,
    var interests:MutableList<String>,
    var photos:MutableList<String>

):Serializable
