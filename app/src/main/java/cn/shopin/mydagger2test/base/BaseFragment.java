package cn.shopin.mydagger2test.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.ButterKnife;
//import butterknife.Unbinder;
import cn.shopin.mydagger2test.app.MyApp;
import cn.shopin.mydagger2test.di.component.DaggerFragmentComponent;
import cn.shopin.mydagger2test.di.component.FragmentComponent;
import cn.shopin.mydagger2test.di.module.FragmentModule;

/**
 * Created by zcs on 2017/4/15.
 *
 * @desc
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView {
    @Inject
    protected P mPresenter;
    protected View mView;
//    private Unbinder mUnBinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(getLayoutId(), null);
        initInject();
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
//        mUnBinder = ButterKnife.bind(this, view);
        ButterKnife.bind(this, view);
        initEventAndData();
    }

    public FragmentComponent getFragmentComponent() {
        return DaggerFragmentComponent.builder()
                .appComponent(MyApp.getAppComponent())
                .fragmentModule(getFragmentModule())
                .build();
    }

    public FragmentModule getFragmentModule() {
        return new FragmentModule(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) mPresenter.detachView();
//        mUnBinder.unbind();
    }

    protected abstract void initInject();

    protected abstract int getLayoutId();

    protected abstract void initEventAndData();
}
