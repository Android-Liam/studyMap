package com.example.a10_widthrecycler

// 패키지 선언 및 필요한 임포트

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.a10_widthrecycler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val itemList = mutableListOf<String>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewPager: ViewPager2
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ViewBinding을 통한 뷰 초기화
        recyclerView = binding.recyclerView
        viewPager = binding.viewPager

        // RecyclerView 초기화
        recyclerView = binding!!.recyclerView
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val adapter = ItemAdapter(itemList)

        // RecyclerView 아이템 클릭 시 ViewPager2 변경
        recyclerView.addOnItemTouchListener(
            RecyclerItemClickListener(this) { position ->
                viewPager.currentItem = position
            }
        )

        recyclerView.adapter = adapter

        // Item 추가 예시
        itemList.add("Item 1")
        itemList.add("Item 2")
        itemList.add("Item 3")
        itemList.add("Item 4")
        itemList.add("Item 5")
        itemList.add("Item 6")

        // ViewPager2 초기화
        viewPager = binding.viewPager
        val pagerAdapter = ItemPagerAdapter(this, itemList)
        viewPager.adapter = pagerAdapter
    }
}

// ItemAdapter 및 ItemPagerAdapter 클래스는 RecyclerView와 ViewPager2의 어댑터를 커스텀하여 구현해야 합니다.
