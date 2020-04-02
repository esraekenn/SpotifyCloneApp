package com.example.spotifycloneapp.ui.radios

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.spotifycloneapp.R
import com.example.spotifycloneapp.data.RadioDataSource
import com.example.spotifycloneapp.data.Status
import com.example.spotifycloneapp.databinding.FragmentRadiosBinding
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RadiosFragment : Fragment() {
    private lateinit var binding: FragmentRadiosBinding
    private val radioDataSource = RadioDataSource()
    private val popularRadioAdapter=RadiosAdapter()
    private val locationRadioAdapter=RadiosAdapter()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_radios,container,false)
        binding.recyclerViewPopularRadios.adapter=popularRadioAdapter
        binding.recyclerViewLocationRadios.adapter=locationRadioAdapter

        return binding.root
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
        Observable.combineLatest(popularObservable,locationObservable,RadiosPageCombiner())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                renderUI(it)
            }
    }
    private fun renderUI(radioFragmentViewState:RadiosFragmentViewState)
    {
        when(radioFragmentViewState.popularRadioResource.status)
        {
            Status.SUCCESS -> {
                binding.progressBarPopularRadios.visibility=View.GONE
                popularRadioAdapter.setRadioList(radioFragmentViewState.popularRadioResource.data!!)
            }
            Status.LOADING -> binding.progressBarPopularRadios.visibility=View.VISIBLE
        }
        when(radioFragmentViewState.locationRadioResource.status)
        {
            Status.SUCCESS ->
            {
                binding.progressBarLocationRadios.visibility=View.GONE
                locationRadioAdapter.setRadioList(radioFragmentViewState.locationRadioResource.data!!)
            }
            Status.LOADING -> binding.progressBarLocationRadios.visibility=View.VISIBLE
        }

    }


    companion object{

        fun newInstance()=RadiosFragment()
    }

}





