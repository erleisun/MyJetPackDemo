package com.qinggan.myjetpackdemo.ui.login

import android.os.Bundle
import com.qinggan.myjetpackdemo.BR
import com.qinggan.myjetpackdemo.R
import com.qinggan.myjetpackdemo.bean.BannerBean
import com.qinggan.myjetpackdemo.databinding.FragmentLoginBinding
import com.qinggan.myjetpackdemo.ui.BaseFragment
import com.qinggan.myjetpackdemo.ui.base.DataBindingConfig

class LoginFragment : BaseFragment() {

    companion object {
        val TAG = LoginFragment::class.java.simpleName
    }

    private lateinit var loginViewMode: LoginViewMode
    private lateinit var mFragmentLoginBinding: FragmentLoginBinding

    override fun observe() {
    }

    private fun initView() {

    }

    override fun init(savedInstanceState: Bundle?) {
        initView()
    }

    override fun getLayoutID(): Int {
        return R.layout.fragment_login
    }

    override fun initViewModel() {
        super.initViewModel()
        loginViewMode = getFragmentViewMode(LoginViewMode::class.java)
    }

    override fun getDataBindingConfig(): DataBindingConfig? {

//        return DataBindingConfig(getLayoutID(), loginViewMode)
//            .addDataBindingParams(BR.fragmentHome, loginViewMode)
        return null
    }

}