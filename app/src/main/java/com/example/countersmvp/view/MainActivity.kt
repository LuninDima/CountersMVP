package com.example.countersmvp.view

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countersmvp.databinding.ActivityMainBinding
import com.example.countersmvp.model.GithubUsersRepo
import com.example.countersmvp.presenter.MainPresenter
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {
    private lateinit var mainActivityBinding: ActivityMainBinding
    private val presenter by moxyPresenter { MainPresenter(GithubUsersRepo()) }
    private var adapter: UsersRVAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainActivityBinding.root)
    }

    override fun init() {
        mainActivityBinding.rvUsers.layoutManager = LinearLayoutManager(this)
        adapter = UsersRVAdapter(presenter.usersListPresenter)
        mainActivityBinding.rvUsers.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }


}