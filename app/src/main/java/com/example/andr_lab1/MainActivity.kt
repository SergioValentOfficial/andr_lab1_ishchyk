package com.example.andr_lab1

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: OrderViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[OrderViewModel::class.java]

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.inputContainer, InputFragment())
                .commit()
        }

        val resultContainer = findViewById<View>(R.id.resultContainer)

        viewModel.orderData.observe(this) { data ->
            if (data != null) {
                resultContainer.visibility = View.VISIBLE

                if (supportFragmentManager.findFragmentById(R.id.resultContainer) == null) {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.resultContainer, ResultFragment())
                        .commit()
                }
            } else {
                supportFragmentManager.findFragmentById(R.id.resultContainer)?.let { fragment ->
                    supportFragmentManager.beginTransaction()
                        .remove(fragment)
                        .commit()
                }
                resultContainer.visibility = View.GONE
            }
        }
    }
}