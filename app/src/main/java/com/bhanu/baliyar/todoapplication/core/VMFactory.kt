package com.bhanu.baliyar.todoapplication.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class VMFactory(private val creators: Map<Class<out ViewModel>, () -> ViewModel>) :
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val creator = creators[modelClass]
            ?: creators.entries.firstOrNull() { modelClass.isAssignableFrom(it.key) }?.value
            ?: (throw IllegalArgumentException ("Unknown VM"))
        return creator.invoke() as T
    }
}