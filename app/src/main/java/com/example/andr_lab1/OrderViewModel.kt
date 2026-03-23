package com.example.andr_lab1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrderViewModel : ViewModel() {

    private val _orderData = MutableLiveData<OrderData?>(null)
    val orderData: LiveData<OrderData?> = _orderData

    private val _clearFormEvent = MutableLiveData(0)
    val clearFormEvent: LiveData<Int> = _clearFormEvent

    fun setOrder(data: OrderData) {
        _orderData.value = data
    }

    fun clearAll() {
        _orderData.value = null
        _clearFormEvent.value = (_clearFormEvent.value ?: 0) + 1
    }
}