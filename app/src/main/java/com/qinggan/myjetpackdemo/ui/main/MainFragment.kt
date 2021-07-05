package com.qinggan.myjetpackdemo.ui.main

import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.qinggan.myjetpackdemo.BR
import com.qinggan.myjetpackdemo.R
import com.qinggan.myjetpackdemo.databinding.FragmentMainBinding
import com.qinggan.myjetpackdemo.ui.BaseFragment
import com.qinggan.myjetpackdemo.ui.base.DataBindingConfig
import com.qinggan.myjetpackdemo.ui.dashboard.DashboardFragment
import com.qinggan.myjetpackdemo.ui.home.HomeFragment
import com.qinggan.myjetpackdemo.ui.notifications.NotificationsFragment

class MainFragment : BaseFragment() {

    companion object {
        val TAG = MainFragment::class.simpleName
    }

    private var fragmentList = arrayListOf<Fragment>()

    //by lazy 第一次使用时加载
    private val homeFragment by lazy { HomeFragment() }

    //传入Fragment带参数 type = 1
    private val dashboardFragment by lazy {
        DashboardFragment().apply {
            arguments = Bundle().apply { putInt("type", 1) }
        }
    }

    private val notificationsFragment by lazy { NotificationsFragment() }

    init {
        fragmentList.apply {
            fragmentList.add(homeFragment)
            fragmentList.add(dashboardFragment)
            fragmentList.add(notificationsFragment)
        }
    }

    override fun initViewModel() {
        super.initViewModel()
    }

    override fun getLayoutID() = R.layout.fragment_main

    override fun init(savedInstanceState: Bundle?) {

        (mBinding as FragmentMainBinding).navView.run {
            setOnNavigationItemReselectedListener { item ->
                when (item.itemId) {
                    R.id.navigation_home -> println("click navigation_home")
                    R.id.navigation_dashboard -> println("click navigation_dashboard")
                    R.id.navigation_notifications -> println("click navigation_notifications")
                    else -> println("click others")
                }
                true
            }
        }
    }

    override fun getDataBindingConfig(): DataBindingConfig? {
        return DataBindingConfig(
            R.layout.fragment_main,
            getFragmentViewMode(MainViewMode::class.java)
        )
            .addDataBindingParams(BR.fragment_main, getFragmentViewMode(MainViewMode::class.java))
    }


}