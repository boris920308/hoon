package hoon.study.hoonstudy.hoon_exam

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import hoon.study.hoonstudy.BaseActivity
import hoon.study.hoonstudy.databinding.ActivityExamBinding
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
                lifecycleScope.launch {
                    examViewModel.vali_1(p0.toString().length)
                    examViewModel.validationText()
                }
            }
        })

        binding.tv2.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                override fun afterTextChanged(p0: Editable?) {
                    examViewModel.vali_2(p0.toString().length)
                    examViewModel.validationText()
                }
            }
        )

        lifecycleScope.launch {
            launch {
                examViewModel.validation1.collect() {
                    binding.btnLogin.isEnabled = it
                }
            }
        }
    }

}