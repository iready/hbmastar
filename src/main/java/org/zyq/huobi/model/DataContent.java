package org.zyq.huobi.model;

import java.math.BigDecimal;

/**
 * Created by Yuquan Zou on 2016/1/2.
 */
public class DataContent {
    private String variance;//方差
    private String nowprice;//现价
    private String average;//平均值
    private LimiteList<String> ten = new LimiteList<String>(10);//10s现价

    public void analysis() {
        if (ten.getInitialCapacity() == ten.size()) {
            BigDecimal sum = new BigDecimal(0);
            for (String s : ten) {
                sum = sum.add(new BigDecimal(s));
            }
            average = sum.divide(new BigDecimal(ten.getInitialCapacity())).toString();
            BigDecimal fx = new BigDecimal(0);
            for (String s : ten) {
                BigDecimal sub = new BigDecimal(s).subtract(new BigDecimal(average));
                fx = fx.add(sub.multiply(sub));
            }
            variance = fx.toString();
        }
    }

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

    @Override
    public String toString() {
        return "DataContent{" +
                "variance='" + variance + '\'' +
                ", nowprice='" + nowprice + '\'' +
                ", average='" + average + '\'' +
                ", ten=" + ten +
                '}';
    }
}
