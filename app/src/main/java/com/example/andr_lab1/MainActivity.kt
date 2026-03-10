package com.example.andr_lab1

import android.os.Bundle
import android.widget.*
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etInfo: EditText = findViewById(R.id.etInfo)
        val tvResult: TextView = findViewById(R.id.tvResult)
        val btnOk: Button = findViewById(R.id.btnOk)

        val cbMargherita: CheckBox = findViewById(R.id.cbMargherita)
        val cbPepperoni: CheckBox = findViewById(R.id.cbPepperoni)
        val cbHawaiian: CheckBox = findViewById(R.id.cbHawaiian)

        val cbSmall: CheckBox = findViewById(R.id.cbSmall)
        val cbMedium: CheckBox = findViewById(R.id.cbMedium)
        val cbLarge: CheckBox = findViewById(R.id.cbLarge)

        val cbCheese: CheckBox = findViewById(R.id.cbCheese)
        val cbMushrooms: CheckBox = findViewById(R.id.cbMushrooms)
        val cbOlives: CheckBox = findViewById(R.id.cbOlives)

        btnOk.setOnClickListener {
            val info = etInfo.text.toString().trim()

            val types = mutableListOf<String>()
            if (cbMargherita.isChecked) types.add("Маргарита")
            if (cbPepperoni.isChecked) types.add("Пепероні")
            if (cbHawaiian.isChecked) types.add("Гавайська")

            val sizes = mutableListOf<String>()
            if (cbSmall.isChecked) sizes.add("Мала (25 см)")
            if (cbMedium.isChecked) sizes.add("Середня (30 см)")
            if (cbLarge.isChecked) sizes.add("Велика (35 см)")

            val extras = mutableListOf<String>()
            if (cbCheese.isChecked) extras.add("Додатковий сир")
            if (cbMushrooms.isChecked) extras.add("Гриби")
            if (cbOlives.isChecked) extras.add("Оливки")

            if (info.isEmpty() || types.isEmpty() || sizes.isEmpty()) {
                Toast.makeText(this, "Завершіть введення всіх даних", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            tvResult.text =
                "Замовник/коментар: $info\n" +
                        "Тип: ${types.joinToString(", ")}\n" +
                        "Розмір: ${sizes.joinToString(", ")}\n" +
                        "Додатки: ${if (extras.isEmpty()) "немає" else extras.joinToString(", ")}"
        }
    }
}
