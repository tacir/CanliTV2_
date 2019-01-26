package com.example.tacir.canlitv;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.tacir.canlitv.fragments.CategoryFragment;
import com.example.tacir.canlitv.fragments.ChannelFragment;
import com.example.tacir.canlitv.fragments.FavoriteFragment;


public class ChannelTabAdapter extends FragmentPagerAdapter {
    public ChannelTabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
switch (position){
    case 0:
        return new ChannelFragment();
    case 1:
        return new CategoryFragment();
    case 2:
        return new FavoriteFragment();

}
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
