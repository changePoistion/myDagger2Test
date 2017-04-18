package cn.shopin.mydagger2test.ui.gank;

import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import cn.shopin.mydagger2test.R;
import cn.shopin.mydagger2test.base.BaseFragment;
import cn.shopin.mydagger2test.contract.GankMainContract;
import cn.shopin.mydagger2test.model.entity.GankItemBean;
import cn.shopin.mydagger2test.presenter.GankMainPresenter;
import cn.shopin.mydagger2test.ui.gank.adapter.GirlAdapter;

/**
 * Created by zcs on 2017/4/15.
 *
 * @desc
 */
public class GankMainFragment extends BaseFragment<GankMainPresenter> implements GankMainContract.View {
    @Bind(R.id.listview)
    protected ListView listView;
    private GirlAdapter girlAdapter;
    private List<GankItemBean> dates;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frag_gank;
    }

    @Override
    protected void initEventAndData() {
        dates = new ArrayList<>();
        girlAdapter = new GirlAdapter(getActivity(), dates);
        listView.setAdapter(girlAdapter);
        mPresenter.getGirlDates();
    }

    @Override
    public void getGirlDates(List<GankItemBean> dates) {
        this.dates.addAll(dates);
        girlAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorMsg(String errorMsg) {

    }
}
