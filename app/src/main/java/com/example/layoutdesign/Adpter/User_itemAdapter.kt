package com.example.layoutdesign.Adpter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.bumptech.glide.Glide
import com.example.layoutdesign.Interface.onclicklisner
import com.example.layoutdesign.RoomDataBase.RoomAppDatabase
import com.example.layoutdesign.RoomDataBase.RoomUserr

import com.example.layoutdesign.databinding.UserItemBinding

class User_itemAdapter(var context: Context, var userlistt:MutableList<RoomUserr>):RecyclerView.Adapter<User_itemAdapter.Myviewhoplder>(){

    lateinit var binding: UserItemBinding
    lateinit var db: RoomAppDatabase

    lateinit var lisner:onclicklisner

    fun setonclick(lisnerr:onclicklisner){
        this.lisner=lisnerr
    }

    class Myviewhoplder(val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myviewhoplder {
        db = Room.databaseBuilder(context.applicationContext, RoomAppDatabase::class.java, "databasename").allowMainThreadQueries().build()

        binding= UserItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return Myviewhoplder(binding)

    }

    override fun onBindViewHolder(holder: Myviewhoplder, position: Int) {
           var user=userlistt[position]

        holder.binding.tvFirstname.text="${user.firstname}${user.lastName}"
        holder.binding.tvEmail.text=user.email
        Glide.with(context).load(user.image).centerCrop().into(holder.binding.userThumble)


        holder.binding.deleteBtn.setOnClickListener {
            lisner.deleteData(user)
        }

        holder.binding.userThumble.setOnClickListener {

          //  lisner.secondclicked(it,position)

        }

        holder.binding.parent.setOnClickListener {
            lisner.upDateDataa(userlistt.get(position))

        }




    }

    override fun getItemCount(): Int {
        return userlistt.size

    }

    fun SetItem(userList: MutableList<RoomUserr>)
    {

        this.userlistt=userList
         notifyDataSetChanged()
    }

}