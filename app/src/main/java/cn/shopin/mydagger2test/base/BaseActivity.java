package cn.shopin.mydagger2test.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import cn.shopin.mydagger2test.app.MyApp;
import cn.shopin.mydagger2test.di.component.ActivityComponent;
import cn.shopin.mydagger2test.di.component.DaggerActivityComponent;
import cn.shopin.mydagger2test.di.module.ActivityModule;

/**
 * Created by zcs on 2017/4/15.
 *
 * @desc
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView {
    @Inject
    protected P mPresenter;
    protected Activity mContext;
//    private Bind mUnBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
//        mUnBinder = ButterKnife.bind(this);
        ButterKnife.bind(this);
        initInject();
        if (mPresenter != null)
            mPresenter.attachView(this);
        MyApp.getInstance().addActivity(this);
        initEventAndData();
    }

    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent
                .builder()
                .appComponent(MyApp.getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.detachView();
        MyApp.getInstance().removeActivity(this);
    }

    protected abstract void initInject();

    protected abstract int getLayout();

    protected abstract void initEventAndData();
}