package com.hoon.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.hoon.viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // view model 적용
//        val myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)
//        myViewModel.counter = 100
//        binding.mainTv.text = myViewModel.counter.toString()
//        binding.mainBtn.setOnClickListener {
//            myViewModel.counter += 1
//            binding.mainTv.text = myViewModel.counter.toString()
//        }

        // view model factory 적용
        val factory = MyViewModelFactory(100, this)
//        val myViewModel = ViewModelProvider(this, factory).get(MyViewModel::class.java)
        val myViewModel by viewModels<MyViewModel>() { factory }

        binding.mainTv.text = myViewModel.counter.toString()
        binding.mainBtn.setOnClickListener {
            myViewModel.counter += 1
            binding.mainTv.text = myViewModel.counter.toString()
            myViewModel.saveState()
        }
    }
}