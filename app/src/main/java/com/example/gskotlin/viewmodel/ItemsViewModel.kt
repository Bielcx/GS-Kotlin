package com.example.gskotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gskotlin.model.ItemModel

class ItemsViewModel: ViewModel() {

    private var items = mutableListOf<ItemModel>()
    val itemsLiveData = MutableLiveData<List<ItemModel>>()

    fun addItem(name: String) {
        val item = ItemModel(id = 0, name = name, onRemove = ::removeItem)
        items.add(item)
        itemsLiveData.value = items
    }

    private fun removeItem(item: ItemModel) {
        items.remove(item)
        itemsLiveData.value = items
    }
}