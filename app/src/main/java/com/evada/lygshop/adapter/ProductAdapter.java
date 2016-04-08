package com.evada.lygshop.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.evada.lygshop.R;
import com.evada.lygshop.bean.ProductBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * author： bwl on 2015-01-06.
 * email: bxl049@163.com
 */
public class ProductAdapter extends RecyclerView.Adapter {

    private List<ProductBean> products;
    private Context mContext;

    public ProductAdapter(Context context, List<ProductBean> list) {
        mContext = context;
        products = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.product_recycleview_item, null);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        ProductViewHolder holder = (ProductViewHolder) viewHolder;
        holder.position = position;
        ProductBean bean = products.get(position);
        holder.name.setText(bean.name);
        holder.price.setText(bean.price + "");
        holder.originPrice.setText(bean.originPrice + "");
        Picasso.with(mContext).load(bean.imgLink).
                error(R.mipmap.hint_bg).into(holder.icon);

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView icon;
        private TextView name;
        private TextView price;
        private TextView originPrice;
        private int position;

        public ProductViewHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.id_imv_product_icon);
            name = (TextView) itemView.findViewById(R.id.id_tv_product_name);
            price = (TextView) itemView.findViewById(R.id.id_tv_product_price);
            originPrice = (TextView) itemView.findViewById(R.id.id_tv_product_origin_price);
            originPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (null != mListener) {
                mListener.onItemClick(position);
            }
        }
    }

    public static interface OnRecycleViewItemClickListener {
        void onItemClick(int position);
    }

    private OnRecycleViewItemClickListener mListener;

    public void setOnRecycleViewItemClicked(OnRecycleViewItemClickListener listener) {
        mListener = listener;
    }
}
