package com.example.spotifycloneapp.ui.radios

import com.example.spotifycloneapp.data.Resource
import com.example.spotifycloneapp.data.model.Radio
import io.reactivex.functions.BiFunction

class RadiosPageCombiner :
    BiFunction<Resource<List<Radio>>, Resource<List<Radio>>, RadiosFragmentViewState> {

    override fun apply(
        popularRadios: Resource<List<Radio>>,
        locationRadios: Resource<List<Radio>>
    ): RadiosFragmentViewState {
        return RadiosFragmentViewState(popularRadios, locationRadios)
    }

}