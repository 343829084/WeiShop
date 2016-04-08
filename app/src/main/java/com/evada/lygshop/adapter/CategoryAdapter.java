package com.evada.lygshop.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.evada.lygshop.R;
import com.evada.lygshop.bean.CategoryBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * author： bwl on 2015-01-06.
 * email: bxl049@163.com
 */
public class CategoryAdapter extends RecyclerView.Adapter {

    private List<CategoryBean> categories;
    private Context mContext;

    public CategoryAdapter(Context context, List<CategoryBean> list) {
        mContext = context;
        categories = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.category_recycleview_item, null);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        CategoryViewHolder holder = (CategoryViewHolder) viewHolder;
        holder.position = position;
        CategoryBean bean = categories.get(position);
        holder.name.setText(bean.name);
        Picasso.with(mContext).load(bean.link).placeholder(R.mipmap.hint_bg).error(R.mipmap.hint_bg)
                .into(holder.icon);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView icon;
        private TextView name;
        private int position;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.id_imv_category_icon);
            name = (TextView) itemView.findViewById(R.id.id_tv_category_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (null != mListener) {
                mListener.onItemClicked(position);
            }
        }
    }


    public static interface OnRecycleViewItemClickListener {
        void onItemClicked(int position);
    }

    private OnRecycleViewItemClickListener mListener;

    public void setOnRecycleViewItemClickListener(OnRecycleViewItemClickListener listener) {
        mListener = listener;
    }

}
