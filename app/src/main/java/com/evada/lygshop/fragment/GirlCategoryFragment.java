package com.evada.lygshop.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.evada.lygshop.R;
import com.evada.lygshop.activity.ProductActivity;
import com.evada.lygshop.adapter.CategoryAdapter;
import com.evada.lygshop.bean.CategoryBean;
import com.evada.lygshop.bean.ProductBean;
import com.evada.lygshop.util.ProductUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * author： bwl on 2015-01-08.
 * email: bxl049@163.com
 */
public class GirlCategoryFragment extends Fragment {

    private RecyclerView mRecycleView;
    private Context mContext;
    private CategoryAdapter mAdapter;
    private List<CategoryBean> categories;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_category_girl, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mContext = getActivity();
        mRecycleView = (RecyclerView) getActivity().findViewById(R.id.id_category_girl_recycleview);
        RecyclerView.LayoutManager fManager = new GridLayoutManager(mContext, 2);
        mRecycleView.setLayoutManager(fManager);
        fetchData();
        mAdapter = new CategoryAdapter(mContext, categories);
        mRecycleView.setAdapter(mAdapter);
        initEvent();
    }

    private void initEvent() {
        mAdapter.setOnRecycleViewItemClickListener(new CategoryAdapter.OnRecycleViewItemClickListener() {
            @Override
            public void onItemClicked(int position) {
                CategoryBean bean = categories.get(position);
                ArrayList<ProductBean> products = bean.products;
                ProductActivity.actionStart(mContext, products);
            }
        });
    }

    private void fetchData() {
        categories = new ArrayList<>();
        String[] names = new String[]{"服装", "鞋", "包包"};
        String[] links = new String[]{"http://img2.okimgs.com//group1/M00/BF/8C/wKgKPlYf63aAc2jNAAIMF8QNn4k629_75.jpg",
                "http://img2.okdocuments.com//group1/M01/5B/AB/wKgKPVXEYDCAeD_3AACGt8G32Kg281_75.jpg",
                "http://img1.okimgs.com//group1/M00/EA/3E/wKgKPFZVnOqABcFSAAKj7sfVpXs774_75.jpg"};
        for (int j = 0; j < names.length; j++) {
            CategoryBean bean = new CategoryBean();
            bean.name = names[j];
            bean.link = links[j];
            bean.products = getGirlData(j);
            categories.add(bean);
        }
    }

    private ArrayList<ProductBean> getGirlData(int j) {
        ArrayList<ProductBean> products = new ArrayList<>();
        if (j == 0) {
            ProductUtil.getGirlClothes(products);
        } else if (j == 1) {
            ProductUtil.getGirlShoes(products);
        } else if (j == 2) {
            ProductUtil.getGirlBags(products);
        }
        return products;
    }
}
