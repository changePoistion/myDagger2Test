package cn.shopin.mydagger2test.contract;

import java.util.List;

import cn.shopin.mydagger2test.base.BaseView;
import cn.shopin.mydagger2test.model.entity.GankItemBean;

/**
 * Created by zcs on 2017/4/15.
 *
 * @desc
 */
public interface GankMainContract {
    interface View extends BaseView {
        void getGirlDates(List<GankItemBean> dates);
    }

    interface Presenter {
        void getGirlDates();
    }

}
