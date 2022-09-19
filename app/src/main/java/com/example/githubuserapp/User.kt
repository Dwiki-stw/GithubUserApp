package com.example.githubuserapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val name:String,
    val company: String,
    val location: String,
    val photo: Int,
    val username: String,
    val repository: String,
    val following: String,
    val followers: String
): Parcelable
