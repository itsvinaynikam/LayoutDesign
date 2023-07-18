package com.example.layoutdesign.Activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.Animation
import androidx.appcompat.app.AppCompatActivity
import com.example.layoutdesign.Adpter.IntroViewPagerAdapter
import com.example.layoutdesign.SharePrefernce.SharedPreferencesss
import com.example.layoutdesign.databinding.ActivityIntroBinding
import com.example.layoutdesign.onBordindingModel.ScreenItem
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener


class IntroActivity : AppCompatActivity() {
    lateinit var binding: ActivityIntroBinding
    var btnAnim: Animation? = null
    var mList= mutableListOf<ScreenItem>()
    lateinit var introViewPagerAdapter:IntroViewPagerAdapter
    var position = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityIntroBinding.inflate(layoutInflater)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(binding.root)


        mList.add(ScreenItem("Fresh Food", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua, consectetur  consectetur adipiscing elit",
                com.example.layoutdesign.R.drawable.img)
        )
        mList.add(ScreenItem("Fast Delivery", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua, consectetur  consectetur adipiscing elit",
                com.example.layoutdesign.R.drawable.img_1)
        )
        mList.add(ScreenItem("Easy Payment", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua, consectetur  consectetur adipiscing elit",
                com.example.layoutdesign.R.drawable.img_2))

        introViewPagerAdapter= IntroViewPagerAdapter(this,mList)
        binding.screenViewpager.adapter=introViewPagerAdapter

        binding.tabIndicator.setupWithViewPager(binding.screenViewpager);

        binding.btnNext.setOnClickListener(View.OnClickListener {
            position = binding.screenViewpager.getCurrentItem()
            if (position < mList.size) {
                position++
                binding.screenViewpager.setCurrentItem(position)
            }
            if (position === mList.size - 1) {
                binding.btnNext.setText("finish")
                updateIntroStatus()
                val mainActivity = Intent(applicationContext, AllLogingOptions::class.java)
                 startActivity(mainActivity)

            }
        })



       binding.btnGetStarted.setOnClickListener(View.OnClickListener { //open main activity
            val mainActivity = Intent(applicationContext, MainActivity::class.java)
            startActivity(mainActivity)


            finish()
        })


        binding.tvSkip.setOnClickListener(View.OnClickListener {

            updateIntroStatus()
            val mainActivity = Intent(applicationContext, AllLogingOptions::class.java)
            startActivity(mainActivity)

        })


    }

    private fun updateIntroStatus() {
        var pref=SharedPreferencesss(this)
        pref.setOnbordingScreen(true)
    }


}