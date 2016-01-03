package org.zyq.huobi.model;

/**
 * Created by Yuquan Zou on 2016/1/2.
 */
public class DataContent {
    private String variance;//方差
    private String nowprice;//现价
    private String average;//平均值
    private LimiteList<String> ten = new LimiteList<String>(10);//10s现价

    public LimiteList<String> getTen() {
        return ten;
    }


    public String getNowprice() {
        return nowprice;
    }

    public void setNowprice(String nowprice) {
        this.nowprice = nowprice;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public String getVariance() {
        return variance;
    }

    public void setVariance(String variance) {
        this.variance = variance;
    }
}
