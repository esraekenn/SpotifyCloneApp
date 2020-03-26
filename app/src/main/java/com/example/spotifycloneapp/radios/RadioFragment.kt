package com.example.spotifycloneapp.ui.radios

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.spotifycloneapp.R
import com.example.spotifycloneapp.data.Radio
import com.example.spotifycloneapp.data.RadioServiceProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RadioFragment : Fragment() {
    private val radioServiceProvider = RadioServiceProvider()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_radios, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        loadPopularRadios()
        loadLocationRadios()
    }

    private fun loadPopularRadios() {
        radioServiceProvider.radioService.popularRadios().enqueue(object : Callback<List<Radio>> {

            override fun onResponse(call: Call<List<Radio>>, response: Response<List<Radio>>) {
                Log.v("TEST", "Popular Radios: ${response.body().toString()}")
            }

            override fun onFailure(call: Call<List<Radio>>, t: Throwable) {
                Log.v("TEST", "${t.message}")
            }
        })
    }

    private fun loadLocationRadios() {

        radioServiceProvider.radioService.locationRadios().enqueue(object : Callback<List<Radio>> {

            override fun onResponse(call: Call<List<Radio>>, response: Response<List<Radio>>) {
                Log.v("TEST", "Location Radios: ${response.body().toString()}")
            }

            override fun onFailure(call: Call<List<Radio>>, t: Throwable) {
                Log.v("TEST", "${t.message}")
            }
        })
    }
}