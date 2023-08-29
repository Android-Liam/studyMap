package com.example.a04_patternmvp.model

open class Beverage(price: Int) {
    var price = price
    var quantity = 0

    open fun add() {}
    open fun delete() {}
}