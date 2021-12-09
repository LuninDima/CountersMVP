package com.example.countersmvp.model

import com.example.countersmvp.presenter.EnumToIndexMapper

class CountersModel(private val mapper: EnumToIndexMapper) {

    val counters = mutableListOf(0, 0, 0)

    fun getCurrent(enum: ButtonTypeEnam): Int {
        val index = mapper.mapEnumToIndex(enum)
        return counters[index]
    }

    fun next(enum: ButtonTypeEnam): Int {
        val index = mapper.mapEnumToIndex(enum)
      counters[index]++
        return getCurrent(enum)
    }
}
