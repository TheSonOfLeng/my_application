package com.example.xml.utils;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.example.xml.utils.adapter.CommonAdapter;
import com.example.xml.utils.adapter.Viewholder;
import com.joanzapata.android.QuickAdapter;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    private ListView mListView;
    private QuickAdapter mQuickAdapter;
    private CommonAdapter mCommonAdapter;
    private List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mListView =(ListView) findViewById(R.id.lv_mainactivity);
        list = new ArrayList();
        list.add("123");
        list.add("2233");
        list.add("2233");
        list.add("2233");
        list.add("2233");
        list.add("2233");

        Log.i("MainActivity", "运行到了这里");
//        mQuickAdapter = new QuickAdapter(this, R.layout.item_mainactivity_listview,list) {
//            @Override
//            protected void convert(BaseAdapterHelper helper, Object item) {
//                TextView textView = helper.getView(R.id.tv_mainactivity_item);
//                textView.setText((String) item);
//
//            }
//        };
        /*
        自定义的适配器
         */
        mCommonAdapter=new CommonAdapter(this,list,R.layout.item_mainactivity_listview) {
            @Override
            public void convert(Viewholder viewholder, Object item) {
                TextView textView=viewholder.getView(R.id.tv_mainactivity_item);
                textView.setText((String)item);
            }
        };
        mListView.setAdapter(mCommonAdapter);

    }


}
