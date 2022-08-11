package com.vishnevskiypro.retrofitpractice8

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.vishnevskiypro.retrofitpractice8.screens.first.FirstFragment
import com.vishnevskiypro.retrofitpractice8.screens.second.SecondFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 2
    }


    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> {
                return FirstFragment()
            }

            else -> {
                return  SecondFragment()
            }
        }
    }
}