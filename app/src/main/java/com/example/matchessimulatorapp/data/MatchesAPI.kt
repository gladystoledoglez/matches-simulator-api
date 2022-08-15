package com.example.matchessimulatorapp.data

import com.example.matchessimulatorapp.data.entities.MatchEntity
import retrofit2.Call
import retrofit2.http.GET

interface MatchesAPI {

    @GET("matches.json")
    fun getMatches(): Call<List<MatchEntity>>
}