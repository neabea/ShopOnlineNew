package com.example.latte_ec.launcher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.example.latte_core.delegates.LatteDelegate;
import com.example.latte_core.ui.launcher.LauncherHolderCreator;
import com.example.latte_core.ui.launcher.ScrollLauncherTag;
import com.example.latte_core.util.storage.LattePreference;
import com.example.latte_ec.R;

import java.util.ArrayList;

//使用conenient banner
public class LauncherScrollDelegate extends LatteDelegate implements OnItemClickListener{

   private ConvenientBanner <Integer> mConvenientBanner = null;
   private static final ArrayList<Integer> INTEGERS = new ArrayList<>();

   private void initBanner(){
       INTEGERS.add(R.mipmap.launcher_01);
       INTEGERS.add(R.mipmap.launcher_02);
       INTEGERS.add(R.mipmap.launcher_03);
       INTEGERS.add(R.mipmap.launcher_04);
       INTEGERS.add(R.mipmap.launcher_05);

       mConvenientBanner.setPages(new LauncherHolderCreator(),INTEGERS)
               .setPageIndicator(new int[]{R.drawable.dot_normal,R.drawable.dot_focus})//相当于滑动页底下的球
               .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
               .setOnItemClickListener(this)
               .setCanLoop(false);

   }

    @Override
    public Object setLayout() {
       mConvenientBanner = new ConvenientBanner<>(getContext());
        return mConvenientBanner;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initBanner();
    }

    @Override
    public void onItemClick(int position) {
       //点击最后一个
        if(position == INTEGERS.size()-1){
            LattePreference.setAppFlag(ScrollLauncherTag.HAS_FIRST_LAUNCHER_APP.name(),true);
            //检查用户是否已经登录
        }
    }
}
