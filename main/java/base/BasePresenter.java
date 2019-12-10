package base;

import contract.Icontract;

/*
 *@auther:郝世龙
 *@Date: 2019-12-09
 *@Time:9:33
 *@Description:${DESCRIPTION}
 **/public abstract class BasePresenter<V extends BaseActivity>  implements Icontract.IPresent {
    public V v;
    //绑定
    public void attch(V v){
        this.v=v;
    }
    //解绑
    public void Uattach(){
        if (v!=null){
            v=null;
        }
    }

}
