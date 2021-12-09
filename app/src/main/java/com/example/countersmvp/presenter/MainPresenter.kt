package com.example.countersmvp.presenter

import com.example.countersmvp.model.ButtonTypeEnam
import com.example.countersmvp.model.ButtonUiModel
import com.example.countersmvp.model.CountersModel
import com.example.countersmvp.view.MainView

class MainPresenter(
    private val view: MainView) {
    private val mapper = EnumToIndexMapper()
    private val model = CountersModel(mapper)

    fun setInitvalue() {
        val countersCount = ButtonTypeEnam.values().size - 1
        for(index in 0..countersCount){
            val enumValue = mapper.mapIndexToEnum(index)
            val uiModel = ButtonUiModel(enumValue, model.getCurrent(enumValue).toString())
            view.setButtonText(uiModel)
    }
    }
    fun counterClick(type: ButtonTypeEnam){
        val nextValue = model.next(type)
        val uiModel = ButtonUiModel(type, nextValue.toString())
        view.setButtonText(uiModel)
    }
}