package com.qinggan.myjetpackdemo.commom

import android.os.Parcelable
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager

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