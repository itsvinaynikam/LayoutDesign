package com.example.layoutdesign.AppDataba

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.layoutdesign.Interface.UserDao
import com.example.layoutdesign.Activity.UserCategory


@Database(entities = [UserCategory::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}