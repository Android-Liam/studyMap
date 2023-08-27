package com.example.a04_patternmvp

object Model {
    fun clicked(string: String): String {
        return "${string.toInt() + 1}"
    }
}