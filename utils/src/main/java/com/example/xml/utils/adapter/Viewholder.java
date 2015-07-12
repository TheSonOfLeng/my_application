package com.example.xml.utils.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by xml on 2015/7/12.
 */
public class Viewholder {
    private final SparseArray<View> mViews;
    private View mConvertView;
    private int mPosition;

    /*
    在构造方法中setTag(),相当于原始的在适配器中的setTag()
     */
    private Viewholder(Context context, ViewGroup parent, int layoutId, int position) {
        this.mViews = new SparseArray<View>();
        this.mPosition = position;
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);

        mConvertView.setTag(this);


    }

    /*
    拿到一个ViewHolder对象
     */
    public static Viewholder getViewHolder(Context context, View convertView, ViewGroup parent, int layoutId, int position) {
        if (convertView == null) {
            return new Viewholder(context, parent, layoutId, position);
        } else {
            Viewholder viewholder = (Viewholder) convertView.getTag();

            viewholder.mPosition = position;
            return viewholder;
        }
    }

    /**
     * 通过控件的viewId获取控件，如果没有则加入到mViews中去
     *
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public View getConvertView() {
        return mConvertView;
    }

    /**
     * 给TextView 控件设置显示的文字
     * @param viewId
     * @param text
     * @return
     */
    public Viewholder setText(int viewId,String text) {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }

    /**
     * 给ImageView控件设置显示的图片
     * @param viewId
     * @param drawableId
     * @return
     */
    public Viewholder setImageResource(int viewId, int drawableId)
    {
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);

        return this;
    }

    /**
     * 给ImageView控件设置图片
     * @param viewId
     * @param bm
     * @return
     */
    public Viewholder setImageBitmap(int viewId, Bitmap bm)
    {
        ImageView view = getView(viewId);
        view.setImageBitmap(bm);
        return this;
    }
    public int getPosition()
    {
        return mPosition;
    }
}
