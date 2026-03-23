package com.example.andr_lab1

data class OrderData(
    val info: String,
    val types: List<String>,
    val sizes: List<String>,
    val extras: List<String>
)