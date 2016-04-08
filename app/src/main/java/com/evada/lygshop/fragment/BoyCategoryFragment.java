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
public class BoyCategoryFragment extends Fragment {
    private RecyclerView mRecycleView;
    private Context mContext;
    private CategoryAdapter mAdapter;
    private List<CategoryBean> categories;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_category_boy, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mContext = getActivity();
        mRecycleView = (RecyclerView) getActivity().findViewById(R.id.id_category_child_recycleview);
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
                ProductActivity.actionStart(mContext,products);
            }
        });
    }

    private void fetchData() {
        categories = new ArrayList<>();
        String[] names = new String[]{"服装", "鞋", "钟表", "包包"};
        String[] links = new String[]{"http://img2.okimgs.com//group1/M01/8D/F1/wKgKPVXmxNmAB8ZCAADt5oOhf6E123_75.jpg",
                "http://img2.okdocuments.com//group1/M00/11/77/wKgKPFVB1_CAAHhXAADuD4YZym8461.jpg",
                "http://img3.okimgs.com//group1/M01/87/FB/wKgKPVXkZnKAKztEAACXvJ4nw6k194_75.jpg",
                "http://img1.okimgs.com//group1/M00/81/04/wKgKPVXhVS2AYOBlAAF33gbeBB4218_75.jpg"
        };
        for (int i = 0; i < names.length; i++) {
            CategoryBean bean = new CategoryBean();
            bean.name = names[i];
            bean.link = links[i];
            bean.products = getBoyData(i);
            categories.add(bean);
        }
    }

    private ArrayList<ProductBean> getBoyData(int i) {
        ArrayList<ProductBean> products = new ArrayList<>();
        if (i == 0) {
            ProductUtil.getBoyClothes(products);
        } else if (i == 1) {
            ProductUtil.getBoyShoes(products);
        } else if (i == 2) {
            ProductUtil.getBoyWatchs(products);
        } else if (i == 3) {
            ProductUtil.getBoyBags(products);
        }
        return products;
    }


}
