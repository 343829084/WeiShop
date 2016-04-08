package com.evada.lygshop.util;

import com.evada.lygshop.bean.ProductBean;

import java.util.ArrayList;
import java.util.List;

/**
 * author： bwl on 2015-01-08.
 * email: bxl049@163.com
 */
public class ProductUtil {

    /**
     * 获取所有新品集合
     *
     * @param products
     */
    public static void getNewProducts(List<ProductBean> products) {
        if (null == products) {
            products = new ArrayList<>();
        }
        for (int i = 0; i < DataManager.NEW_PRODUCT_NAME.length; i++) {
            ProductBean bean = new ProductBean();
            bean.name = DataManager.NEW_PRODUCT_NAME[i];
            bean.link = DataManager.NEW_PRODUCT_URL[i];
            bean.imgLink = DataManager.NEW_PRODUCT_IMG_URL[i];
            bean.price = DataManager.NEW_PRODUCT_PRICES[i];
            bean.originPrice = DataManager.NEW_PRODUCT_ORIGIN_PRICES[i];
            products.add(bean);
        }
    }

    /**
     * 获取所有男装
     *
     * @param products
     */
    public static void getBoyClothes(ArrayList<ProductBean> products) {
        if (null == products) {
            products = new ArrayList<>();
        }
        for (int i = 0; i < DataManager.BOY_CLOTH_URL.length; i++) {
            ProductBean bean = new ProductBean();
            bean.name = DataManager.BOY_CLOTH_NAMES[i];
            bean.link = DataManager.BOY_CLOTH_URL[i];
            bean.imgLink = DataManager.BOY_CLOTH_IMG_URL[i];
            bean.price = DataManager.BOY_CLOTH_PRICES[i];
            bean.originPrice = DataManager.BOY_CLOTH_ORIGIN_PRICES[i];
            products.add(bean);
        }
    }

    /**
     * 获取所有男鞋
     *
     * @param products
     */
    public static void getBoyShoes(ArrayList<ProductBean> products) {
        if (null == products) {
            products = new ArrayList<>();
        }
        for (int i = 0; i < DataManager.BOY_SHOES_URL.length; i++) {
            ProductBean bean = new ProductBean();
            bean.name = DataManager.BOY_SHOES_NAMES[i];
            bean.link = DataManager.BOY_SHOES_URL[i];
            bean.imgLink = DataManager.BOY_SHOES_IMG_URL[i];
            bean.price = DataManager.BOY_SHOES_PRICES[i];
            bean.originPrice = DataManager.BOY_SHOES_ORGIN_PRICES[i];
            products.add(bean);
        }
    }

    /**
     * 获取所有男钟表
     *
     * @param products
     */
    public static void getBoyWatchs(ArrayList<ProductBean> products) {
        if (null == products) {
            products = new ArrayList<>();
        }
        for (int i = 0; i < DataManager.BOY_WATCH_URL.length; i++) {
            ProductBean bean = new ProductBean();
            bean.name = DataManager.BOY_WATCH_NAMES[i];
            bean.link = DataManager.BOY_WATCH_URL[i];
            bean.imgLink = DataManager.BOY_WATCH_IMG_URL[i];
            bean.price = DataManager.BOY_WATCH_PRICES[i];
            bean.originPrice = DataManager.BOY_WATCH_ORIGIN_PRICES[i];
            products.add(bean);
        }
    }

    /**
     * 获取所有男包
     *
     * @param products
     */
    public static void getBoyBags(ArrayList<ProductBean> products) {
        if (null == products) {
            products = new ArrayList<>();
        }
        for (int i = 0; i < DataManager.BOY_BAG_URL.length; i++) {
            ProductBean bean = new ProductBean();
            bean.name = DataManager.BOY_BAG_NAMES[i];
            bean.link = DataManager.BOY_BAG_URL[i];
            bean.imgLink = DataManager.BOY_BAG_IMG_URL[i];
            bean.price = DataManager.BOY_BAG_PRICES[i];
            bean.originPrice = DataManager.BOY_BAG_ORIGIN_PRICES[i];
            products.add(bean);
        }
    }

    /**
     * 获取所有女装
     *
     * @param products
     */
    public static void getGirlClothes(ArrayList<ProductBean> products) {
        if (null == products) {
            products = new ArrayList<>();
        }
        for (int i = 0; i < DataManager.GIRL_CLOTH_URL.length; i++) {
            ProductBean bean = new ProductBean();
            bean.name = DataManager.GIRL_CLOTH_NAMES[i];
            bean.link = DataManager.GIRL_CLOTH_URL[i];
            bean.imgLink = DataManager.GIRL_CLOTH_IMG_URL[i];
            bean.price = DataManager.GIRL_CLOTH_PRICES[i];
            bean.originPrice = DataManager.GIRL_CLOTH_ORIGIN_PRICES[i];
            products.add(bean);
        }
    }

    /**
     * 获取所有女鞋
     *
     * @param products
     */
    public static void getGirlShoes(ArrayList<ProductBean> products) {
        if (null == products) {
            products = new ArrayList<>();
        }
        for (int i = 0; i < DataManager.GIRL_SHOES_URL.length; i++) {
            ProductBean bean = new ProductBean();
            bean.name = DataManager.GIRL_SHOES_NAMES[i];
            bean.link = DataManager.GIRL_SHOES_URL[i];
            bean.imgLink = DataManager.GIRL_SHOES_IMG_URL[i];
            bean.price = DataManager.GIRL_SHOES_PRICES[i];
            bean.originPrice = DataManager.GIRL_SHOES_ORIGIN_PRICES[i];
            products.add(bean);
        }
    }

    /**
     *  获取所有女包
     * @param products
     */
    public static void getGirlBags(ArrayList<ProductBean> products) {
        if (null == products) {
            products = new ArrayList<>();
        }
        for (int i = 0; i < DataManager.GIRL_BAG_URL.length; i++) {
            ProductBean bean = new ProductBean();
            bean.name = DataManager.GIRL_BAG_NAMES[i];
            bean.link = DataManager.GIRL_BAG_URL[i];
            bean.imgLink = DataManager.GIRL_BAG_IMG_URL[i];
            bean.price = DataManager.GIRL_BAG_PRICES[i];
            bean.originPrice = DataManager.GIRL_BAG_ORIGIN_PRICES[i];
            products.add(bean);
        }
    }
}
