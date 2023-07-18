package com.example.layoutdesign.Activity

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "presenty_timetable")
data class UserCategory (
     @PrimaryKey(autoGenerate = true)
     var id : Int = 0,
     var date:String,
     var day:String,
     var intime:String,
     var outtime:String
     )
     :Parcelable {
     constructor(parcel: Parcel) : this(
          parcel.readInt(),
          parcel.readString().toString(),
          parcel.readString().toString(),
          parcel.readString().toString(),
          parcel.readString().toString()
     ) {
     }

     override fun writeToParcel(parcel: Parcel, flags: Int) {
          parcel.writeInt(id)
          parcel.writeString(date)
          parcel.writeString(day)
          parcel.writeString(intime)
          parcel.writeString(outtime)
     }

     override fun describeContents(): Int {
          return 0
     }

     companion object CREATOR : Parcelable.Creator<UserCategory> {
          override fun createFromParcel(parcel: Parcel): UserCategory {
               return UserCategory(parcel)
          }

          override fun newArray(size: Int): Array<UserCategory?> {
               return arrayOfNulls(size)
          }
     }
}
