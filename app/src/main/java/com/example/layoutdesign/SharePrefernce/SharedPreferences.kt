package com.example.layoutdesign.SharePrefernce

import android.R.attr.value
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences.Editor


class SharedPreferencesss(var context: Context)
{

var sharedPreferences=context.getSharedPreferences("MySharedPref",MODE_PRIVATE)
    var myEdit:Editor = sharedPreferences.edit()

      var KEY_INTRO="isintro"
      var KEY_LOGING="isloging"

    fun setOnbordingScreen(status:Boolean)
    {
        myEdit.putBoolean(KEY_INTRO, status)
        myEdit.commit()
    }

    fun getOnBordingScreen():Boolean{
        return sharedPreferences.getBoolean(KEY_INTRO,false)
    }



    fun setLoging(status:Boolean){

        myEdit.putBoolean(KEY_LOGING, status)
        myEdit.commit()
    }

    fun getOnLoging():Boolean{
        return sharedPreferences.getBoolean(KEY_LOGING,false)
    }



}

