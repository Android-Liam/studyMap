package com.example.a11_recyclerviewpagertestproject

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyViewAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    private val numPages = 5 // 페이지 수를 변경할 수 있습니다.

    override fun getItemCount(): Int {
        return numPages
    }

    override fun createFragment(position: Int): Fragment {
        // 각 페이지의 컨텐츠를 설정합니다.
        return MyFragment.newInstance("Page ${position + 1}")
    }
}
