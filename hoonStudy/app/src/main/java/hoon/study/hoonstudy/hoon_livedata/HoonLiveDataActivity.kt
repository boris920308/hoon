package hoon.study.hoonstudy.hoon_livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import hoon.study.hoonstudy.BaseActivity
import hoon.study.hoonstudy.R
import hoon.study.hoonstudy.databinding.ActivityHoonLiveDataBinding

class HoonLiveDataActivity : BaseActivity<ActivityHoonLiveDataBinding>({ ActivityHoonLiveDataBinding.inflate(it)}) {

    private lateinit var hoonLiveDataViewModel: HoonLiveDataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        hoonLiveDataViewModel = ViewModelProvider(this).get(HoonLiveDataViewModel::class.java)

        setResult()

        binding.btnIncrease.setOnClickListener {
            hoonLiveDataViewModel.hoonLiveDataIncrease()
        }

        hoonLiveDataViewModel.hoonLiveData.observe(
            this,
            Observer { setResult() }
        )

    }

    private fun setResult() {
        binding.tvContent.text = hoonLiveDataViewModel.hoonLiveData.value.toString()
    }
}