package com.qinggan.myjetpackdemo.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.qinggan.myjetpackdemo.R
import com.qinggan.myjetpackdemo.ui.BaseFragment

class MainFragment : BaseFragment() {

    companion object {
        val TAG = MainFragment::class.simpleName
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView")

//        _binding = FragmentHomeBinding.inflate(inflater, container, false)
//        val root: View = binding.root
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView")
    }


    override fun getLayoutID() = R.layout.fragment_main
}