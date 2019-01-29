package com.example.univisiontest.ui.base

import androidx.lifecycle.ViewModel


abstract class ItemViewModel<ITEM_T> : ViewModel() {
    abstract fun setItem(item: ITEM_T)
}