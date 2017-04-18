package cn.shopin.mydagger2test.base;

import android.util.Log;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by zcs on 2017/4/15.
 *
 * @desc
 */
public class BasePresenter<T extends BaseView> {
    protected Reference<T> mReferenceView;
    protected CompositeSubscription mCompositeSubscription;

    private CompositeSubscription getCompositeSubscription() {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        return mCompositeSubscription;
    }

    protected void addSubscription(Subscription subscription) {
        getCompositeSubscription().add(subscription);
    }

    protected void unSubscribe() {
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            Log.d("TAG", "取消注册");
            mCompositeSubscription.unsubscribe();
        }
    }

    protected void attachView(T view) {
        this.mReferenceView = new WeakReference<T>(view);
    }

    protected T getView() {
        return mReferenceView.get();
    }

    protected void detachView() {
        this.mReferenceView = null;
        unSubscribe();
    }
}
