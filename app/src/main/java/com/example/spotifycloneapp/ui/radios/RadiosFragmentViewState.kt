package com.example.spotifycloneapp.ui.radios

import com.example.spotifycloneapp.data.Resource
import com.example.spotifycloneapp.data.model.Radio

data class RadiosFragmentViewState(
    val popularRadioResource: Resource<List<Radio>>,
    val locationRadioResource: Resource<List<Radio>>
)
