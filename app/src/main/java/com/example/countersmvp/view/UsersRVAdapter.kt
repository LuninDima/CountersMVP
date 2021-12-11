package com.example.countersmvp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.countersmvp.databinding.TvItemUserBinding
import com.example.countersmvp.presenter.IUserListPresenter

class UsersRVAdapter(val presenter: IUserListPresenter):
    RecyclerView.Adapter<UsersRVAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(TvItemUserBinding.inflate(LayoutInflater.from(parent.context),
        parent, false)).apply {
            itemView.setOnClickListener {
                presenter.itemClickListener?.invoke(this)
            }
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        presenter.bindView(holder.apply { pos = position })

    override fun getItemCount() = presenter.getCount()

    inner class ViewHolder(val vb: TvItemUserBinding): RecyclerView.ViewHolder(vb.root),
        UserItemView{
        override var pos = -1
        override fun setLogin(text: String) = with(vb) {
            tvLogin.text = text
        }
    }
}