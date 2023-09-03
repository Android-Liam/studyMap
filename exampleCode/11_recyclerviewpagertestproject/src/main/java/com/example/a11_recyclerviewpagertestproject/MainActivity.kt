package com.example.a11_recyclerviewpagertestproject

import MyRecyclerViewAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a11_recyclerviewpagertestproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val recyclerView = binding.recyclerView

        // 데이터 목록을 생성
        val data = listOf("Apple", "Banana", "Cherry", "Date", "Fig", "Grape", "Kiwi")

        // RecyclerView 설정
        val adapter = MyRecyclerViewAdapter(data)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}
