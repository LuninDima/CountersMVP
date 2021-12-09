package com.example.countersmvp.presenter

import com.example.countersmvp.model.ButtonTypeEnam
import java.lang.NullPointerException

class EnumToIndexMapper {
    fun mapEnumToIndex(enum:ButtonTypeEnam): Int{
        return when(enum){
            ButtonTypeEnam.FIRST_BUTTON -> 0
            ButtonTypeEnam.SECOND_BUTTON -> 1
            ButtonTypeEnam.THIRD_BUTTON -> 2
        }
    }

    fun mapIndexToEnum(index: Int):ButtonTypeEnam{
        return when(index){
            0 -> ButtonTypeEnam.FIRST_BUTTON
            1 -> ButtonTypeEnam.SECOND_BUTTON
            2 -> ButtonTypeEnam.THIRD_BUTTON
            else -> throw NullPointerException("Not allowed this id")
        }
    }
}