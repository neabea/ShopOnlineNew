package com.example.latte_core.ui.recycler;

import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;

public class MultipleViewHolder extends BaseViewHolder {
    public MultipleViewHolder(View view) {
        super(view);
    }

    //用简单工厂模式包装下
    public static MultipleViewHolder create(View view) {
        return new MultipleViewHolder(view);
    }
}
