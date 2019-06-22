package com.maymanm.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import androidx.databinding.DataBindingUtil
import  com.maymanm.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
   private lateinit var bind: ActivityMainBinding
    private var myName:MyName = MyName("Mahmoud")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind = DataBindingUtil.setContentView(this,R.layout.activity_main)
        bind.myName = myName
        bind.button.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
        bind.apply {
            myName?.nickName = nicknameEdittxt.text.toString()
            invalidateAll() //refresh UI
            nicknameEdittxt.visibility = View.GONE
            button.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }
}
