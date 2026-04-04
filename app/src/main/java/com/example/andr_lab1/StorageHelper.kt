package com.example.andr_lab1

import android.content.Context
import java.io.FileNotFoundException

object StorageHelper {

    private const val FILE_NAME = "orders.txt"

    fun saveOrder(context: Context, text: String) {
        context.openFileOutput(FILE_NAME, Context.MODE_APPEND).use { output ->
            output.write((text + "\n\n------------------------------\n\n").toByteArray())
        }
    }

    fun readOrders(context: Context): String {
        return try {
            context.openFileInput(FILE_NAME).bufferedReader().use { it.readText().trim() }
        } catch (e: FileNotFoundException) {
            ""
        }
    }
}