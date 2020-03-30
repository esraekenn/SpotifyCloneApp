package com.example.spotifycloneapp.ui.radios

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.spotifycloneapp.R
import com.example.spotifycloneapp.data.RadioDataSource
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RadioFragment : Fragment() {
    private val radioDataSource = RadioDataSource()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_radios, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        fetchRadioPage()

        }
    @SuppressLint("CheckResult")
    private fun fetchRadioPage()
    {
        val popularObservable=radioDataSource.fetchPopularRadios()
        val locationObservable=radioDataSource.fetchLocationRadios()
        Observable.combineLatest(popularObservable,locationObservable,RadioPageCombiner())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                Log.v("TEST",it.toString())
            }
    }

    companion object{

        fun newInstance()=RadioFragment()
    }

}





