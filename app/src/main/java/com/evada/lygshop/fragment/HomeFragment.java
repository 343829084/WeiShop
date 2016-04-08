package com.evada.lygshop.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.evada.lygshop.adapter.ProductAdapter;
import com.evada.lygshop.R;
import com.evada.lygshop.bean.ProductBean;
import com.evada.lygshop.util.DataManager;
import com.evada.lygshop.util.ProductUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * author： bwl on 2015-01-06.
 * email: bxl049@163.com
 */
public class HomeFragment extends Fragment {
    private RecyclerView mRecycleView;
    private Context mContext;
    private List<ProductBean> products = new ArrayList<>();
    private ProductAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mContext = getActivity();
        initView();
        ProductUtil.getNewProducts(products);
        mAdapter = new ProductAdapter(mContext, products);
        mRecycleView.setAdapter(mAdapter);
        initEvent();
    }

    private void initEvent() {
        mAdapter.setOnRecycleViewItemClicked(new ProductAdapter.OnRecycleViewItemClickListener() {
            @Override
            public void onItemClick(int position) {
                ProductBean bean = products.get(position);
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(bean.link));
                mContext.startActivity(intent);
            }
        });
    }


    private void initView() {
        mRecycleView = (RecyclerView) getView().findViewById(R.id.id_recycleview_home);
        mRecycleView.setHasFixedSize(true);
        RecyclerView.LayoutManager manager = new GridLayoutManager(mContext, 2);
        mRecycleView.setLayoutManager(manager);
    }
}
