package api;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;

/*
 *@auther:郝世龙
 *@Date: 2019-12-09
 *@Time:9:24
 *@Description:${DESCRIPTION}
 **/public interface MyApi {
    @GET
    Observable<ResponseBody> getInfo(@Url String url);
}
