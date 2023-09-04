package com.example.a11_viewpagepr

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    // 커스텀 페이지 레이아웃 리소스 ID 배열(순서대로)
    private val fragments = listOf(
        Page1Fragment(),
        Page2Fragment(),
        Page3Fragment(),
        Page4Fragment()
    )

    override fun getItemCount(): Int {
        // 페이지 수 반환
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}