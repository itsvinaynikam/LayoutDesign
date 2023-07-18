
package com.example.layoutdesign.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.layoutdesign.R
import com.example.layoutdesign.databinding.ActivityGitBinding
import com.google.android.material.navigation.NavigationView


class GitActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener{
    lateinit var binding: ActivityGitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityGitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.navigationView.setNavigationItemSelectedListener(this)

//        var toggal=ActionBarDrawerToggle(this,binding.drawerLayout)




    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("Not yet implemented")
    }
}