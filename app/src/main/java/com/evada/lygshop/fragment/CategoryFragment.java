package com.evada.lygshop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.evada.lygshop.R;

import java.util.ArrayList;
import java.util.List;

/**
 * author： bwl on 2015-01-06.
 * email: bxl049@163.com
 */
public class CategoryFragment extends Fragment {

    private ViewPager mViewPager;
    private TabLayout mTablayout;
    private PagerAdapter mAdapter;
    private BoyCategoryFragment mBoy;
    private GirlCategoryFragment mGirl;
    private List<Fragment> fragments = new ArrayList<>();
    private String[] titles;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewPager = (ViewPager) getActivity().findViewById(R.id.id_viewpager);
        mTablayout = (TabLayout) getActivity().findViewById(R.id.id_tablayout);
        initData();
    }

    private void initData() {
        titles = new String[]{getResources().getString(R.string.beauty_boy),
                getResources().getString(R.string.beauty_girl)};
        mBoy = new BoyCategoryFragment();
        mGirl = new GirlCategoryFragment();
        fragments.add(mBoy);
        fragments.add(mGirl);
        mAdapter = new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        };
        mViewPager.setAdapter(mAdapter);
        mTablayout.setupWithViewPager(mViewPager);
    }
}
