package com.evada.lygshop.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * author： bwl on 2015-01-06.
 * email: bxl049@163.com
 */
public class ProductBean implements Parcelable {
    public static final String KEY_NAME = "name";

    public static final String KEY_LINK = "link";
    public static final String KEY_IMGLINK = "imglink";
    public static final String KEY_PRICE = "price";
    public static final String KEY_ORIGINPRICE = "oirginprice";
    public String name;
    public String link;
    public String imgLink;
    public Float price;
    public Float originPrice;


    public static final Creator<ProductBean> CREATOR = new Creator<ProductBean>() {
        @Override
        public ProductBean createFromParcel(Parcel in) {
            ProductBean bean = new ProductBean();
            Bundle bundle = in.readBundle();
            bean.name = bundle.getString(KEY_NAME);
            bean.link = bundle.getString(KEY_LINK);
            bean.imgLink = bundle.getString(KEY_IMGLINK);
            bean.price = bundle.getFloat(KEY_PRICE);
            bean.originPrice = bundle.getFloat(KEY_ORIGINPRICE);
            return bean;
        }

        @Override
        public ProductBean[] newArray(int size) {
            return new ProductBean[size];
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
        bundle.putString(KEY_IMGLINK, imgLink);
        bundle.putFloat(KEY_PRICE, price);
        bundle.putFloat(KEY_ORIGINPRICE, originPrice);
        dest.writeBundle(bundle);
    }
}
