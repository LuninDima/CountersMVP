package com.example.countersmvp.view

import android.os.Bundle
import com.example.countersmvp.databinding.ActivityMainBinding
import com.example.countersmvp.presenter.MainPresenter
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {
    private lateinit var mainActivityBinding: ActivityMainBinding
    private val presenter by moxyPresenter { MainPresenter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainActivityBinding.root)
    }

}