package com.evada.lygshop.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.evada.lygshop.R;
import com.evada.lygshop.fragment.CategoryFragment;
import com.evada.lygshop.fragment.HomeFragment;
import com.evada.lygshop.util.ActivityCollector;

public class MainActivity extends BaseActivity {

    private HomeFragment mHome;
    private CategoryFragment mCategory;
    private RadioGroup mRadioGroup;
    private FragmentManager fManager;
    private long time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            mHome = (HomeFragment) getSupportFragmentManager().findFragmentByTag("home");
            mCategory = (CategoryFragment) getSupportFragmentManager().findFragmentByTag("category");
        }
        setContentView(R.layout.activity_main);
        mRadioGroup = (RadioGroup) findViewById(R.id.id_radiogroup);
        fManager = getSupportFragmentManager();
        initEvent();
        setSelection(0);
    }

    private void initEvent() {
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.id_rb_home:
                        setSelection(0);
                        break;
                    case R.id.id_rb_category:
                        setSelection(1);
                        break;
                }
            }
        });
    }

    private void setSelection(int i) {
        FragmentTransaction ft = fManager.beginTransaction();
        hideFragments(ft);
        switch (i) {
            case 0:
                if (null == mHome) {
                    mHome = new HomeFragment();
                    ft.add(R.id.id_content, mHome, "home");
                } else {
                    ft.show(mHome);
                }
                break;
            case 1:
                if (null == mCategory) {
                    mCategory = new CategoryFragment();
                    ft.add(R.id.id_content, mCategory, "category");
                } else {
                    ft.show(mCategory);
                }
                break;
        }
        ft.commit();
    }

    private void hideFragments(FragmentTransaction ft) {
        if (null != mHome) {
            ft.hide(mHome);
        }
        if (null != mCategory) {
            ft.hide(mCategory);
        }
    }

}
