package com.example.layoutdesign.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.layoutdesign.R
import com.example.layoutdesign.databinding.ActivityAllLogingOptionsBinding

class AllLogingOptions : AppCompatActivity() {
    lateinit var binding: ActivityAllLogingOptionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityAllLogingOptionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogingwithphone.setOnClickListener {
            startActivity(Intent(this,LogingActivity::class.java))
        }

        binding.btnSignupPhone.setOnClickListener {
            startActivity(Intent(this,HomeActivity::class.java))
        }




    }
}