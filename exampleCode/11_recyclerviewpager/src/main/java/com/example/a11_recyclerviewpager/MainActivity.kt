package com.example.a11_recyclerviewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val data = listOf("Apple", "Banana", "Cherry", "Date", "Fig", "Grape", "Kiwi")
        val adapter = MyRecyclerViewAdapter(data)
        recyclerView.adapter = adapter
    }
}
