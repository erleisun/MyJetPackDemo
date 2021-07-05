package com.qinggan.myjetpackdemo.ui.base;

import android.util.SparseArray;

import androidx.lifecycle.ViewModel;

public class DataBindingConfig {

    private int layoutID;
    private ViewModel viewMode;

    private SparseArray mSparseArray = new SparseArray();

    public DataBindingConfig(int layoutID, ViewModel stateViewModel) {
        this.layoutID = layoutID;
        this.viewMode = stateViewModel;
    }

    public DataBindingConfig(int layout) {
        this.layoutID = layout;
    }

    public int getLayout() {
        return layoutID;
    }

    public ViewModel getStateViewModel() {
        return viewMode;
    }

    public SparseArray getBindingParams() {
        return mSparseArray;
    }

    public DataBindingConfig addDataBindingParams(int variableId, Object object) {
        if (mSparseArray.get(variableId) == null) {
            mSparseArray.put(variableId, object);
        }
        return this;
    }

}


