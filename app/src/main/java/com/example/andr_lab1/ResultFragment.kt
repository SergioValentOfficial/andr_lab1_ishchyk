package com.example.andr_lab1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class ResultFragment : Fragment(R.layout.fragment_result) {

    private lateinit var viewModel: OrderViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[OrderViewModel::class.java]

        val tvResult: TextView = view.findViewById(R.id.tvResult)
        val btnCancel: Button = view.findViewById(R.id.btnCancel)

        viewModel.orderData.observe(viewLifecycleOwner) { data ->
            if (data != null) {
                tvResult.text =
                    "Замовник/коментар: ${data.info}\n" +
                            "Тип: ${data.types.joinToString(", ")}\n" +
                            "Розмір: ${data.sizes.joinToString(", ")}\n" +
                            "Додатки: ${if (data.extras.isEmpty()) "немає" else data.extras.joinToString(", ")}"
            }
        }

        btnCancel.setOnClickListener {
            viewModel.clearAll()
        }
    }
}