package com.example.a10_widthrecycler

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 전달된 레이아웃 파일 이름을 가져옴
        val layoutFileName = intent.getStringExtra("layoutFileName")

        if (layoutFileName != null) {
            val layoutId = resources.getIdentifier(layoutFileName, "layout", packageName)
            if (layoutId != 0) {
                setContentView(layoutId)
            } else {
                // 레이아웃 파일을 찾을 수 없는 경우 예외 처리
                Toast.makeText(this, "Layout not found", Toast.LENGTH_SHORT).show()
            }
        } else {
            // layoutFileName이 전달되지 않은 경우 예외 처리
            Toast.makeText(this, "Layout file name not provided", Toast.LENGTH_SHORT).show()
        }
    }
}
