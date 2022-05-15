package com.qinggan.myjetpackdemo.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.qinggan.myjetpackdemo.R
import com.qinggan.myjetpackdemo.bean.ArticleListBean
import com.qinggan.myjetpackdemo.commom.getArticleDiff
import com.qinggan.myjetpackdemo.constants.DescConstants
import com.qinggan.myjetpackdemo.databinding.ItemHomeArticleBinding
import com.qinggan.myjetpackdemo.databinding.ItemProjectBinding
import com.qinggan.myjetpackdemo.ui.home.HomeFragment
import com.qinggan.myjetpackdemo.utils.KLog

class ArticleAdapter(private val context: Context) :
    ListAdapter<ArticleListBean, RecyclerView.ViewHolder>(getArticleDiff()) {

    //创建ViewHolder 并且与dataBinding绑定
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return if (viewType == DescConstants.ITEM_ARTICLE) {
            val binding: ItemProjectBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.item_project,
                parent,
                false)
            ArticlePicViewHolder(binding.root)

        } else {
            val binding: ItemHomeArticleBinding =
                DataBindingUtil.inflate(LayoutInflater.from(context),
                    R.layout.item_home_article, parent, false)
            ArticleViewHolder(binding.root)
        }

    }

    //数据和UI进行绑定
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = if (holder is ArticleViewHolder) {
            DataBindingUtil.getBinding<ItemHomeArticleBinding>(holder.itemView)?.apply {
                dataBean = getItem(position)
                KLog.d("home dataBean = $dataBean")
            }
        } else {
            DataBindingUtil.getBinding<ItemProjectBinding>(holder.itemView)?.apply {
                dataBean = getItem(position)
                KLog.d("pic dataBean = $dataBean")
            }
        }

        binding?.executePendingBindings()
    }

    private class ArticleViewHolder constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
    }

    private class ArticlePicViewHolder constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
    }

    override fun getItemViewType(position: Int): Int {
        return if (currentList[position].itemType == DescConstants.ITEM_ARTICLE) {
            DescConstants.ITEM_ARTICLE
        } else {
            DescConstants.ITEM_ARTICLE_PIC
        }
    }

    override fun submitList(list: List<ArticleListBean>?) {
        KLog.d("submitList = $list")
        val dataList = if (list == null) {
            mutableListOf()
        } else {
            mutableListOf<ArticleListBean>().apply {
                addAll(list)
            }
        }
        super.submitList(dataList)
    }
}