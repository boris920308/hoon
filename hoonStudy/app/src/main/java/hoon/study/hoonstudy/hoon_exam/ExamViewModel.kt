package hoon.study.hoonstudy.hoon_exam

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class ExamViewModel : ViewModel() {

    private val _validation1 = MutableSharedFlow<String>()
    val validation1 = _validation1.asSharedFlow()
    private val _validation2 = MutableSharedFlow<String>()
    val validation2 = _validation2.asSharedFlow()

    private val _loginBtnEvent = MutableSharedFlow<Boolean>()
    val loginBtnEvent = _loginBtnEvent.asSharedFlow()


//    private val _loginBtnEvent = MutableSharedFlow<Boolean>()
//    val loginBtnEvent = _loginBtnEvent.asSharedFlow()

//    fun isLoginEnabled() {
//        viewModelScope.launch {
//
//        }
//    }

    fun tempCounting(length: Int) {
        viewModelScope.launch {
            Log.d("ExamViewModel", "tempCounting_1, length = $length")
            _loginBtnEvent.emit(length > 5)
        }
    }

}