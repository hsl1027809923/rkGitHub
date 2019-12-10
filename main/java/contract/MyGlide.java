package contract;

import android.content.Context;
import android.widget.ImageView;

import com.bawei.haoshilong.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

/*
 *@auther:郝世龙
 *@Date: 2019-12-09
 *@Time:16:01
 *@Description:${DESCRIPTION}
 **/public  class MyGlide {
     public static void getGlide(Context context,String url,ImageView img_view){

          Glide.with(context).load(url).into(img_view);
     }

}
