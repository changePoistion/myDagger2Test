package cn.shopin.mydagger2test.model.http;

import java.util.List;

import cn.shopin.mydagger2test.model.apis.GankApis;
import cn.shopin.mydagger2test.model.entity.GankHttpResponse;
import cn.shopin.mydagger2test.model.entity.GankItemBean;
import rx.Observable;

/**
 * Created by zcs on 2017/4/16.
 *
 * @desc
 */
public class RetrofitHelper {
    private GankApis mGankApis;

    public RetrofitHelper(GankApis gankApis) {
        mGankApis = gankApis;
    }

    public Observable<GankHttpResponse<List<GankItemBean>>> getGirlDates(int num, int page) {
        return mGankApis.getGirlList(num, page);
    }
}
