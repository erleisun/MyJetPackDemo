package com.qinggan.myjetpackdemo.ui.dashboard

import android.os.Bundle
import com.qinggan.myjetpackdemo.R
import com.qinggan.myjetpackdemo.databinding.FragmentDashboardBinding
import com.qinggan.myjetpackdemo.ui.BaseFragment
import com.qinggan.myjetpackdemo.ui.base.DataBindingConfig
import com.qinggan.myjetpackdemo.BR

class DashboardFragment : BaseFragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.

    override fun getLayoutID(): Int? {
        return R.layout.fragment_dashboard

    }

    override fun initViewModel() {
        super.initViewModel()
        dashboardViewModel = getFragmentViewMode(DashboardViewModel::class.java)
    }

    override fun init(savedInstanceState: Bundle?) {
        _binding = mBinding as FragmentDashboardBinding
    }

    override fun getDataBindingConfig(): DataBindingConfig? {
        return DataBindingConfig(R.layout.fragment_dashboard, dashboardViewModel)
            .addDataBindingParams(BR.fragmentDashboard, dashboardViewModel)
    }
}