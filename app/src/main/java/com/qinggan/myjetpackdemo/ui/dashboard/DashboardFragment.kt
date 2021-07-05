package com.qinggan.myjetpackdemo.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.qinggan.myjetpackdemo.R
import com.qinggan.myjetpackdemo.databinding.FragmentDashboardBinding
import com.qinggan.myjetpackdemo.ui.BaseFragment
import com.qinggan.myjetpackdemo.ui.base.DataBindingConfig

class DashboardFragment : BaseFragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
                ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun getLayoutID(): Int? {
        TODO("Not yet implemented")
    }

    override fun init(savedInstanceState: Bundle?) {
        TODO("Not yet implemented")
    }

    override fun getDataBindingConfig(): DataBindingConfig? {
        TODO("Not yet implemented")
    }
}