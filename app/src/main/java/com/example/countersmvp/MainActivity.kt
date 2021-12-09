package com.example.countersmvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.countersmvp.databinding.ActivityMainBinding
import com.example.countersmvp.model.ButtonTypeEnam
import com.example.countersmvp.model.ButtonUiModel
import com.example.countersmvp.presenter.MainPresenter
import com.example.countersmvp.view.MainView

class MainActivity : AppCompatActivity(), MainView {
    private lateinit var mainActivityBinding: ActivityMainBinding
    val presenter = MainPresenter(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainActivityBinding.root)

   /*     val listener = View.OnClickListener {
            presenter.counterClick(ButtonTypeEnam.FIRST_BUTTON)
            presenter.counterClick(ButtonTypeEnam.SECOND_BUTTON)
            presenter.counterClick(ButtonTypeEnam.THIRD_BUTTON)
        }*/

        mainActivityBinding.btnCounter1.setOnClickListener {
            presenter.counterClick(ButtonTypeEnam.FIRST_BUTTON)
        }
        mainActivityBinding.btnCounter2.setOnClickListener {
            presenter.counterClick(ButtonTypeEnam.SECOND_BUTTON)
        }
        mainActivityBinding.btnCounter3.setOnClickListener {
            presenter.counterClick(ButtonTypeEnam.THIRD_BUTTON)
        }
        presenter.setInitvalue()
    }

    override fun setButtonText(model: ButtonUiModel) {
        when(model.index){
            ButtonTypeEnam.FIRST_BUTTON -> mainActivityBinding.btnCounter1.text = model.value
            ButtonTypeEnam.SECOND_BUTTON -> mainActivityBinding.btnCounter2.text = model.value
            ButtonTypeEnam.THIRD_BUTTON -> mainActivityBinding.btnCounter3.text = model.value
        }
    }
}