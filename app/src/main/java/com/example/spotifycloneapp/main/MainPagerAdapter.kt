package com.example.spotifycloneapp.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.spotifycloneapp.R
import com.example.spotifycloneapp.favorites.FavoriteFragment
import com.example.spotifycloneapp.ui.radios.RadioFragment

class MainPagerAdapter(context: Context, fm: FragmentManager, behavior: Int) :
    FragmentStatePagerAdapter(fm, behavior) {

    private val tabLayoutTexts: Array<String> = context.resources.getStringArray(R.array.tabs)

    override fun getItem(position: Int): Fragment {
        return when (position) {
            POSITION_RADIOS -> RadioFragment()
            POSITION_FAVORITES -> FavoriteFragment()
            else -> throw IllegalStateException("Undefined position $position. Max count is $TAB_COUNT")
        }
    }

    override fun getCount(): Int = TAB_COUNT

    override fun getPageTitle(position: Int): CharSequence? = tabLayoutTexts[position].toUpperCase()

    companion object {

        private const val TAB_COUNT = 2

        private const val POSITION_RADIOS = 0
        private const val POSITION_FAVORITES = 1

    }

}