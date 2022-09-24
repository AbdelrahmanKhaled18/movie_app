package com.example.training_final_project

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class Film(
    val Film_name:String,
    val Film_image:Int,
    val film_category :String?,
    val film_rating:Double?,
    val film_star:String?,
    val film_description:String?
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readString(),
        parcel.readString()
    ) {}

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Film_name)
        parcel.writeInt(Film_image)
        parcel.writeString(film_category)
        parcel.writeValue(film_rating)
        parcel.writeString(film_star)
        parcel.writeString(film_description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Film> {
        override fun createFromParcel(parcel: Parcel): Film {
            return Film(parcel)
        }

        override fun newArray(size: Int): Array<Film?> {
            return arrayOfNulls(size)
        }
    }
}
