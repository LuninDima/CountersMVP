package com.example.countersmvp.presenter

import com.example.countersmvp.R
import com.example.countersmvp.model.CountersModel
import com.example.countersmvp.view.MainView

class MainPresenter(
    private val view: MainView,
    private val model: CountersModel = CountersModel()
) {

    fun counterClick(id: Int){
        when(id) {
            R.id.btn_counter1 -> {
                val nextValue = model.next(0)
                view.setButtonText(0, nextValue.toString())
            }
            R.id.btn_counter2 -> {
                val nextValue = model.next(1)
                view.setButtonText(1, nextValue.toString())
            }
            R.id.btn_counter3 -> {
                val nextValue = model.next(2)
                view.setButtonText(2, nextValue.toString())
            }
        }
    }
}