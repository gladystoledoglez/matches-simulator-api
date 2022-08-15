package com.example.matchessimulatorapp.data.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TeamEntity(
    @SerializedName("name") val name: String,
    @SerializedName("stars") val stars: Int,
    @SerializedName("image") val image: String
) : Parcelable