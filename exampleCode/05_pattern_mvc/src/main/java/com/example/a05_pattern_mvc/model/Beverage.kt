package com.example.a05_pattern_mvc.model

open class Beverage(price: Int) {
    var price = price
    var quantity = 0

    open fun add() {}
    open fun delete() {}
}