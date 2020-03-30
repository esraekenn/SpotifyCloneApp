package com.example.spotifycloneapp.ui.radios

import RadiosFragmentViewState
import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.spotifycloneapp.data.Resource
import com.example.spotifycloneapp.data.model.Radio
import java.util.function.BiFunction




class RadioPageCombiner :io.reactivex.functions.BiFunction<Resource<List<Radio>>, Resource<List<Radio>>, RadiosFragmentViewState>{
    override fun apply(
        t1: Resource<List<Radio>>,
        t2: Resource<List<Radio>>
    ): RadiosFragmentViewState {
        return RadiosFragmentViewState(t1,t2)
    }
}
