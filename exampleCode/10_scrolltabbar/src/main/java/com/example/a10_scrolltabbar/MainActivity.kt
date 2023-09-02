package com.example.a10_scrolltabbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private val tabLayout: TabLayout by lazy { findViewById(R.id.tabLayout) }
    private val viewPager: ViewPager2 by lazy { findViewById(R.id.viewPager) }
    private val fragmentList = mutableListOf<Fragment>()
    private val tabTitles = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 기본 탭 추가
        addTab(FirstFragment(), "Tab 1")
        addTab(SecondFragment(), "Tab 2")
        addTab(ThirdFragment(), "Tab 3")

        viewPager.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int = fragmentList.size
            override fun createFragment(position: Int): Fragment = fragmentList[position]
        }

        // TabLayout과 ViewPager2를 연결
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()

        // TabLayout 스크롤 리스너 설정
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                // 현재 선택한 탭의 인덱스
                val selectedTabIndex = tabLayout.selectedTabPosition

                // 사용자가 선택한 탭 주변의 탭 추가 또는 제거
                updateTabs(selectedTabIndex)

                // ViewPager의 현재 아이템을 선택한 탭에 맞추기
                viewPager.currentItem = selectedTabIndex
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // Unused
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Unused
            }
        })
    }

    // 탭과 탭 제목을 추가하는 함수
    private fun addTab(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        tabTitles.add(title)
    }

    // 선택한 탭 주변에 탭을 동적으로 추가 또는 제거하는 함수
    private fun updateTabs(selectedTabIndex: Int) {
        // 선택한 탭 주변의 탭 추가 또는 제거
        for (i in selectedTabIndex - 1 downTo 0) {
            if (i >= 0 && !tabTitles.contains("Tab ${i + 1}")) {
                addTab(createFragment(i), "Tab ${i + 1}")
            }
        }
        for (i in selectedTabIndex + 1 until tabTitles.size) {
            if (!tabTitles.contains("Tab ${i + 1}")) {
                addTab(createFragment(i), "Tab ${i + 1}")
            }
        }

        // ViewPager와 TabLayout에 변경된 탭 정보를 반영
        viewPager.adapter?.notifyDataSetChanged()
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }

    // 인덱스에 해당하는 Fragment를 생성하는 함수
    private fun createFragment(index: Int): Fragment {
        return when (index) {
            0 -> FirstFragment()
            1 -> SecondFragment()
            2 -> ThirdFragment()
            // 여기에 추가 탭에 대한 Fragment를 추가하세요.
            else -> FirstFragment() // 기본으로 FirstFragment를 반환
        }
    }
}
