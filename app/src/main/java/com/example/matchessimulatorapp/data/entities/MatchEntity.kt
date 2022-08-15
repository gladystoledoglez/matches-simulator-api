package com.example.matchessimulatorapp.data.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MatchEntity(
    @SerializedName("description") val description: String,
    @SerializedName("place") val place: PlaceEntity,
    @SerializedName("principal") val principalTeam: TeamEntity,
    @SerializedName("visitor") val visitorTeam: TeamEntity
) : Parcelable
