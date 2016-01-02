package org.zyq.huobi.other.entity.api;

/**
 * Created by Yuquan Zou on 2016/1/1.
 */
public class Get_orders implements Result {

    private String id;//委托订单id
    private String type;//1买 2卖
    private String order_price;//委托价格
    private String order_amount;//委托数量
    private String processed_amount;//已经完成的数量
    private String order_time;//委托时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrder_price() {
        return order_price;
    }

    public void setOrder_price(String order_price) {
        this.order_price = order_price;
    }

    public String getOrder_amount() {
        return order_amount;
    }

    public void setOrder_amount(String order_amount) {
        this.order_amount = order_amount;
    }

    public String getProcessed_amount() {
        return processed_amount;
    }

    public void setProcessed_amount(String processed_amount) {
        this.processed_amount = processed_amount;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

}

