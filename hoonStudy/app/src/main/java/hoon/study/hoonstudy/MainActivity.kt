package hoon.study.hoonstudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hoon.study.hoonstudy.databinding.ActivityMainBinding
import hoon.study.hoonstudy.hoon_coroutine.HoonCoroutineActivity
import hoon.study.hoonstudy.hoon_exam.ExamActivity
import hoon.study.hoonstudy.hoon_flow.HoonFlowActivity
import hoon.study.hoonstudy.hoon_livedata.HoonLiveDataActivity
import hoon.study.hoonstudy.hoon_navi.HoonNaviActivity
import hoon.study.hoonstudy.hoon_rx.HoonRxActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnLivedata.setOnClickListener {
            startActivity(HoonLiveDataActivity::class.java)
        }
        binding.btnFlow.setOnClickListener {
            startActivity(HoonFlowActivity::class.java)
        }
        binding.btnRx.setOnClickListener {
            startActivity(HoonRxActivity::class.java)
        }
        binding.btnExam.setOnClickListener {
            startActivity(ExamActivity::class.java)
        }
        binding.btnCoroutine.setOnClickListener {
            startActivity(HoonCoroutineActivity::class.java)
        }
        binding.btnNavigation.setOnClickListener {
            startActivity(HoonNaviActivity::class.java)
        }

    }

    private fun <T> startActivity(clazz: Class<T>) {
        val intent = Intent(this, clazz)
        startActivity(intent)
    }
}