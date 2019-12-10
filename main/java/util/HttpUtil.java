package util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import api.MyApi;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import url.MyUrl;

/*
 *@auther:郝世龙
 *@Date: 2019-12-09
 *@Time:9:12
 *@Description:${工具类}
 **/public class HttpUtil {
    private final MyApi myApi;

    //单例

    private HttpUtil() {
        //日志拦截器
        HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .readTimeout(5000, TimeUnit.MILLISECONDS)
                .writeTimeout(5000, TimeUnit.MILLISECONDS)
                .addInterceptor(interceptor)
                .build();
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(MyUrl.BEANURL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(MyApi.class);

    }
    private static class HttpHolder{
        private static final HttpUtil util=new HttpUtil();
    }

    public static HttpUtil getInstance() {
        return HttpHolder.util;
    }
    //网络
    public boolean getNet(Context context){
        ConnectivityManager manager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info!=null){
            return info.isConnected();
        }
        return false;
    }
    //Get请求
    public void doGet(String url, final Class cls, final HCallBack callBack){
        myApi.getInfo(url).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        //解析
                        try {
                            Object o = new Gson().fromJson(responseBody.string(), cls);
                            if (callBack !=null){
                                Log.e("ooo",o.toString());
                                callBack.onSuccess(o);

                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callBack !=null){
                            callBack.onError(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public interface HCallBack<T>{
        void onSuccess(T t);
        void onError(String er);
    }

}
