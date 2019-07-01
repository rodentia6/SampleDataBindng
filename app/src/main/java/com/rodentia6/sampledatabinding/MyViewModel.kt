package com.rodentia6.sampledatabinding

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    private val _flag = MutableLiveData<Boolean>().apply {
        value = false
    }

    val flag: LiveData<Boolean>
        get() = _flag

    fun toggle() {
        _flag.postValue(!(flag.value ?: false))
    }
}