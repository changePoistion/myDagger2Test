package cn.shopin.mydagger2test.di.component;

import javax.inject.Singleton;

import cn.shopin.mydagger2test.app.MyApp;
import cn.shopin.mydagger2test.di.module.AppModule;
import cn.shopin.mydagger2test.di.module.HttpModule;
import cn.shopin.mydagger2test.model.http.RetrofitHelper;
import dagger.Component;

/**
 * Created by zcs on 2017/4/15.
 *
 * @desc
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {
    MyApp getContext();  // 获得App的Context

    RetrofitHelper retrofitHelper();  //提供http的帮助类
}
