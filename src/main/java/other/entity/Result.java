package other.entity;

/**
 * Created by Yuquan Zou on 2015/12/24.
 */
public class Result<T> {
    private boolean result;
    private T data;

    public Result(T data) {
        this.data = data;
    }

    public Result() {
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
