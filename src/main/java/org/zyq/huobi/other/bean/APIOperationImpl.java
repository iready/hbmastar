package org.zyq.huobi.other.bean;

import com.alibaba.fastjson.JSON;
import org.zyq.huobi.controller.APIOperation;
import org.zyq.huobi.controller.ResultProxy;
import org.zyq.huobi.model.HttpUtils;
import org.zyq.huobi.model.MyEntity;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.zyq.huobi.model.CMap;
import org.zyq.huobi.other.entity.FecUser;
import org.zyq.huobi.other.entity.api.*;
import org.zyq.huobi.other.entity.api.OrderBookandTAS.BTC_CNY;
import org.zyq.huobi.other.utils.ArgUtils;
import org.zyq.huobi.other.utils.EncryptUtil;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Component
@Scope("prototype")
public class APIOperationImpl implements APIOperation {
    private final String API_URL = "https://api.huobi.com/apiv3";
    public HttpContext httpContext = new BasicHttpContext();
    @Resource
    Dao dao;
    @Resource
    HttpUtils httpUtils;
    private String ACCESS_KEY;
    private String SECRET_KEY;
    private String user_id;


    public Result base_buy_sell(String amount, String exprectPrice, String trade_password, String type) throws IOException {
        String methodName;
        if (StringUtils.isNotEmpty(exprectPrice) && !"0".equals(exprectPrice)) {
            methodName = type;
            CMap cMap = getUsurlCMap(methodName).put("coin_type", "1").put("amount", amount).put("price", exprectPrice);
            cMap.put("sign", EncryptUtil.getSign(cMap)).remove("secret_key");
            if (StringUtils.isNotEmpty(trade_password))
                cMap.put("trade_password", trade_password);
            String urlString = API_URL + "?" + EncryptUtil.format(cMap);
            String resultString = httpUtils.SendGet(urlString, httpContext);
            return parseJson(resultString, Trading.class);
        } else {
            methodName = type + "_market";
            CMap cMap = getUsurlCMap(methodName).put("coin_type", "1").put("amount", amount);
            cMap.put("sign", EncryptUtil.getSign(cMap)).remove("secret_key");
            if (StringUtils.isNotEmpty(trade_password))
                cMap.put("trade_password", trade_password);
            String urlString = API_URL + "?" + EncryptUtil.format(cMap);
            String resultString = httpUtils.SendGet(urlString, httpContext);
            return parseJson(resultString, Trading.class);
        }
    }

    public Result buy(String amount, String exprectPrice, String trade_password) throws IOException {
        return base_buy_sell(amount, exprectPrice, trade_password, "buy");
    }

    /**
     * 交易函数
     *
     * @param config 为一个长度为5的数组 第一个参数代表的是 百分比 第二个代表的是买入还是卖出 第三个是按市价还是按委托价 第四个代表的是委托的价格 第5个为交易密码
     * @return
     */
    public Result buyAndSell(String[] config) {
        if (ArgUtils.numBetween(config[0], 0, 101) && ArgUtils.numBetween(config[1], -1, 2) && ArgUtils.numBetween(config[2], -1, 2)) {
//计算数量
            try {
                BigDecimal persent = new BigDecimal(config[0]).divide(new BigDecimal(100));
                Get_account_info gai = ResultProxy.proxy(get_account_info(), Get_account_info.class);
                if (config[1].equals("0")) {
                    String amout = null;
                    String pricee = null;
                    if (config[2].equals("0") && StringUtils.isNotEmpty(config[3])) {
                        pricee = config[3];
                        amout = new BigDecimal(gai.getAvailable_cny_display()).multiply(persent).divide(new BigDecimal(pricee), 4, BigDecimal.ROUND_DOWN).toString();
                    } else {
                        amout = new BigDecimal(gai.getAvailable_cny_display()).multiply(persent).setScale(2, BigDecimal.ROUND_DOWN).toString();
                    }
                    return buy(amout, pricee, config[4]);
                } else if (config[1].equals("1")) {
                    String amout = new BigDecimal(gai.getAvailable_btc_display()).multiply(persent).setScale(4, BigDecimal.ROUND_DOWN).toString();
                    String pricee = null;
                    if (config[2].equals("0")) {
                        pricee = config[3];
                    }
                    return sell(amout, pricee, config[4]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public Result get_account_info() throws IOException {
        String methodName = "get_account_info";
        CMap cMap = getUsurlCMap(methodName);
        cMap.put("sign", EncryptUtil.getSign(cMap)).remove("secret_key");
        String urlString = API_URL + "?" + EncryptUtil.format(cMap);
        String resultString = httpUtils.SendGet(urlString, httpContext);
        return parseJson(resultString, Get_account_info.class);
    }

    public List<Get_orders> get_orders() throws IOException {
        String methodName = "get_orders";
        CMap cMap = getUsurlCMap(methodName).put("coin_type", "1");
        cMap.put("sign", EncryptUtil.getSign(cMap)).remove("secret_key");
        String urlString = API_URL + "?" + EncryptUtil.format(cMap);
        String resultString = httpUtils.SendGet(urlString, httpContext);
        List<Get_orders> list = JSON.parseArray(resultString, Get_orders.class);
        return list;
    }

    public Result cancel_order(String id) throws IOException {
        String methodName = "cancel_order";
        CMap cMap = new CMap().put("access_key", ACCESS_KEY).put("coin_type", "1").put("created", getNowTime()).put("id", id).put("method", methodName).put("secret_key", SECRET_KEY);
        cMap.put("sign", EncryptUtil.getSign(cMap)).remove("secret_key");
        String urlString = API_URL + "?" + EncryptUtil.format(cMap);
        String resultString = httpUtils.SendGet(urlString, httpContext);
        System.out.println(resultString);
        return null;
    }

    private Long getNowTime() {
        return System.currentTimeMillis() / 1000;
    }

    private CMap getUsurlCMap(String methodName) {
        CMap cMap = new CMap().put("access_key", ACCESS_KEY).put("created", getNowTime()).put("secret_key", SECRET_KEY).put("method", methodName);
        return cMap;
    }

    public Result Order_BookandTAS() throws IOException {
        return parseJson(httpUtils.SendGet("http://api.huobi.com/staticmarket/detail_btc_json.js", httpContext), BTC_CNY.class);
    }

    public Result sell(String amount, String exprectPrice, String trade_password) throws IOException {
        return base_buy_sell(amount, exprectPrice, trade_password, "sell");
    }

    public String getUserId() {
        return this.user_id;
    }

    public void setUserId(String userId) {
        this.user_id = userId;
        List<FecUser> fecUser = dao.find("from FecUser where userId=:userId", new CMap().put("userId", userId), new MyEntity<FecUser>());
        FecUser user = fecUser.get(0);
        ACCESS_KEY = user.getAccess_key();
        SECRET_KEY = user.getSecret_key();
    }

    public Result TransactionReal() throws IOException {
        return parseJson(httpUtils.SendGet("http://api.huobi.com/staticmarket/ticker_btc_json.js", httpContext), Ticker_btc_json.class);
    }

    private Result parseJson(String json, Class<? extends Result> class1) {
        ErrorMessage errorMessage = JSON.parseObject(json, ErrorMessage.class);
        if (errorMessage.getCode() == null && errorMessage.getMessage() == null && errorMessage.getMsg() == null) {
            return JSON.parseObject(json, class1);
        }
        return errorMessage.getClass().cast(errorMessage);
    }
}
