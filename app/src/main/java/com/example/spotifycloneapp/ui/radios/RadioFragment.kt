package com.example.spotifycloneapp.ui.radios

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.spotifycloneapp.R
import com.example.spotifycloneapp.data.RadioDataSources
import com.example.spotifycloneapp.data.RadioServiceProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RadioFragment : Fragment() {
    private val radioDataSources = RadioDataSources()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_radios, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

         radioDataSources
             .fetchPopularRadios()
             .subscribeOn(Schedulers.io())
             .observeOn(AndroidSchedulers.mainThread())
             .subscribe{Log.v("TEST","fetchPopularRadios{${it.status.toString()}}")}
        radioDataSources
            .fetchLocationRadios()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{Log.v("TEST","fetchPopularRadios{${it.status.toString()}}")}

        }

    companion object{

        fun newInstance()=RadioFragment()
    }

}





