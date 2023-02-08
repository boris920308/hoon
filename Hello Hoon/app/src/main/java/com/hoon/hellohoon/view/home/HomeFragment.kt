package com.hoon.hellohoon.view.home

import android.util.Log
import com.hoon.hellohoon.R
import com.hoon.hellohoon.databinding.FragmentHomeBinding
import com.hoon.hellohoon.view.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home){
    override fun initFragment() {
        Log.i("hoon92", "HomeFrag, initFragment()")
    }

}