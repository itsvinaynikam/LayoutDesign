package com.example.layoutdesign.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.layoutdesign.Network.Apiclientt
import com.example.layoutdesign.PostRequestModel.RegisterResponce
import com.example.layoutdesign.R
import com.example.layoutdesign.SharePrefernce.SharedPreferencesss
import com.example.layoutdesign.databinding.ActivityLogingBinding
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.prefs.Preferences

class LogingActivity : AppCompatActivity() {
    lateinit var binding: ActivityLogingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLogingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        
        binding.btnLoging.setOnClickListener {

            binding.progressbar.visibility= View.VISIBLE
            var email=binding.loginEmaileditetext.text.toString().trim()
            var password=binding.logingPasswordeditetext.text.toString().trim()
            accoundLoging(email,password)

            var pref=SharedPreferencesss(this)
             pref.setLoging(true)

            
        }
        
        
    }

    private fun accoundLoging(email: String, password: String) {

        var jsonn= JsonObject()
        jsonn.addProperty("email",email)
        jsonn.addProperty("password",password)


            Apiclientt.init().logingEmail(jsonn).enqueue(object :Callback<RegisterResponce>{
                override fun onResponse(
                    call: Call<RegisterResponce>,
                    response: Response<RegisterResponce>
                ) {

                    if (response.isSuccessful){
                        binding.progressbar.visibility=View.GONE
                        var logingResponce=response.body()

                        logingResponce?.let {
                            Log.e("logingresponce", "onResponse: "+     it.message )
                            startActivity(Intent(this@LogingActivity,HomeActivity::class.java))
                        }

                    }
                }
                override fun onFailure(call: Call<RegisterResponce>, t: Throwable) {
                    Log.e("logingresponce", "onResponse: "+ t )


                }
            })



    }
}