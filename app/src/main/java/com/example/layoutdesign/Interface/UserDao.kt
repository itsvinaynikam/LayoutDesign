package com.example.layoutdesign.Interface

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.layoutdesign.Activity.UserCategory


@Dao
interface UserDao {

    @Insert
    fun insetdata(user: UserCategory)

    @Delete
    fun delete(user: UserCategory)

    @Query("select * from presenty_timetable")
    fun getAllData(): List<UserCategory>


}