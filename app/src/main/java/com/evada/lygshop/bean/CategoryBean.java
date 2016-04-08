package com.evada.lygshop.bean;


import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * author： bwl on 2015-01-06.
 * email: bxl049@163.com
 */
public class CategoryBean implements Parcelable {

    public static final String KEY_NAME = "name";
    public static final String KEY_LINK = "link";
    public static final String KEY_PRODUCTS = "products";

    public String name;
    public String link;
    public ArrayList<ProductBean> products;
    public static final Creator<CategoryBean> CREATOR = new Creator<CategoryBean>() {
        @Override
        public CategoryBean createFromParcel(Parcel in) {

            CategoryBean bean = new CategoryBean();
            Bundle bundle = in.readBundle();
            bean.name = bundle.getString(KEY_NAME);
            bean.link = bundle.getString(KEY_LINK);
            bean.products = bundle.getParcelableArrayList(KEY_PRODUCTS);
            return bean;
        }

        @Override
        public CategoryBean[] newArray(int size) {
            return new CategoryBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_NAME, name);
        bundle.putString(KEY_LINK, link);
        bundle.putParcelableArrayList(KEY_PRODUCTS, products);
        dest.writeBundle(bundle);
    }
}
