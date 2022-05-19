package com.qinggan.myjetpackdemo.ui.home

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.lifecycle.Observer
import cn.bingoogolapple.bgabanner.BGABanner
import com.qinggan.myjetpackdemo.BR
import com.qinggan.myjetpackdemo.R
import com.qinggan.myjetpackdemo.bean.BannerBean
import com.qinggan.myjetpackdemo.commom.loadUrl
import com.qinggan.myjetpackdemo.commom.setNoRepeatClick
import com.qinggan.myjetpackdemo.commom.smartConfig
import com.qinggan.myjetpackdemo.databinding.FragmentHomeBinding
import com.qinggan.myjetpackdemo.ui.BaseFragment
import com.qinggan.myjetpackdemo.ui.adapter.ArticleAdapter
import com.qinggan.myjetpackdemo.ui.base.DataBindingConfig
import com.qinggan.myjetpackdemo.utils.KLog

class HomeFragment : BaseFragment(), BGABanner.Adapter<ImageView?, String?>,
    BGABanner.Delegate<ImageView?, String?> {

    companion object {
        val TAG = HomeFragment::class.java.simpleName
    }

    //图片轮训列表
    private var bannerList: MutableList<BannerBean>? = null

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var mFragmentHomeBinding: FragmentHomeBinding
    private val adapter by lazy { ArticleAdapter(mActivity) }

    override fun observe() {
        //监听BannerList数据
        homeViewModel.banner.observe(this, Observer<MutableList<BannerBean>>() {
            bannerList = it
            KLog.d(TAG, "bannerList = ${bannerList!!.size}")
            initBanner()
        })

        homeViewModel._articles.observe(this) {
            adapter.submitList(it)
        }
    }

    /**
     * 给banner控件赋值
     */
    private fun initBanner() {
        mFragmentHomeBinding.banner.apply {
            setAutoPlayAble(true)

            val views: MutableList<View> = ArrayList()
            bannerList?.forEach { _ ->
                views.add(ImageView(mActivity).apply {
                    setBackgroundResource(R.drawable.ic_launcher_background)
                })
            }

            setAdapter(this@HomeFragment)
            setDelegate(this@HomeFragment)
            setData(views)
        }
    }

    private fun initView() {
        mFragmentHomeBinding.smartRefresh.setOnRefreshListener() {
            KLog.d(TAG, "smartRefresh onRefreshListener")
        }

        mFragmentHomeBinding.smartRefresh.setOnLoadMoreListener {
            //上拉刷新
            KLog.d(TAG, "smartRefresh onLoadMoreListener")
        }
        //配置smartRefresh
        mFragmentHomeBinding.smartRefresh.smartConfig()

        setNoRepeatClick(mFragmentHomeBinding.clTitle) {
            KLog.d(TAG, "clTitle click");
        }

        adapter.apply {
            mFragmentHomeBinding.rvHomeList.adapter = this
            //TODO item点击事件

            //TODO item中子but的点击事件
            setOnItemChildClickListener { position, view ->
                when (view.id) {
                    R.id.ivCollect -> KLog.d("click collect $position  and ${currentList[position]}")
                }
            }
        }

        loadData()

    }

    private fun loadData() {
        KLog.d(TAG, "loadData")
        homeViewModel.getBanner()
        homeViewModel.getArticle()
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

    override fun fillBannerItem(banner: BGABanner?, itemView: ImageView?, model: String?, position: Int) {
        itemView?.apply {
            scaleType = ImageView.ScaleType.CENTER
            loadUrl(mActivity, bannerList?.get(position)?.imagePath!!)

        }
    }

    override fun onBannerItemClick(banner: BGABanner?, itemView: ImageView?, model: String?, position: Int) {
        //TODO("Not yet implemented")
    }

}