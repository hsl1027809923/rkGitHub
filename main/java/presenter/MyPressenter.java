package presenter;

import android.util.Log;

import com.bawei.haoshilong.MainActivity;

import base.BasePresenter;
import contract.Icontract;
import model.MyModel;

/*
 *@auther:郝世龙
 *@Date: 2019-12-09
 *@Time:9:52
 *@Description:${DESCRIPTION}
 **/public class MyPressenter extends BasePresenter  {
    MyModel model;

    @Override
    public void getInfo(String url, Class cls) {
        model=new MyModel();
        model.doGet(url, cls, new Icontract.MCallBack() {
            @Override
            public void onSuccess(Object o) {
                Log.e("myPresenterooo",o.toString());
//                MainActivity activity= (MainActivity) v;
//                activity.onSuccess(o);
                v.onSuccess(o);

            }

            @Override
            public void onError(String er) {
                v.onError(er);
            }
        });
    }
}
