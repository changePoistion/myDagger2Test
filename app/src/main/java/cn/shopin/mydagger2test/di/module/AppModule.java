package cn.shopin.mydagger2test.di.module;

import javax.inject.Singleton;

import cn.shopin.mydagger2test.app.MyApp;
import cn.shopin.mydagger2test.model.apis.GankApis;
import cn.shopin.mydagger2test.model.http.RetrofitHelper;
import dagger.Module;
import dagger.Provides;

/**
 * Created by zcs on 2017/4/15.
 *
 * @desc
 */
@Module
public class AppModule {
    private final MyApp application;

    public AppModule(MyApp application) {
        this.application = application;
    }

    @Singleton
    @Provides
    MyApp provideApplicationContext() {
        return application;
    }

    @Singleton
    @Provides
    RetrofitHelper provideRetrofitHelper(GankApis gankApiService) {
        return new RetrofitHelper(gankApiService);
    }
}

