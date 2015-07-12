package com.example.xml.utils.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by xml on 2015/7/12.
 */
public abstract class  CommonAdapter<T> extends BaseAdapter{
    protected LayoutInflater mLayoutInflater;
    protected Context mContext;
    protected List<T>   mList;
    protected int mItemLayoutId;
    public CommonAdapter(Context mContext, List<T> mList,int itemLayoutId) {
        this.mContext = mContext;
        this.mList = mList;
        this.mLayoutInflater = LayoutInflater.from(mContext);
        this.mItemLayoutId = itemLayoutId;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Viewholder viewholder=Viewholder.getViewHolder(mContext, convertView, parent, mItemLayoutId, position);
        convert(viewholder, (T) getItem(position));

        return viewholder.getConvertView() ;
    }

    /**
     * 在这里处理设置extView中的内容，ImageView中的图片等等逻辑
     * @param viewholder
     * @param item
     */
    public abstract void convert(Viewholder viewholder, T item);
}
