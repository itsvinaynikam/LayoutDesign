package com.example.layoutdesign.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.layoutdesign.Network.Apiclientt
import com.example.layoutdesign.PostRequestModel.RegisterResponce
import com.example.layoutdesign.PostRequestModel.buntyverifiedResponce
import com.example.layoutdesign.R
import com.example.layoutdesign.databinding.ActivityOtpVerificationBinding
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OtpVerification : AppCompatActivity() {

    lateinit var binding: ActivityOtpVerificationBinding
    lateinit var verificationdata:
            buntyverifiedResponce


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityOtpVerificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        try
        {
            verificationdata = (getIntent().getSerializableExtra("otpverification") as buntyverifiedResponce?)!!
        }
        catch (e:Exception)
        {
            Toast.makeText(this, "otp verificationdata is fail", Toast.LENGTH_SHORT).show()
        }

        binding.btnVerfiction.setOnClickListener {
            var email:String?=null
            if (verificationdata!=null){
                email=verificationdata.email
            }
            var otp=binding.otpEditetext.text.toString().trim()

            VerficationOtp(email!!,otp)
        }


    }

    private fun VerficationOtp(email: String, otp: String) {

        var json= JsonObject()
        json.addProperty("email",email)
        json.addProperty("otp",otp)


        Apiclientt.init().verifictionEmail(json).enqueue(object : Callback<RegisterResponce> {
            override fun onResponse(
                call: Call<RegisterResponce>,
                response: Response<RegisterResponce>
            )
            {
                if (response.isSuccessful){
                    var respocedata=response.body()
                    respocedata?.let {
                        Log.e("onResponse", "onResponse: "+it.message )
                        Toast.makeText(this@OtpVerification, "${it.message}", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@OtpVerification,HomeActivity::class.java))
                    }


                }


            }

            override fun onFailure(call: Call<RegisterResponce>, t: Throwable) {
            }

        })




    }

}