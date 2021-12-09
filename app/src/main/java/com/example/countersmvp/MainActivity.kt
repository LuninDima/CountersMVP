package com.example.countersmvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import com.example.countersmvp.databinding.ActivityMainBinding
import com.example.countersmvp.presenter.MainPresenter
import com.example.countersmvp.view.MainView

class MainActivity : AppCompatActivity(), MainView {
    private var mainActivityBinding: ActivityMainBinding? = null
    val presenter = MainPresenter(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainActivityBinding?.root)

        val listener = View.OnClickListener {
            presenter.counterClick(it.id)
        }

        mainActivityBinding?.btnCounter1?.setOnClickListener(listener)
        mainActivityBinding?.btnCounter2?.setOnClickListener(listener)
        mainActivityBinding?.btnCounter3?.setOnClickListener(listener)
    }

    override fun setButtonText(index: Int, text: String) {
        when(index){
            0 -> mainActivityBinding?.btnCounter1?.text = text
            1 -> mainActivityBinding?.btnCounter2?.text = text
            2 -> mainActivityBinding?.btnCounter3?.text = text
        }
    }
}