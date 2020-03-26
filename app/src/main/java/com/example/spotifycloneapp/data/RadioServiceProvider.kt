package com.example.spotifycloneapp.data

import com.example.spotifycloneapp.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RadioServiceProvider
{
    private val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://radiofm-4b467.firebaseio.com/")
        .build()
    val radioService=retrofit.create<RadioService>(RadioService::class.java)
}