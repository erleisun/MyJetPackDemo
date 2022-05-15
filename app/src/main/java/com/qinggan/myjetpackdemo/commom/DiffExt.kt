package com.qinggan.myjetpackdemo.commom

import androidx.recyclerview.widget.DiffUtil
import com.qinggan.myjetpackdemo.bean.ArticleListBean


fun getArticleDiff(): DiffUtil.ItemCallback<ArticleListBean> {

    return object : DiffUtil.ItemCallback<ArticleListBean>() {
        override fun areItemsTheSame(oldItem: ArticleListBean, newItem: ArticleListBean): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ArticleListBean, newItem: ArticleListBean): Boolean {
            return oldItem.collect == newItem.collect && oldItem.date == newItem.date
        }

    }

}