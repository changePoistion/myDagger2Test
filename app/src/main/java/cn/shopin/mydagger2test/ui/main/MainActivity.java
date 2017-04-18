package cn.shopin.mydagger2test.ui.main;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import cn.shopin.mydagger2test.R;
import cn.shopin.mydagger2test.base.BaseActivity;
import cn.shopin.mydagger2test.contract.MainContract;
import cn.shopin.mydagger2test.presenter.MainPresenter;
import cn.shopin.mydagger2test.ui.gank.GankMainFragment;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @Bind(R.id.container)
    protected FrameLayout container;
    @Bind(R.id.text)
    protected TextView text;
    private GankMainFragment gankFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        gankFragment = new GankMainFragment();
        super.onCreate(savedInstanceState);
        text.setText("hhhhhh");
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData() {
        checkVersion();
        getSupportFragmentManager().beginTransaction().add(R.id.container, gankFragment).commit();
    }

    @Override
    public void showMsg(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void checkVersion() {
        mPresenter.checkVersion("检测中。。。");
    }

    @Override
    public void showErrorMsg(String errorMsg) {

    }
}
