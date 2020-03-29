package com.example.spotifycloneapp.data

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RadioServiceProvider
{
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl("https://radiofm-4b467.firebaseio.com/")
        .build()
    private val apiService:SpotifyApiService=retrofit.create(SpotifyApiService::class.java)
    fun getRadioService():SpotifyApiService=apiService
}