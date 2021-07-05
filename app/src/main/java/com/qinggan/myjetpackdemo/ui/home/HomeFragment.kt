package com.qinggan.myjetpackdemo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.qinggan.myjetpackdemo.R
import com.qinggan.myjetpackdemo.databinding.FragmentHomeBinding
import com.qinggan.myjetpackdemo.ui.BaseFragment
import com.qinggan.myjetpackdemo.ui.base.DataBindingConfig

class HomeFragment : BaseFragment() {

//    private lateinit var homeViewModel: HomeViewModel
//    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
//    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        homeViewModel =
//            ViewModelProvider(this).get(HomeViewModel::class.java)
//
//        _binding = FragmentHomeBinding.inflate(inflater, container, false)
//        val root: View = binding.root
//
//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })

        return super.onCreateView(inflater, container, savedInstanceState)
//        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
//        _binding = null
    }

    override fun getLayoutID(): Int? {
        return R.layout.fragment_home
    }

    override fun init(savedInstanceState: Bundle?) {
        TODO("Not yet implemented")
    }

    override fun getDataBindingConfig(): DataBindingConfig? {
        TODO("Not yet implemented")
    }
}