package hoon.study.hoonstudy.hoon_livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HoonLiveDataViewModel : ViewModel() {

    private var _hoonLiveData = MutableLiveData<Int>()
    val hoonLiveData: LiveData<Int>
        get() = _hoonLiveData

    init {
        _hoonLiveData.value = 11
    }

    fun hoonLiveDataIncrease() {
        _hoonLiveData.value = _hoonLiveData.value?.plus(1)
    }
}