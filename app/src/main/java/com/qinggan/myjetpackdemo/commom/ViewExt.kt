package com.qinggan.myjetpackdemo.commom

import android.os.Parcelable
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.scwang.smartrefresh.layout.SmartRefreshLayout

fun ViewPager.initFragment(fragManager: FragmentManager, fragments: MutableList<Fragment>)
        : ViewPager {

    adapter =
        object : FragmentStatePagerAdapter(fragManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            override fun getCount(): Int {
                return fragments.size
            }

            override fun getItem(position: Int): Fragment {
                return fragments[position]
            }

            override fun saveState(): Parcelable? {
                return null
            }

        }
    return this

}

/**
 * ViewPager选中
 */
fun ViewPager.doSelect(selected: (Int) -> Unit) {

    addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            Log.d("doSelect", "position = $position")

        }

        override fun onPageSelected(position: Int) {
            selected(position)
        }

        override fun onPageScrollStateChanged(state: Int) {
        }

    })
}

/**
 * smartRefresh config
 */
fun SmartRefreshLayout.smartConfig() {
    //加载
    setEnableLoadMore(true)
    //刷新
    setEnableRefresh(true)
    //滚动回弹
    setEnableOverScrollDrag(true)
    //不满一页关闭加载
    //setEnableLoadMoreWhenContentNotFull(true)
}

/**
 * 防止重复点击
 */
fun setNoRepeatClick(vararg views: View, interval: Int = 500, onClick: (view: View) -> Unit) {
    views.forEach { view ->
        view.onIntervalClick(interval) {
            onClick.invoke(view)
        }
    }
}

var lastTime = 0L
fun View.onIntervalClick(interval: Int, onClick: () -> Unit) {
    val curTime = System.currentTimeMillis()
    if (curTime - lastTime > interval) {
        return
    }
    lastTime = curTime
    onClick()
}