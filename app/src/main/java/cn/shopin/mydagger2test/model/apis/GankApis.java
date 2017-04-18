package cn.shopin.mydagger2test.model.apis;

import java.util.List;

import cn.shopin.mydagger2test.model.entity.GankHttpResponse;
import cn.shopin.mydagger2test.model.entity.GankItemBean;
import dagger.Module;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by zcs on 2017/4/16.
 *
 * @desc
 */
@Module
public interface GankApis {
    String HOST = "http://gank.io/api/";

    /**
     * 妹纸列表
     */
    @GET("data/福利/{num}/{page}")
    Observable<GankHttpResponse<List<GankItemBean>>> getGirlList(@Path("num") int num, @Path("page") int page);
}
