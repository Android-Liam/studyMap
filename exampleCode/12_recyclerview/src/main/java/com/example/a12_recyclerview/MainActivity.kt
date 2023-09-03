package com.example.a12_recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a12_recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. RecyclerView 초기화 및 레이아웃 매니저 설정
        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // 2. RecyclerView에 어댑터 연결
        recyclerViewAdapter = RecyclerViewAdapter()
        binding.recyclerView.adapter = recyclerViewAdapter

        // 3. 데이터 추가 (예시)
        val items = mutableListOf<Item>()

        for(i in 1 until 15) {
            items.add(Item("$i", "Hello $i"))
        }

        items.add(Item("Item 1", "Content 1"))

        recyclerViewAdapter.submitList(items)
    }
}

