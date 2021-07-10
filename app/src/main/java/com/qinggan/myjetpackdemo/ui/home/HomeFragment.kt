package com.qinggan.myjetpackdemo.ui.home

import android.os.Bundle
import com.qinggan.myjetpackdemo.BR
import com.qinggan.myjetpackdemo.R
import com.qinggan.myjetpackdemo.databinding.FragmentHomeBinding
import com.qinggan.myjetpackdemo.ui.BaseFragment
import com.qinggan.myjetpackdemo.ui.base.DataBindingConfig

class HomeFragment : BaseFragment() {

    companion object {
        val TAG = HomeFragment::class.java
    }

    private lateinit var homeViewModel: HomeViewModel


    override fun init(savedInstanceState: Bundle?) {
        mBinding as FragmentHomeBinding
        (mBinding as FragmentHomeBinding).textHome.text = homeViewModel.text.value
    }


    override fun getLayoutID(): Int {
        return R.layout.fragment_home
    }

    override fun initViewModel() {
        super.initViewModel()
        homeViewModel = getFragmentViewMode(HomeViewModel::class.java)
    }

    override fun getDataBindingConfig(): DataBindingConfig? {

        return DataBindingConfig(getLayoutID(), homeViewModel)
            .addDataBindingParams(BR.fragmentHome, homeViewModel)

    }

}