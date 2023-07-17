package hoon.study.hoonstudy.hoon_exam

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class ExamViewModel : ViewModel() {

    private val _validation1 = MutableSharedFlow<Boolean>()
    val validation1 = _validation1.asSharedFlow()
    private var tv1Length: Int = 0
    private var tv2Length: Int = 0

    fun validationText() {
        viewModelScope.launch {
            _validation1.emit(tv1Length > 3 && tv2Length > 5)
        }
    }

    fun vali_1(length: Int) {
        tv1Length = length
    }

    fun vali_2(length: Int) {
        tv2Length = length
    }


}