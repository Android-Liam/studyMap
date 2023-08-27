package com.example.a04_patternmvp

interface Presenter {
    fun takeView(view: View)
    fun confirm(string: String)

    interface View {
        fun changeText(string: String)
    }
}