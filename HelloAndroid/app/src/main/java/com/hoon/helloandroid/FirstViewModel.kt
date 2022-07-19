package com.hoon.helloandroid

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FirstViewModel : ViewModel() {

//    private var count = MutableLiveData<Int>()
//    val countData : LiveData<Int>
//    get() = count
//
//    init {
//        count.value = 0
//    }
//
//    fun updateCount() {
//        count.value = (count.value)?.plus(1)
//    }


//    private var firstString = ""

    private var firstString = MutableLiveData<String>()
    val firstStringValue: LiveData<String>
        get() = firstString

    init {
//        firstString = "Hello FirstFragment"
        firstString.value = "Hello FirstLiveData"
    }



    fun getUpdateFirstString() {
        firstString.value += "a"
//        return firstString
    }
}