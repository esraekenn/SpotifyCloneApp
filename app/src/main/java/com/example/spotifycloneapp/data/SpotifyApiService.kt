package com.example.spotifycloneapp.data

import com.example.spotifycloneapp.data.model.Radio
import io.reactivex.Single
import retrofit2.http.GET

interface SpotifyApiService
{
    @GET("popularRadios.json")
    fun getPopularRadios(): Single<List<Radio>>

    @GET("locationRadios.json")
    fun getLocationRadios():Single<List<Radio>>
}