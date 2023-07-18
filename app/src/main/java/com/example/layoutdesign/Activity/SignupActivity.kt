package com.example.layoutdesign.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.layoutdesign.Network.Apiclientt
import com.example.layoutdesign.PostRequestModel.PostUser
import com.example.layoutdesign.PostRequestModel.RegisterResponce
import com.example.layoutdesign.R
import com.example.layoutdesign.databinding.ActivitySignupBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnRagister.setOnClickListener {

            binding.progressbar.visibility= View.VISIBLE

            var firstname=binding.firstnameEditetext.text.toString().trim()
            var lastname=binding.lastnameEditetext.text.toString().trim()
            var email=binding.emailEditetext.text.toString().trim()
            var password=binding.passwordEditetext.text.toString().trim()

            createAccount(firstname,lastname,email,password)
        }
        

    }


    private fun createAccount(firstname: String, lastname: String, email: String, password: String) {


        var Userdata= PostUser(firstName =firstname, lastName =lastname,email= email, password = password )


        Apiclientt.init().registerresponce(Userdata).enqueue(object : Callback<RegisterResponce> {
            override fun onResponse(call: Call<RegisterResponce>, response: Response<RegisterResponce>) {

                binding.progressbar.visibility=View.GONE


                if (response.isSuccessful){
                    var respocedata=response.body()

                    respocedata?.let {
                        Toast.makeText(this@SignupActivity, "${it.message}", Toast.LENGTH_SHORT).show()
                        Log.e("onResponse", "onResponse: "+it.data )
                        var intentt= Intent(this@SignupActivity,OtpVerification::class.java)
                        intentt.putExtra("otpverification",it.data)
                        startActivity(intentt)

                    }
                }

            }

            override fun onFailure(call: Call<RegisterResponce>, t: Throwable) {
                Toast.makeText(this@SignupActivity, "${t}", Toast.LENGTH_SHORT).show()
                Log.e("dataresponceee  ", "createAccount:   5 "+t )
                binding.progressbar.visibility=View.GONE

            }

        })










    }

}