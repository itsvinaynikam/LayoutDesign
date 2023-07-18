package com.example.layoutdesign.Adpter

import android.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.layoutdesign.databinding.LayoutScreenBinding
import com.example.layoutdesign.onBordindingModel.ScreenItem


class IntroViewPagerAdapter(var mContext: Context, var mListScreen: List<ScreenItem>) : PagerAdapter() {


    lateinit var binding:LayoutScreenBinding

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        binding= LayoutScreenBinding.inflate(LayoutInflater.from(mContext),container,false)
        binding.introTitle.setText(mListScreen[position].title)
        binding.introDescription.setText(mListScreen[position].description)
        binding.introImg.setImageResource(mListScreen[position].screenImg)
        container.addView(binding.root)
        return binding.root
    }

    override fun getCount(): Int {
        return mListScreen.size
    }

    override fun isViewFromObject(view: View, o: Any): Boolean {
       return view === o
        //return view ==object
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}