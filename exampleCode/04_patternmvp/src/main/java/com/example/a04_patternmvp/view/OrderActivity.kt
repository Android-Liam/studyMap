package com.example.a04_patternmvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.a04_patternmvp.R
import com.example.a04_patternmvp.presenter.OrderPresenter
import org.w3c.dom.Text

class OrderActivity : AppCompatActivity(), OrderView {
    private lateinit var cntText: TextView
    private var present: OrderPresenter = OrderPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val deleteBtn = findViewById<TextView>(R.id.deleteBtn)
        val addBtn = findViewById<TextView>(R.id.addBtn)

        cntText = findViewById<TextView>(R.id.cntText)

        deleteBtn.setOnClickListener {
            present.deleteAmericano()
        }

        addBtn.setOnClickListener {
            present.addAmericano()
        }
    }

    override fun setAmericanoCounterText(count: Int) {
        cntText.text = "$count"
    }

}