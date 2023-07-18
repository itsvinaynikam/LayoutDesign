package com.example.layoutdesign.Activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.layoutdesign.Adpter.DataShowAdpter
import com.example.layoutdesign.AppDataba.AppDatabase
import com.example.layoutdesign.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


private lateinit var binding:ActivityMainBinding

private var datalisst= ArrayList<UserCategory>()
    lateinit var db: AppDatabase
    lateinit var Madpter:DataShowAdpter
    var data: UserCategory?=null
    //lateinit var datas:Datapass
    private var datas= ArrayList<UserCategory>()





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        db = Room.databaseBuilder(this ,AppDatabase::class.java, "TimeCounting").allowMainThreadQueries().build()



        Madpter= DataShowAdpter(this,datalisst)
        binding.recycleview.adapter= Madpter
        binding.recycleview.layoutManager=LinearLayoutManager(this)



        binding.addBtn.setOnClickListener {
            val i = Intent(this, InsertActivity::class.java)
            i.putParcelableArrayListExtra("Contactlist", datalisst)
            startActivity(i)

            val intent = Intent(this, HomeActivity::class.java)
           // intent.putParcelableArrayListExtra("dataList", ArrayList(datalisst))
            startActivity(intent)


        }

    }


    override fun onPostResume() {
        super.onPostResume()
        datalisst= db.userDao().getAllData().toMutableList() as ArrayList<UserCategory>
        Madpter.setitem(datalisst)
    }





}