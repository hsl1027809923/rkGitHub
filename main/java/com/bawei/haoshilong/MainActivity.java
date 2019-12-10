package com.bawei.haoshilong;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.List;

import adapter.MyAdapter;
import base.BaseActivity;
import base.BasePresenter;
import bean.Beanl;
import butterknife.BindView;
import butterknife.ButterKnife;
import presenter.MyPressenter;
import url.MyUrl;

/*
 *@auther:郝世龙
 *@Date: 2019-12-09
 *@Time:9:03
 *@Description:${主页面}
 **/
public class MainActivity extends BaseActivity {

    List<Beanl.OrderDataBean> list=new ArrayList<>();
    private MyPressenter myPressenter;
    private MyAdapter adapter;
    ExpandableListView recyclerView;

    @Override
    protected int initLayout() {
        return R.layout.activity_main;

    }

    @Override
    protected void initData() {
        adapter = new MyAdapter(list,this);
        recyclerView.setAdapter(adapter);
        myPressenter.getInfo(MyUrl.URL, Beanl.class);

        //设置是否选中
        adapter.setMyAdapter(new MyAdapter.ShopCallBack() {
            @Override
            public void bigCheck(int Fuid) {
                //商品全选  商家也选中
                boolean b = adapter.setFucheck(Fuid);
            }

            @Override
            public void smallCheCk(int Fuid, int small) {

            }
        });

    }

    @Override
    protected void initView() {
        recyclerView=findViewById(R.id.recycler_View);
    }

    @Override
    protected BasePresenter initPresenter() {
        myPressenter = new MyPressenter();
        return myPressenter;
    }


    @Override
    public void onSuccess(Object o) {
        if (o instanceof Beanl){

            list.addAll(((Beanl) o).getOrderData());

            Log.e("hsl666", o.toString());
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onError(String er) {

    }


}
