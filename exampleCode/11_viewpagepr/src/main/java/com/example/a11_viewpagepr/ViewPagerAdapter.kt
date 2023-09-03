package com.example.a11_viewpagepr

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    // 커스텀 페이지 레이아웃 리소스 ID 배열(순서대로)
    private val customLayouts = arrayOf(
        R.layout.custom_page_1,
        R.layout.custom_page_2,
        R.layout.custom_page_3,
        R.layout.custom_page_4
    )

    override fun getItemCount(): Int {
        // 페이지 수 반환
        return customLayouts.size
    }

    override fun createFragment(position: Int): Fragment {
        // 각 페이지에 해당하는 커스텀 프래그먼트를 생성하여 반환합니다.
        return ViewFragment(customLayouts[position])
    }
}