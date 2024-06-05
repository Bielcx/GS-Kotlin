package com.example.gskotlin.model

data class ItemModel(
    val id: Int,
    val name: String,
    val onRemove: (ItemModel) -> Unit
)