package com.example.layoutdesign.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.layoutdesign.Adpter.User_itemAdapter
import com.example.layoutdesign.Fragment.HistoryFragment
import com.example.layoutdesign.Fragment.HomeFragment
import com.example.layoutdesign.Fragment.ProfileFragment
import com.example.layoutdesign.Fragment.SpingFragment
import com.example.layoutdesign.GetRequest.Appclient
import com.example.layoutdesign.GetRequest.Appinterface
import com.example.layoutdesign.GetRequest.GetUser
import com.example.layoutdesign.GetRequest.getmainResponce
import com.example.layoutdesign.R
import com.example.layoutdesign.databinding.ActivityHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.container,HomeFragment())
        transaction.commit()
        binding.bottmNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.btn_home -> {
                    loadFragment(HomeFragment())
                   return@setOnItemSelectedListener true
                }
                R.id.btn_spin -> {
                    loadFragment(SpingFragment())
                    return@setOnItemSelectedListener true
                }
                R.id.btn_history -> {
                    loadFragment(HistoryFragment())
                    return@setOnItemSelectedListener  true
                }
                R.id.btn_profile -> {
                    loadFragment(ProfileFragment())
                    return@setOnItemSelectedListener true
                }
                else -> {return@setOnItemSelectedListener false}
            }
        }

    }


    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }

}