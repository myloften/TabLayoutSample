package com.loften.tablayoutsample;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.loften.tablayoutsample.fragment.FiveFragment;
import com.loften.tablayoutsample.fragment.FourFragment;
import com.loften.tablayoutsample.fragment.OneFragment;
import com.loften.tablayoutsample.fragment.ThreeFragment;
import com.loften.tablayoutsample.fragment.TwoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //给左上角图标的左边加上一个返回的图标
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);//将TabLayout和ViewPager关联起来

        setupTabIcons();
    }

    private void setupTabIcons(){
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
        tabLayout.getTabAt(4).setIcon(tabIcons[0]);

//        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab,null);
//        tabOne.setText("ONE");
//        tabOne.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.img1,0 ,0);
//        tabLayout.getTabAt(0).setCustomView(tabOne);
//        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab,null);
//        tabTwo.setText("Two");
//        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.img2,0 ,0);
//        tabLayout.getTabAt(1).setCustomView(tabTwo);
//        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab,null);
//        tabThree.setText("Three");
//        tabThree.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.img3,0 ,0);
//        tabLayout.getTabAt(2).setCustomView(tabThree);

    }

    private void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OneFragment(),"one");
        adapter.addFragment(new TwoFragment(),"two");
        adapter.addFragment(new ThreeFragment(),"three");
        adapter.addFragment(new FourFragment(),"four");
        adapter.addFragment(new FiveFragment(),"five");
//        adapter.addFragment(new OneFragment(),"six");
//        adapter.addFragment(new TwoFragment(),"seven");
//        adapter.addFragment(new ThreeFragment(),"eight");
//        adapter.addFragment(new FourFragment(),"nine");
//        adapter.addFragment(new FiveFragment(),"ten");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title){
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
