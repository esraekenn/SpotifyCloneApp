package com.example.spotifycloneapp.ui.radios

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.spotifycloneapp.R
import com.example.spotifycloneapp.data.model.Radio
import com.example.spotifycloneapp.databinding.ItemRadioBinding
import com.squareup.picasso.Picasso

class RadiosAdapter : RecyclerView.Adapter<RadiosAdapter.RadioItemViewHolder>() {

    private val radiosList = arrayListOf<Radio>()

    fun setRadioList(radiosList: List<Radio>) {
        this.radiosList.clear()
        this.radiosList.addAll(radiosList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = radiosList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RadioItemViewHolder =
        RadioItemViewHolder.create(parent)

    override fun onBindViewHolder(holder: RadioItemViewHolder, position: Int) =
        holder.bind(radiosList[position])

    class RadioItemViewHolder(private val binding: ItemRadioBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(radioItem: Radio) {
            Picasso.get().load(radioItem.logo_small).into(binding.imageViewRadioAvatar)
            binding.textViewRadioName.text = radioItem.radioName
            binding.textViewRadioFrequency.text = radioItem.band
            binding.executePendingBindings()
        }

        companion object {

            fun create(parent: ViewGroup): RadioItemViewHolder {
                val binding = DataBindingUtil.inflate<ItemRadioBinding>(LayoutInflater.from(parent.context),
                    R.layout.item_radio,parent,false)
                return RadioItemViewHolder(binding)

            }
        }

    }
}