package com.example.layoutdesign.Activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.layoutdesign.AppDataba.AppDatabase
import com.example.layoutdesign.Interface.Datapass
import com.example.layoutdesign.databinding.ActivityInsertBinding


class InsertActivity : AppCompatActivity() {

   private lateinit var binding: ActivityInsertBinding
   lateinit var db:AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityInsertBinding.inflate(layoutInflater)
        setContentView(binding.root)


        db = Room.databaseBuilder(this ,AppDatabase::class.java, "TimeCounting").allowMainThreadQueries().build()

        //user = intent.getParcelableExtra("message_key")
        //val intent = intent


       // var lissst=intent.getParcelableArrayExtra("Contactlist")
       //   val dataList = intent.getStringArrayListExtra("dataList")



        binding.btnSave.setOnClickListener {
            var date=binding.etDate.text.toString().trim()
            var day=binding.etDay.text.toString().trim()
            var intime=binding.inTime.text.toString().trim()
            var outtime=binding.OutTime.text.toString().trim()
            saveData(date,day,intime,outtime)

        }



    }


    private fun saveData(date: String, day: String, intime: String, outtime: String) {
        try
        {
            var User= UserCategory(date = date, day = day, intime = intime, outtime = outtime)

            db.userDao().insetdata(User)
            Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show()

            binding.etDate.setText("")
            binding.etDay.setText("")
            binding.inTime.setText("")
            binding.OutTime.setText("")

        } catch (e:Exception)
        { }

    }




}