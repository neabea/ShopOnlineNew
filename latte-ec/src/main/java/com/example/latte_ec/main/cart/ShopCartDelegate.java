package com.example.latte_ec.main.cart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.latte_core.delegates.bottom.BottomItemDelegate;
import com.example.latte_ec.R;

public class ShopCartDelegate extends BottomItemDelegate{
    @Override
    public Object setLayout() {
        return R.layout.delegate_shop_cart;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
