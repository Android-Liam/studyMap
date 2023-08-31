package com.example.a07_viewpager2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class ScreenSlidePageFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layoutResId = when (arguments?.getInt(ARG_LAYOUT_RES_ID)) {
            R.layout.fragment_layout1 -> R.layout.fragment_layout1
            R.layout.fragment_layout2 -> R.layout.fragment_layout2
            // Add more cases for other layouts
            else -> throw IllegalArgumentException("Invalid layout resource ID")
        }
        return inflater.inflate(layoutResId, container, false)
    }

    companion object {
        private const val ARG_LAYOUT_RES_ID = "layoutResId"

        fun newInstance(layoutResId: Int): ScreenSlidePageFragment {
            val fragment = ScreenSlidePageFragment()
            val args = Bundle()
            args.putInt(ARG_LAYOUT_RES_ID, layoutResId)
            fragment.arguments = args
            return fragment
        }
    }

}