package com.example.a07_viewpager2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

private class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = NUM_PAGES

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ScreenSlidePageFragment.newInstance(R.layout.fragment_layout1)
            1 -> ScreenSlidePageFragment.newInstance(R.layout.fragment_layout2)
            // Add more cases for other layouts
            else -> throw IllegalArgumentException("Invalid position")
        }
    }
}