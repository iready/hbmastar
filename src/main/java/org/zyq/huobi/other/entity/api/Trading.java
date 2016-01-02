package org.zyq.huobi.other.entity.api;

public class Trading implements Result {
    public String result;// 委托结果
    public String id;// 委托id

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
