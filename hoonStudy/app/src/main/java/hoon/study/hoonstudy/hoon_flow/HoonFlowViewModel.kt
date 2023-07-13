package hoon.study.hoonstudy.hoon_flow

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class HoonFlowViewModel : ViewModel() {

    private val _hoonFlowData = MutableSharedFlow<Int>()
    val hoonFlowData = _hoonFlowData.asSharedFlow()

    private val _showToastEvent = MutableSharedFlow<String>()
    val showToastEvent = _showToastEvent.asSharedFlow()

    init {
    }

    fun showToast(msg: String) {
        viewModelScope.launch {
            _showToastEvent.emit(msg)
        }
    }

    fun increaseHoonFlowData() {
        Log.d("HoonFlowViewModel", "run increaseHoonFlowData()")
    }

    fun setHoonFlowData(value: Int) {
        viewModelScope.launch {
            _hoonFlowData.emit(value)
        }
    }


}