package com.qinggan.myjetpackdemo.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.qinggan.myjetpackdemo.ui.base.DataBindingConfig
import com.qinggan.myjetpackdemo.utils.ParamsUtil

abstract class BaseFragment : Fragment() {

    lateinit var mActivity: AppCompatActivity
    lateinit var mContext: Context
    public var mBinding: ViewDataBinding? = null
    private var mActivityProvider: ViewModelProvider? = null
    private var mFragmentProvider: ViewModelProvider? = null

    companion object {
        val TAG = BaseFragment::class.simpleName
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context
        this.mActivity = context as AppCompatActivity
        initViewModel()
        ParamsUtil.initParams(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        getLayoutID()?.let {
            var binding: ViewDataBinding =
                DataBindingUtil.inflate(layoutInflater, it, container, false)

            //将ViewDataBinding生命周期与Fragment绑定
            binding.lifecycleOwner = viewLifecycleOwner

            getDataBindingConfig()?.apply {
                val bindingParams = bindingParams
                for (i in 0 until bindingParams.size()) {
                    binding.setVariable(bindingParams.keyAt(i), bindingParams.valueAt(i))
                }
            }
            mBinding = binding

            return mBinding?.root
        }

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(savedInstanceState)
5    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding?.unbind()
        mBinding = null
    }

    /**
     * 通過Acitiviy獲取ViewMode,生命周期跟隨Activity
     */
    fun <T : ViewModel?> getActivityViewMode(modeClass: Class<T>): T {

        if (mActivityProvider == null) {
            mActivityProvider = ViewModelProvider(mActivity)
        }

        return mActivityProvider!!.get(modeClass)
    }

    /**
     * 通過當前Fragment獲取ViewMode,生命周期同當期Fragment
     */
    fun <T : ViewModel> getFragmentViewMode(modeClass: Class<T>): T {

        if (mFragmentProvider == null) {
            mFragmentProvider = ViewModelProvider(this)
        }

        return mFragmentProvider!!.get(modeClass)
    }


    /**
     * 初始化viewModel
     * 之所以没有设计为抽象，是因为部分简单activity可能不需要viewModel
     * observe同理
     */
    open fun initViewModel() {

    }

    /**
     * 获取layout布局
     */
    abstract fun getLayoutID(): Int?

    /**
     * 初始化入口
     */
    abstract fun init(savedInstanceState: Bundle?)

    /**
     * 获取dataBinding配置项
     */
    abstract fun getDataBindingConfig(): DataBindingConfig?

    fun nav():NavController{
        return NavHostFragment.findNavController(this)
    }

}