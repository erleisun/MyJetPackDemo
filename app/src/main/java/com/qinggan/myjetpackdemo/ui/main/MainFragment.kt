package com.qinggan.myjetpackdemo.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.qinggan.myjetpackdemo.BR
import com.qinggan.myjetpackdemo.R
import com.qinggan.myjetpackdemo.commom.doSelect
import com.qinggan.myjetpackdemo.commom.initFragment
import com.qinggan.myjetpackdemo.databinding.FragmentMainBinding
import com.qinggan.myjetpackdemo.ui.BaseFragment
import com.qinggan.myjetpackdemo.ui.base.DataBindingConfig
import com.qinggan.myjetpackdemo.ui.dashboard.DashboardFragment
import com.qinggan.myjetpackdemo.ui.home.HomeFragment
import com.qinggan.myjetpackdemo.ui.notifications.NotificationsFragment
import com.qinggan.myjetpackdemo.utils.KLog

class MainFragment : BaseFragment() {

    companion object {
        val TAG = MainFragment::class.simpleName
    }

    private lateinit var mFragmentMainBinding: FragmentMainBinding

    private var fragmentList = arrayListOf<Fragment>()

    //by lazy 第一次使用时加载
    private val homeFragment by lazy { HomeFragment() }

    //传入Fragment带参数 type = 1
    private val dashboardFragment by lazy {
        DashboardFragment().apply {
            arguments = Bundle().apply {
                putInt("type", 1)
            }
        }
    }

    private val notificationsFragment by lazy { NotificationsFragment() }

    init {
        fragmentList.let {
            it.add(homeFragment)
            it.add(dashboardFragment)
            it.add(notificationsFragment)
        }
    }

    override fun initViewModel() {
        super.initViewModel()
    }

    override fun getLayoutID() = R.layout.fragment_main

    override fun init(savedInstanceState: Bundle?) {
        mFragmentMainBinding = mBinding as FragmentMainBinding

        mFragmentMainBinding.vpHome.initFragment(childFragmentManager, fragmentList).run {
            offscreenPageLimit = fragmentList.size
        }

        mFragmentMainBinding.vpHome.doSelect() {
            mFragmentMainBinding.navView.menu.getItem(it).isChecked = true
        }

        mFragmentMainBinding.navView.run {
            setOnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.navigation_home -> {
                        KLog.d(TAG, "click navigation_home")
//                        selectedItemId = item.itemId
//                            nav().navigate(R.id.home_fragment)
                        mFragmentMainBinding.vpHome.setCurrentItem(0, false)
                    }
                    R.id.navigation_dashboard -> {
//                        selectedItemId = item.itemId
                        KLog.d(TAG, "click navigation_dashboard")
                        mFragmentMainBinding.vpHome.setCurrentItem(1, false)
                    }
                    R.id.navigation_notifications -> {
                        KLog.d(TAG, "click navigation_notifications")
                        mFragmentMainBinding.vpHome.setCurrentItem(2, false)
                    }
                    else -> KLog.d(TAG, "click others")
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