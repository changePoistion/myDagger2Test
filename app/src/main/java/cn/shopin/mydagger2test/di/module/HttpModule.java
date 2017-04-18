package cn.shopin.mydagger2test.di.module;

import javax.inject.Singleton;

import cn.shopin.mydagger2test.di.qualifier.GankUrl;
import cn.shopin.mydagger2test.model.apis.GankApis;
import cn.shopin.mydagger2test.util.RetrofitUtil;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by zcs on 2017/4/16.
 *
 * @desc
 */
@Module
public class HttpModule {

    /**
     * @return
     * @desc 提供OkHttpBuilder
     */
    @Singleton
    @Provides
    OkHttpClient.Builder provideOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }

    /**
     * @return
     * @desc 提供OkHttpClient
     */
    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {
        return builder.build();
    }

    /**
     * @return
     * @desc 提供RetrofitBuilder
     */
    @Singleton
    @Provides
    Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    @Singleton
    @Provides
    @GankUrl//和下边的provideGankService方法中的参数对应
    Retrofit provideGankRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return RetrofitUtil.createRetrofit(builder, client, GankApis.HOST);
    }

    @Singleton
    @Provides
    GankApis provideGankService(@GankUrl Retrofit retrofit) {
        return retrofit.create(GankApis.class);
    }

}
