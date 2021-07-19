package com.qinggan.myjetpackdemo.ui.home

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.qinggan.myjetpackdemo.BR
import com.qinggan.myjetpackdemo.R
import com.qinggan.myjetpackdemo.bean.BannerBean
import com.qinggan.myjetpackdemo.databinding.FragmentHomeBinding
import com.qinggan.myjetpackdemo.ui.BaseFragment
import com.qinggan.myjetpackdemo.ui.base.DataBindingConfig

class HomeFragment : BaseFragment() {

    companion object {
        val TAG = HomeFragment::class.java.simpleName
    }

    //图片轮训列表
    private var bannerList: MutableList<BannerBean>? = null

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var mFragmentHomeBinding: FragmentHomeBinding

    private fun observe() {
        //监听BannerList数据
        homeViewModel.banner?.observe(this, Observer<MutableList<BannerBean>>() {
            bannerList = it
            Log.d(TAG, "bannerList = $bannerList")
        })
    }

    private fun initBanner() {

    }

    private fun initView() {
//        mFragmentHomeBinding.smartRefresh.setOnRefreshListener() {
//            Log.d(TAG, "onRefresh")
//
//        }

        loadData()

    }

    private fun loadData() {
        homeViewModel.getBanner()
    }

    override fun init(savedInstanceState: Bundle?) {
        mFragmentHomeBinding = (mBinding as FragmentHomeBinding)
        mFragmentHomeBinding.textHome.text = homeViewModel.text.value

        initView()
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