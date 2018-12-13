package com.statusstock.viewpagerdemo;

import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }


        viewPager = findViewById(R.id.viewPager);

        fragmentManager = getSupportFragmentManager();
        ViewPagerAdapter adapter = new ViewPagerAdapter(fragmentManager);

        adapter.AddFragment(new Tab1(), "Cricket");
        adapter.AddFragment(new Tab2(), "Football");
        adapter.AddFragment(new Tab3(), "Kabaddi");
        adapter.AddFragment(new Tab4(), "NBA");

        viewPager.setClipToPadding(false);
        viewPager.setPadding(50, 160, 50, 0);
        viewPager.setPageMargin(10);


        viewPager.setAdapter(adapter);
//        tabLayout.setupWithViewPager(viewPager);

    }
}
