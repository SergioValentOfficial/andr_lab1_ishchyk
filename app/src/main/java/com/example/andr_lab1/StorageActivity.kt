package com.example.andr_lab1

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity

class StorageActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storage)

        val tvStorage: TextView = findViewById(R.id.tvStorage)

        val savedData = StorageHelper.readOrders(this)

        tvStorage.text = if (savedData.isBlank()) {
            "Сховище порожнє"
        } else {
            savedData
        }
    }
}