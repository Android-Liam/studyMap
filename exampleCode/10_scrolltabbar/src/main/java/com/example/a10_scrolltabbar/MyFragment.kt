package com.example.a10_scrolltabbar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

abstract class MyFragment : Fragment() {

    abstract fun getTabTitle(): String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 해당 탭의 내용을 표시하는 View를 생성하고 반환합니다.
        val view = inflater.inflate(getLayoutResourceId(), container, false)
        val textView = view.findViewById<TextView>(R.id.textView)
        textView.text = getTabTitle()
        return view
    }

    abstract fun getLayoutResourceId(): Int
}
