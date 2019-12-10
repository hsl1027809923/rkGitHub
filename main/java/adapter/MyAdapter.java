package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.haoshilong.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import bean.Beanl;
import butterknife.BindView;
import contract.MyGlide;

/*
 *@auther:郝世龙
 *@Date: 2019-12-09
 *@Time:9:03
 *@Description:${适配器}
 **/public class MyAdapter extends BaseExpandableListAdapter {

    List<Beanl.OrderDataBean> list;
    Context context;

    public MyAdapter(List<Beanl.OrderDataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }



    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return list.get(groupPosition).getCartlist().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        Fu fu=null;
        if (convertView==null){
            fu=new Fu();
            convertView=View.inflate(context,R.layout.item_layout,null);
            fu.textView=convertView.findViewById(R.id.fu_text);
            fu.fcheckBox=convertView.findViewById(R.id.fu_check);
            convertView.setTag(fu);
        }else {
            fu= (Fu) convertView.getTag();
        }
//        MyGlide.getGlide(context,list.get(groupPosition).getCartlist().get(groupPosition).getDefaultPic(),fu.fimageView);
//        fu.fcheckBox.setChecked();

        fu.textView.setText(list.get(groupPosition).getShopName()+"");
        fu.fcheckBox.setChecked(setFucheck(groupPosition));
//        fu.fcheckBox.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (callBack!=null){
//                    callBack.bigCheck(groupPosition);
//                }
//            }
//        });
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        Er er=null;
        if (convertView==null){
            er=new Er();
            convertView=View.inflate(context,R.layout.zi_layout,null);
            er.zcheckBox=convertView.findViewById(R.id.zcheck_box);
            er.zimageView=convertView.findViewById(R.id.zitem_img);
            er.zbutton=convertView.findViewById(R.id.zi_button);
            convertView.setTag(er);
        }else {
            er= (Er) convertView.getTag();
        }
        MyGlide.getGlide(context,list.get(groupPosition).getCartlist().get(childPosition).getDefaultPic(),er.zimageView);
        //点击添加
        er.zbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
    //店铺
    class Fu{
        private CheckBox fcheckBox;
        private TextView textView;

    }
    //商品
    class Er{
        private CheckBox zcheckBox;
        private ImageView zimageView;
        private Button zbutton;
    }

    //接口
    public interface ShopCallBack{
        //返回父id
        void bigCheck(int Fuid);

        void smallCheCk(int Fuid,int small);


    }
    private ShopCallBack callBack;

    public void setMyAdapter(ShopCallBack callBack) {
        this.callBack = callBack;
    }



    //商品全选  商家也选中
    public boolean setFucheck(int Fuid){
        boolean flag=true;
        Beanl.OrderDataBean orderDataBean = list.get(Fuid);
        for (int i = 0; i < orderDataBean.getCartlist().size(); i++) {
            if (!orderDataBean.getCartlist().get(i).isStatu()){
                flag=false;
                return flag;
            }
        }
        return flag;
    }
    //当我点击商家的复选框的时候
    public void setBigCheckStatus(int bigIndex, boolean isStatus) {
        List<Beanl.OrderDataBean.CartlistBean> cartList = list.get(bigIndex).getCartlist();
        for (Beanl.OrderDataBean.CartlistBean cartlistBean: cartList){
            cartlistBean.setStatu(isStatus);
        }
    }
    //当点击商品选中
    //当我点击商品让他选中
    public void setSmallCheck(int bigIndex, int smallIndex, boolean isCheck) {
        list.get(bigIndex).getCartlist().get(smallIndex).setStatu(isCheck);
    }



}
