package com.hoon.helloandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.hoon.helloandroid.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {


    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        val view = inflater.inflate(R.layout.fragment_first, container, false)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val firstViewModel = ViewModelProvider(this).get(FirstViewModel::class.java)
        binding.firstDataVM = firstViewModel
        binding.lifecycleOwner = this

//        firstViewModel.firstStringValue.observe(viewLifecycleOwner, Observer {
//            binding.textView.text = it.toString()
//        })

        binding.firstBtn00.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_firstFragment_to_secondFragment)
        }
//
//        binding.firstBtnUpdateString.setOnClickListener {
//            firstViewModel.getUpdateFirstString()
//        }
    }
}