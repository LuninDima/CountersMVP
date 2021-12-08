package com.example.countersmvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.example.countersmvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var mainActivityBinding: ActivityMainBinding? = null

    val counters = mutableListOf(0, 0, 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainActivityBinding?.root)
        mainActivityBinding?.btnCounter1?.setOnClickListener {
            mainActivityBinding?.btnCounter1?.text = (++counters[0]).toString()
        }

        mainActivityBinding?.btnCounter2?.setOnClickListener {
            mainActivityBinding?.btnCounter2?.text = (++counters[1]).toString()
        }

        mainActivityBinding?.btnCounter3?.setOnClickListener {
            mainActivityBinding?.btnCounter3?.text = (++counters[2]).toString()
        }

        initViews()

    }

    private fun initViews() {
        mainActivityBinding?.btnCounter1?.text = counters[0].toString()
        mainActivityBinding?.btnCounter2?.text = counters[1].toString()
        mainActivityBinding?.btnCounter3?.text = counters[2].toString()

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putIntArray("counters", counters.toIntArray())
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putIntArray("counters", counters.toIntArray())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val countersArray = savedInstanceState.getIntArray("counters")
        countersArray?.toList()?.let {
            counters.clear()
            counters.addAll(it)
        }
        initViews()
    }
}