package base;

import android.app.Application;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import contract.Icontract;

/*
 *@auther:郝世龙
 *@Date: 2019-12-09
 *@Time:9:32
 *@Description:${activity基类}
 **/public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements Icontract.IView {
    public P p;
    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (initLayout()!=0){
            setContentView(initLayout());
            //!!!!!!!!!!!!!!!!!!!
            p=initPresenter();
            //!!!!!!!!!!!!!!!!!!!!
            if (p!=null){
                p.attch(this);
            }

            initView();;
            initData();
            bind = ButterKnife.bind(this);
        }
    }

    protected abstract int initLayout();


    protected abstract void initData();

    protected abstract void initView();

    protected abstract P initPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
            if (bind!=null){
                bind.unbind();
            }

            if (p!=null){
                p=null;
                p.Uattach();
            }
    }
}
