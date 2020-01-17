package com.example.mvvmdemo.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmdemo.R
import com.example.mvvmdemo.ui.viewModels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        getTodo(1)
    }

    private fun getTodo(i: Int) {
        viewModel.getTodoForUserId(i).observe(this, Observer {
            if(it.isSuccess()) {
                consoleTextView.text = it.toString()
            } else {
                consoleTextView.text = it.error?.mMessage ?: "error"
            }
        })
    }
}
