package com.example.countersmvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.countersmvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val mainActivityBinding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainActivityBinding?.root)


    }
}