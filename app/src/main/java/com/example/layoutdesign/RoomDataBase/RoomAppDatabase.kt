package com.example.layoutdesign.RoomDataBase

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [RoomUserr::class], version = 1)
abstract class RoomAppDatabase : RoomDatabase() {
    abstract fun RoomuserDao(): RoomUserDao
}