package com.qinggan.myjetpackdemo.bean

import android.os.Parcel
import android.os.Parcelable

class BannerBean() : Parcelable {

    /** desc : 享学~
     * id : 29
     * imagePath : https://wanandroid.com/blogimgs/cd53b340-1d94-4810-b864-567574e85de7.jpeg
     * isVisible : 1
     * order : 0
     * title : 老板说要加点功能。。。
     * type : 0
     * url : https://mp.weixin.qq.com/s/Rv70Tpb4nVizSK0TrK6_FA
     */
    var desc: String? = null
    var id = 0
    var imagePath: String? = null
    var isVisible = 0
    var order = 0
    var title: String? = null
    var type = 0
    var url: String? = null

    constructor(parcel: Parcel) : this() {
        desc = parcel.readString()
        id = parcel.readInt()
        imagePath = parcel.readString()
        isVisible = parcel.readInt()
        order = parcel.readInt()
        title = parcel.readString()
        type = parcel.readInt()
        url = parcel.readString()
    }


    override fun toString(): String {
        return "BannerBean(desc=$desc, id=$id, imagePath=$imagePath, isVisible=$isVisible, order=$order, title=$title, type=$type, url=$url)"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(desc)
        parcel.writeInt(id)
        parcel.writeString(imagePath)
        parcel.writeInt(isVisible)
        parcel.writeInt(order)
        parcel.writeString(title)
        parcel.writeInt(type)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BannerBean> {
        override fun createFromParcel(parcel: Parcel): BannerBean {
            return BannerBean(parcel)
        }

        override fun newArray(size: Int): Array<BannerBean?> {
            return arrayOfNulls(size)
        }
    }


}