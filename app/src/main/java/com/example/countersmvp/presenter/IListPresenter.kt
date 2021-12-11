package com.example.countersmvp.presenter

import com.example.countersmvp.view.IndexIntemView
import com.example.countersmvp.view.UserItemView

interface IListPresenter<V: IndexIntemView> {

    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int

}

interface IUserListPresenter: IListPresenter<UserItemView>