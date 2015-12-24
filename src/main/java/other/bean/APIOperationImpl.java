package other.bean;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import controller.APIOperation;
import model.HttpUtils;
import model.MyEntity;
import other.CMap;
import other.entity.FecUser;
import other.entity.api.ErrorMessage;
import other.entity.api.Get_account_info;
import other.entity.api.Result;
import other.entity.api.Ticker_btc_json;
import other.entity.api.Trading;
import other.entity.api.OrderBookandTAS.BTC_CNY;
import other.utils.EncryptUtil;

@Component
@Scope("prototype")
public class APIOperationImpl implements APIOperation {
    private String ACCESS_KEY;
    private final String API_URL = "https://api.huobi.com/apiv3";
    @Resource
    Dao dao;
    public HttpContext httpContext = new BasicHttpContext();
    @Resource
    HttpUtils httpUtils;
    private String SECRET_KEY;


    public Result buy(String amount, String exprectPrice, String trade_password) throws IOException {
        String methodName;
        if (StringUtils.isNotEmpty(exprectPrice) && !"0".equals(exprectPrice)) {
            methodName = "buy";
            CMap cMap = getUsurlCMap(methodName).put("coin_type", "1").put("amount", amount).put("price", exprectPrice);
            cMap.put("sign", EncryptUtil.getSign(cMap)).remove("secret_key");
            if (StringUtils.isNotEmpty(trade_password))
                cMap.put("trade_password", trade_password);
            String urlString = API_URL + "?" + EncryptUtil.format(cMap);
            String resultString = httpUtils.SendGet(urlString, httpContext);
            return parseJson(resultString, Trading.class);
        } else {
            methodName = "buy_market";
            Matcher matcher = Pattern.compile("(\\d+)(\\.\\d{0,2})?").matcher(amount);
            StringBuilder sBuilder = new StringBuilder();
            if (matcher.find()) {
                if (StringUtils.isNotBlank(matcher.group(1))) {
                    sBuilder.append(matcher.group(1));
                    if (StringUtils.isNotBlank(matcher.group(2))) {
                        sBuilder.append(matcher.group(2));
                    }
                }
            }
            CMap cMap = getUsurlCMap(methodName).put("coin_type", "1").put("amount", sBuilder.toString());
            cMap.put("sign", EncryptUtil.getSign(cMap)).remove("secret_key");
            if (StringUtils.isNotEmpty(trade_password))
                cMap.put("trade_password", trade_password);
            String urlString = API_URL + "?" + EncryptUtil.format(cMap);
            String resultString = httpUtils.SendGet(urlString, httpContext);
            return parseJson(resultString, Trading.class);
        }
    }

    public Result get_account_info() throws IOException {
        String methodName = "get_account_info";
        CMap cMap = getUsurlCMap(methodName);
        cMap.put("sign", EncryptUtil.getSign(cMap)).remove("secret_key");
        String urlString = API_URL + "?" + EncryptUtil.format(cMap);
        String resultString = httpUtils.SendGet(urlString, httpContext);
        return parseJson(resultString, Get_account_info.class);
    }

    public Result get_orders() {

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
        String methodName;
        if (StringUtils.isNotEmpty(exprectPrice) && !"0".equals(exprectPrice)) {
            methodName = "buy";
            CMap cMap = getUsurlCMap(methodName).put("coin_type", "1").put("amount", amount).put("price", exprectPrice);
            cMap.put("sign", EncryptUtil.getSign(cMap)).remove("secret_key");
            if (StringUtils.isNotEmpty(trade_password))
                cMap.put("trade_password", trade_password);
            String urlString = API_URL + "?" + EncryptUtil.format(cMap);
            String resultString = httpUtils.SendGet(urlString, httpContext);
            return parseJson(resultString, Trading.class);
        } else {
            methodName = "sell_market";
            Matcher matcher = Pattern.compile("(\\d+)(\\.\\d{0,4})?").matcher(amount);
            StringBuilder sBuilder = new StringBuilder();
            if (matcher.find()) {
                if (StringUtils.isNotBlank(matcher.group(1))) {
                    sBuilder.append(matcher.group(1));
                    if (StringUtils.isNotBlank(matcher.group(2))) {
                        sBuilder.append(matcher.group(2));
                    }
                }
            }
            CMap cMap = getUsurlCMap(methodName).put("coin_type", "1").put("amount", sBuilder.toString());
            cMap.put("sign", EncryptUtil.getSign(cMap)).remove("secret_key");
            if (StringUtils.isNotEmpty(trade_password))
                cMap.put("trade_password", trade_password);
            String urlString = API_URL + "?" + EncryptUtil.format(cMap);
            String resultString = httpUtils.SendGet(urlString, httpContext);
            return parseJson(resultString, Result.class);
        }
    }

    public void setUserId(String userId) {
        List<FecUser> fecUser = dao.find("from FecUser where userId=:userId", new CMap().put("userId", userId), new MyEntity<FecUser>());
        FecUser user = fecUser.get(0);
        ACCESS_KEY = user.getAccess_key();
        SECRET_KEY = user.getSecret_key();
    }

    public Result TransactionReal() throws IOException {
        return parseJson(httpUtils.SendGet("http://api.huobi.com/staticmarket/ticker_btc_json.js", httpContext), Ticker_btc_json.class);
    }

    private <T> T parseJson(String json, Class<T> class1) {
        ErrorMessage errorMessage = JSON.parseObject(json, ErrorMessage.class);
        if (errorMessage.getCode() == null && errorMessage.getMessage() == null && errorMessage.getMsg() == null) {
            return JSON.parseObject(json, class1);
        }
        return class1.cast(errorMessage);
    }
}
