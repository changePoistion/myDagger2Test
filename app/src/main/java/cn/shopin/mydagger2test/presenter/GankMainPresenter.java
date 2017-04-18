package cn.shopin.mydagger2test.presenter;

import java.util.List;

import javax.inject.Inject;

import cn.shopin.mydagger2test.base.BasePresenter;
import cn.shopin.mydagger2test.contract.GankMainContract;
import cn.shopin.mydagger2test.model.entity.GankHttpResponse;
import cn.shopin.mydagger2test.model.entity.GankItemBean;
import cn.shopin.mydagger2test.model.http.RetrofitHelper;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zcs on 2017/4/15.
 *
 * @desc
 */
public class GankMainPresenter extends BasePresenter<GankMainContract.View> implements GankMainContract.Presenter {
    private RetrofitHelper mRetrofitHelper;

    @Inject
    public GankMainPresenter(RetrofitHelper retrofitHelper) {
        this.mRetrofitHelper = retrofitHelper;
    }

    @Override
    public void getGirlDates() {
        addSubscription(mRetrofitHelper.getGirlDates(20, 1)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GankHttpResponse<List<GankItemBean>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(GankHttpResponse<List<GankItemBean>> gankItemBeen) {
                        if (null == gankItemBeen) {
                            getView().showErrorMsg("加载失败");
                        } else {
                            getView().getGirlDates(gankItemBeen.getResults());
                        }
                    }
                }));
    }

}
