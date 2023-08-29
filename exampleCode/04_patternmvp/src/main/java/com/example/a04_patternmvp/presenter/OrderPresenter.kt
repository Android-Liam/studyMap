package com.example.a04_patternmvp.presenter

import com.example.a04_patternmvp.model.Americano
import com.example.a04_patternmvp.model.Beverage
import com.example.a04_patternmvp.view.OrderView

class OrderPresenter(
    private var view: OrderView,
    private var menuModel: Beverage = Americano(),
) : Presenter {
    override fun deleteAmericano() {
        menuModel.delete()
        view.setAmericanoCounterText(menuModel.quantity)
    }

    override fun addAmericano() {
        menuModel.add()
        view.setAmericanoCounterText(menuModel.quantity)
    }

}