package cn.shopin.mydagger2test.model.entity;

/**
 * Created by zcs on 2017/4/16.
 *
 * @desc
 */
public class GankHttpResponse<T> {
    private boolean error;
    private T results;

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }

    public boolean getError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
