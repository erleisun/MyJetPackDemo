package com.qinggan.myjetpackdemo.bean

import android.text.Html
import android.text.TextUtils
import com.chad.library.adapter.base.entity.MultiItemEntity
import com.qinggan.myjetpackdemo.constants.DescConstants

data class ArticleListBean(
    var id: Int = 0,

    /**
     * 作者
     */
    var author: String? = null,

    /**
     * 是否收藏
     */
    var collect: Boolean = false,

    /**
     * 描述信息
     */
    var desc: String? = null,

    /**
     * 图片类型，有和无
     */
    var picUrl: String? = null,

    /**
     * 链接
     */
    var link: String? = null,

    /**
     * 日期
     */
    var date: String? = null,

    /**
     * 标题
     */
    var title: String? = null,

    /**
     * 文章标签
     */
    var articleTag: String? = null,

    /**
     * 1.置顶
     */
    var topTitle: String? = null,

    ) : MultiItemEntity {


    override fun getItemType(): Int {
        //article list have two type
        return if (picUrl.isNullOrEmpty()) {
            DescConstants.ITEM_ARTICLE
        } else {
            DescConstants.ITEM_ARTICLE_PIC
        }
    }

    companion object {
        /**
         * 将article中data 转换为 articleListBean
         */
        fun trans(list: MutableList<ArticleBean.DataBean>): MutableList<ArticleListBean> {
            return list.map {

                ArticleListBean().apply {
                    this.id = it.id
                    author = if (TextUtils.isEmpty(it.author)) {
                        it.shareUser
                    } else {
                        it.author
                    }
                    collect = it.collect
                    desc = it.desc
                    picUrl = it.envelopePic
                    link = it.link
                    date = it.niceDate
                    title = Html.fromHtml(it.title).toString()
                    articleTag = it.superChapterName
                    topTitle = if (it.type == 1) "置顶" else ""
                }
            }.toMutableList()
        }

    }

}
