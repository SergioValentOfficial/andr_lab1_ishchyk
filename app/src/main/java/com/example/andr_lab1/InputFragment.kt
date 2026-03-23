package com.example.andr_lab1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class InputFragment : Fragment(R.layout.fragment_input) {

    private lateinit var viewModel: OrderViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[OrderViewModel::class.java]

        val etInfo: EditText = view.findViewById(R.id.etInfo)
        val btnOk: Button = view.findViewById(R.id.btnOk)

        val cbMargherita: CheckBox = view.findViewById(R.id.cbMargherita)
        val cbPepperoni: CheckBox = view.findViewById(R.id.cbPepperoni)
        val cbHawaiian: CheckBox = view.findViewById(R.id.cbHawaiian)

        val cbSmall: CheckBox = view.findViewById(R.id.cbSmall)
        val cbMedium: CheckBox = view.findViewById(R.id.cbMedium)
        val cbLarge: CheckBox = view.findViewById(R.id.cbLarge)

        val cbCheese: CheckBox = view.findViewById(R.id.cbCheese)
        val cbMushrooms: CheckBox = view.findViewById(R.id.cbMushrooms)
        val cbOlives: CheckBox = view.findViewById(R.id.cbOlives)

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
                Toast.makeText(requireContext(), "Завершіть введення всіх даних", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val order = OrderData(
                info = info,
                types = types,
                sizes = sizes,
                extras = extras
            )

            viewModel.setOrder(order)
        }

        viewModel.clearFormEvent.observe(viewLifecycleOwner) { eventValue ->
            if (eventValue > 0) {
                etInfo.text.clear()

                cbMargherita.isChecked = false
                cbPepperoni.isChecked = false
                cbHawaiian.isChecked = false

                cbSmall.isChecked = false
                cbMedium.isChecked = false
                cbLarge.isChecked = false

                cbCheese.isChecked = false
                cbMushrooms.isChecked = false
                cbOlives.isChecked = false
            }
        }
    }
}