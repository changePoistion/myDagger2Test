package cn.shopin.mydagger2test.contract;

import cn.shopin.mydagger2test.base.BaseView;

/**
 * Created by zcs on 2017/4/15.
 *
 * @desc
 */
public interface MainContract {
    interface View extends BaseView {
        void showMsg(String message);
        void checkVersion();
    }

    interface Presenter {

        void checkVersion(String currentVersion);

    }

}
