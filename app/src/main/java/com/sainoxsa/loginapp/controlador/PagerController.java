package com.sainoxsa.loginapp.controlador;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class PagerController extends FragmentPagerAdapter {


    private final List<Fragment> fragmentList= new ArrayList<>();
    private final List<String> stringList = new ArrayList<>();

    public PagerController(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return stringList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return stringList.get(position);
    }

    public void AddFragment (Fragment fragment, String s){
        fragmentList.add(fragment);
        stringList.add(s);
    }
}

