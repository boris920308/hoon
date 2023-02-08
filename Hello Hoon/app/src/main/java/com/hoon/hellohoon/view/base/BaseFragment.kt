package com.hoon.hellohoon.view.base

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<T: ViewDataBinding> (
    @LayoutRes val layoutRes:Int
    ) : Fragment() {

    private var _binding: T? = null
    protected val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Frag", "onCreate()")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("Frag", "onCreateView()")
        _binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("Frag", "onViewCreated()")
        binding.lifecycleOwner = viewLifecycleOwner
        initFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Frag", "onDestroy()")
        _binding = null
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("Frag", "onAttach()")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("Frag", "onDetach()")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Frag", "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Frag", "onPause()")
    }

    override fun onStart() {
        super.onStart()
        Log.i("Frag", "onStart()")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Frag", "onStop()")
    }

    protected abstract fun initFragment()
}