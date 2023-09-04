package com.example.a11_viewpagepr

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.a11_viewpagepr.databinding.CustomPage2Binding

class Page2Fragment : Fragment() {

    private var _binding: CustomPage2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CustomPage2Binding.inflate(inflater, container, false)
        val view = binding.root

        binding.btn.setOnClickListener {
            Log.d("Log", "Page 2 Click!")
        }

        return view
    }

}
