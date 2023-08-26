package com.example.examplecode

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.WindowManager
import android.view.WindowMetrics
import com.example.examplecode.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        fun screenSize(windowManager: WindowManager): Pair<Int, Int> {
            val displayMetrics = DisplayMetrics()

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {0
                val windowMetrics: WindowMetrics = windowManager.currentWindowMetrics
                windowMetrics.bounds.let {
                    return Pair(it.width(), it.height())
                }
            } else {
                @Suppress("DEPRECATION")
                windowManager.defaultDisplay.getMetrics(displayMetrics)
                return Pair(displayMetrics.widthPixels, displayMetrics.heightPixels)
            }
        }

        binding.btn.setOnClickListener {

            val windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val (width, height) = screenSize(windowManager)

            binding.textView.text = "width : $width, " + "height : $height"
        }
    }
}