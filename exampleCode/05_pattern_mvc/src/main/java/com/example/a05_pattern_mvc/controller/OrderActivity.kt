package com.example.a05_pattern_mvc.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.a05_pattern_mvc.R
import com.example.a05_pattern_mvc.model.Americano

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val americanoModel = Americano()

        val deleteBtn = findViewById<TextView>(R.id.deleteBtn)
        val addBtn = findViewById<TextView>(R.id.addBtn)
        val cntText = findViewById<TextView>(R.id.cntText)

        deleteBtn.setOnClickListener {
            americanoModel.delete()
            cntText.text = "${americanoModel.quantity}"
        }

        addBtn.setOnClickListener {
            americanoModel.add()
            cntText.text = "${americanoModel.quantity}"
        }
    }
}