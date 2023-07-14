package hoon.study.hoonstudy.hoon_exam

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import hoon.study.hoonstudy.BaseActivity
import hoon.study.hoonstudy.databinding.ActivityExamBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class ExamActivity : BaseActivity<ActivityExamBinding>({ ActivityExamBinding.inflate(it) }){

    private lateinit var examViewModel: ExamViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        examViewModel = ViewModelProvider(this).get(ExamViewModel::class.java)


        binding.tv1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {
                examViewModel.tempCounting(p0.toString().length)
            }
        })

        lifecycleScope.launch {
            launch {
                examViewModel.loginBtnEvent.collect() {
                    Log.d("ExamActivity", "loginBtnEvent is $it")
                    binding.btnLogin.isEnabled = it
                }
            }
        }
    }

}