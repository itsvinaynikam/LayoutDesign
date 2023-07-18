package com.example.layoutdesign.Adpter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.layoutdesign.Activity.UserCategory
import com.example.layoutdesign.databinding.MaintitleLayoutBinding

class DataShowAdpter(var context: Context,var datalist:ArrayList<UserCategory>):RecyclerView.Adapter<DataShowAdpter.Myviewholder>() {

    private lateinit var binding:MaintitleLayoutBinding

    class Myviewholder(var binding: MaintitleLayoutBinding) :RecyclerView.ViewHolder(binding.root){


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myviewholder {
        binding= MaintitleLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return Myviewholder(binding)

    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(holder: Myviewholder, position: Int) {

        var datalisst=datalist[position]
        holder.binding.textDate2.text=datalisst.date
        holder.binding.textDay2.text=datalisst.day
        holder.binding.textintime3.text=datalisst.intime
        holder.binding.textOutTime2.text=datalisst.outtime



        holder.binding.maindesignlayout.setOnClickListener {
            Log.e("postionnnn", "onBindViewHolder: "+position )

        }






       // holder.binding.
    }




    fun setitem(datalisst: ArrayList<UserCategory>)
    {
        this.datalist=datalisst
        notifyDataSetChanged()
    }



}