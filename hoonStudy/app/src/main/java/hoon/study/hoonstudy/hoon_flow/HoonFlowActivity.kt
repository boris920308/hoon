package hoon.study.hoonstudy.hoon_flow

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import hoon.study.hoonstudy.BaseActivity
import hoon.study.hoonstudy.databinding.ActivityHoonFlowBinding
import kotlinx.coroutines.launch

class HoonFlowActivity : BaseActivity<ActivityHoonFlowBinding>({ ActivityHoonFlowBinding.inflate(it) }) {

    private lateinit var hoonFlowViewModel: HoonFlowViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        hoonFlowViewModel = ViewModelProvider(this).get(HoonFlowViewModel::class.java)

        lifecycleScope.launch {
            launch {
                hoonFlowViewModel.showToastEvent.collect() { text ->
                    Toast.makeText(this@HoonFlowActivity, text, Toast.LENGTH_SHORT).show()
                }
            }

            launch {
                hoonFlowViewModel.hoonFlowData.collect() { value ->
                    binding.tvContent.text = value.toString()
                }
            }
        }

        binding.btnShowToast.setOnClickListener {
            hoonFlowViewModel.showToast("hello flow")
        }

        binding.btnIncrease.setOnClickListener {
            hoonFlowViewModel.increaseHoonFlowData()
        }

        binding.btnSet.setOnClickListener {
            hoonFlowViewModel.setHoonFlowData(99)
        }

        setResult()
    }

    private fun setResult() {
        Log.d("hoon", "HoonFlowActivity, setResult()")
    }
}