package com.baseapp.hiepnn.mybaseproject.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baseapp.hiepnn.mybaseproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hiepn on 23/03/2017.
 */

public class ThirdFragment extends BaseFragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_third;
    }

    @Override
    protected void initView(View root, LayoutInflater inflater, ViewGroup container) {
        getEventBaseFragment().doFillBackground("ThirdFragment");
        viewPager = (ViewPager) root.findViewById(R.id.viewpager);
        tabLayout = (TabLayout) root.findViewById(R.id.tabs);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    getEventBaseFragment().doFillBackground("Option");
                } else if (position == 1) {
                    getEventBaseFragment().doFillBackground("Check");
                } else if (position == 2) {
                    getEventBaseFragment().doFillBackground("History");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void getArgument(Bundle bundle) {

    }

    @Override
    protected void initData() {
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    /**
     * Adding custom view to tab
     */
    private void setupTabIcons() {
        TextView tabOne = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.custom_tab, null);
        tabOne.setText("Tùy chọn");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_dm01, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.custom_tab, null);
        tabTwo.setText("Check");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_dm02, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.custom_tab, null);
        tabThree.setText("Lịch sử");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_dm03, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);
    }

    /**
     * Adding fragments to ViewPager
     *
     * @param viewPager
     */
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFrag(new ThirdChildOneFragment(), "Tùy chọn");
        adapter.addFrag(new ThirdChildTwoFragment(), "Check");
        adapter.addFrag(new ThirdChildOneFragment(), "Lịch sử");
        viewPager.setCurrentItem(0);
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
