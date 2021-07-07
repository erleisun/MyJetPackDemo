package com.qinggan.myjetpackdemo.ui.notifications

import android.os.Bundle
import com.qinggan.myjetpackdemo.BR
import com.qinggan.myjetpackdemo.R
import com.qinggan.myjetpackdemo.databinding.FragmentNotificationsBinding
import com.qinggan.myjetpackdemo.ui.BaseFragment
import com.qinggan.myjetpackdemo.ui.base.DataBindingConfig

class NotificationsFragment : BaseFragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel
    private lateinit var _binding: FragmentNotificationsBinding

    // This property is only valid between onCreateView and
    // onDestroyView.
    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun getLayoutID() = R.layout.fragment_notifications

    override fun init(savedInstanceState: Bundle?) {
        _binding = mBinding as FragmentNotificationsBinding
        _binding.textNotifications.text = notificationsViewModel._text.value

    }

    override fun initViewModel() {
        super.initViewModel()
        notificationsViewModel = getFragmentViewMode(NotificationsViewModel::class.java)
    }

    override fun getDataBindingConfig(): DataBindingConfig? {
        return DataBindingConfig(R.layout.fragment_notifications, notificationsViewModel)
            .addDataBindingParams(BR.fragmentNotification, notificationsViewModel)
    }
}