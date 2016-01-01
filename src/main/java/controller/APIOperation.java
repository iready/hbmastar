package controller;

import org.apache.http.client.ClientProtocolException;
import other.entity.api.Get_orders;
import other.entity.api.Result;

import java.io.IOException;
import java.util.List;

public interface APIOperation {
    Result buy(String amount, String exprectPrice, String trade_password) throws IOException;

    /**
     * 交易函数
     *
     * @param config 为一个长度为4的数组 第一个参数代表的是 百分比 第二个代表的是买入还是卖出 第三个是按市价还是按委托价 第四个代表的是委托的价格
     * @return
     */
    Result buyAndSell(String[] config);

    /**
     * 获取个人资产信息
     *
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    Result get_account_info() throws IOException;

    /**
     * 获取委托详情
     *
     * @return
     */
    List<Get_orders> get_orders() throws IOException;

    Result Order_BookandTAS() throws IOException;

    Result sell(String amount, String exprectPrice, String trade_password) throws IOException;

    String getUserId();

    void setUserId(String userId);

    /**
     * 实时行情
     *
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    Result TransactionReal() throws IOException;


}
