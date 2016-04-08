package com.evada.lygshop.activity;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.evada.lygshop.R;
import com.evada.lygshop.adapter.ProductAdapter;
import com.evada.lygshop.bean.ProductBean;

import java.util.ArrayList;
import java.util.List;

/**
 * author： bwl on 2015-01-08.
 * email: bxl049@163.com
 */
public class ProductActivity extends BaseActivity {

    private RecyclerView mRecycleView;
    private List<ProductBean> products = new ArrayList<>();
    private ProductAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        initData();
        initEvent();
    }

    private void initData() {
        mRecycleView = (RecyclerView) findViewById(R.id.id_recycleview_product);
        RecyclerView.LayoutManager fManager = new GridLayoutManager(this, 2);
        mRecycleView.setLayoutManager(fManager);
        Intent intent = getIntent();
        if (null != intent) {
            Bundle bundle = intent.getExtras();
            if (null != bundle) {
                ArrayList<ProductBean> datas = bundle.getParcelableArrayList("products");
                products.addAll(datas);
            }
        }
        mAdapter = new ProductAdapter(this, products);
        mRecycleView.setAdapter(mAdapter);
    }

    private void initEvent() {
        mAdapter.setOnRecycleViewItemClicked(new ProductAdapter.OnRecycleViewItemClickListener() {
            @Override
            public void onItemClick(int position) {
                ProductBean bean = products.get(position);
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(bean.link));
                startActivity(intent);
            }
        });
    }


    public static void actionStart(Context context, ArrayList<ProductBean> products) {
        Intent intent = new Intent(context, ProductActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("products", products);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }
}
