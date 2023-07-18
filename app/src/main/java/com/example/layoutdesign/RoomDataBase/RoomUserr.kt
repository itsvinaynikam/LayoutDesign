package com.example.layoutdesign.RoomDataBase

import android.media.Image
import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usertable")
data class RoomUserr(
               @PrimaryKey
                    var id:Int,
                    var firstname:String,
                      var lastName:String,
                      var email:String,
                     var image: String=""):Parcelable{
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
        parcel.writeString(firstname)
        parcel.writeString(lastName)
        parcel.writeString(email)
        parcel.writeString(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RoomUserr> {
        override fun createFromParcel(parcel: Parcel): RoomUserr {
            return RoomUserr(parcel)
        }

        override fun newArray(size: Int): Array<RoomUserr?> {
            return arrayOfNulls(size)
        }
    }

}
