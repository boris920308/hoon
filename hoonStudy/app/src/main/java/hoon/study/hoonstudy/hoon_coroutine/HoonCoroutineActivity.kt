package hoon.study.hoonstudy.hoon_coroutine

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import hoon.study.hoonstudy.BaseActivity
import hoon.study.hoonstudy.databinding.ActivityHoonCoroutineBinding
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class HoonCoroutineActivity : BaseActivity<ActivityHoonCoroutineBinding>({ ActivityHoonCoroutineBinding.inflate(it)}) {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val result: Boolean

        binding.btn1.setOnClickListener {
//            lifecycleScope.launch {
//                delay(3000)
//                binding.tvResult1.text = "delay 3000"
//            }
        }

        lifecycleScope.launch {
            val value: Int = async {
                var total = 0
                for (i in 1..10) total += i
                total
            }.await()
        }
    }
}