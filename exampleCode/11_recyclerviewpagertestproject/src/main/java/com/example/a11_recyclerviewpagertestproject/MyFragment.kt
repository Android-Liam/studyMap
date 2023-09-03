package com.example.a11_recyclerviewpagertestproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MyFragment : Fragment() {

    private var content: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            content = it.getString(ARG_CONTENT)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_my, container, false)
        val textView = view.findViewById<TextView>(R.id.textView)
        textView.text = content
        return view
    }

    companion object {
        private const val ARG_CONTENT = "content"

        fun newInstance(content: String): MyFragment {
            val fragment = MyFragment()
            val args = Bundle()
            args.putString(ARG_CONTENT, content)
            fragment.arguments = args
            return fragment
        }
    }
}
