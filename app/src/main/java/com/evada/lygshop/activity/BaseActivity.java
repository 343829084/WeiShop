package com.evada.lygshop.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.evada.lygshop.util.ActivityCollector;

/**
 * author： bwl on 2015-01-06.
 * email: bxl049@163.com
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
