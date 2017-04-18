package cn.shopin.mydagger2test.presenter;

import javax.inject.Inject;

import cn.shopin.mydagger2test.base.BasePresenter;
import cn.shopin.mydagger2test.contract.MainContract;

/**
 * Created by zcs on 2017/4/15.
 *
 * @desc
 */
public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    @Inject
    public MainPresenter() {
    }

    @Override
    public void checkVersion(String currentVersion) {
        getView().showMsg(currentVersion);
    }
}
