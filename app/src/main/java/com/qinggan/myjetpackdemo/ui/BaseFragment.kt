package com.qinggan.myjetpackdemo.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.qinggan.myjetpackdemo.utils.ParamsUtil

abstract class BaseFragment : Fragment() {

    lateinit var mContext: Context
    private var mBinding: ViewDataBinding? = null

    companion object {
        val TAG = BaseFragment::class.simpleName
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context
        initViewModel()
        ParamsUtil.initParams(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        getLayoutID()?.let {
            var binding: ViewDataBinding =
                DataBindingUtil.inflate(layoutInflater, it, container, false)

            //将ViewDataBinding生命周期与Fragment绑定
            binding.lifecycleOwner = viewLifecycleOwner

            mBinding = binding
            return mBinding?.root
        }

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
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

}