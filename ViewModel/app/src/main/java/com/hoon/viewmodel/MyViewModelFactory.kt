package com.hoon.viewmodel

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner

class MyViewModelFactory(
    private val counter: Int,
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle? = null,
    ) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {

    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        if (modelClass.isAssignableFrom(MyViewModel::class.java)) {
            return MyViewModel(counter, handle) as T
        }
        throw IllegalArgumentException("MyViewModel calss not found");
    }
}