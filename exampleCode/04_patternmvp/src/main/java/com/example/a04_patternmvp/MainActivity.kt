package com.example.a04_patternmvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity(), Presenter.View {
    lateinit var presenter: Presenter
    lateinit var number: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = PresenterImpl()
        presenter.takeView(this)

        number = findViewById(R.id.number)

    }

    override fun changeText(string: String) {
        number.text = string
    }

    fun clickEvent(view: View) {
        presenter.confirm(number.text.toString())
    }
}