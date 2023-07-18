package com.example.layoutdesign.RoomDataBase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.layoutdesign.GetRequest.GetUser


@Dao
interface RoomUserDao {
    @Query("SELECT * FROM usertable")
    fun getAll(): List<RoomUserr>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users:RoomUserr)

    @Delete
    fun delete(user: RoomUserr)
}