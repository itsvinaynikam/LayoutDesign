package com.example.layoutdesign.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.WindowManager
import com.example.layoutdesign.R
import com.example.layoutdesign.SharePrefernce.SharedPreferencesss
import com.example.layoutdesign.databinding.ActivitySpashAcivityBinding

class SpashAcivity : AppCompatActivity() {

    lateinit var binding:ActivitySpashAcivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySpashAcivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        Handler(Looper.getMainLooper()).postDelayed({
            var preff=SharedPreferencesss(this)
            if (!preff.getOnBordingScreen())
            { val intent = Intent(this, IntroActivity::class.java)
                startActivity(intent)
                finish()
            }else
            {
                if (!preff.getOnLoging())
                { val intent = Intent(this, AllLogingOptions::class.java)
                    startActivity(intent)
                    finish()
                }else
                { val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                }


            }


        }, 5000)



    }
}