package com.example.spotifycloneapp.data

import retrofit2.Call
import retrofit2.http.GET

interface RadioService
{
    @GET("popularRadios.json")
    fun popularRadios(): Call<List<Radio>>

    @GET("locationRadios.json")
    fun locationRadios():Call<List<Radio>>
}