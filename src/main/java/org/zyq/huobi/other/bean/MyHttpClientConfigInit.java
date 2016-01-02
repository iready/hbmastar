package org.zyq.huobi.other.bean;

import org.apache.http.Consts;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.MessageConstraints;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.cookie.*;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.cookie.BestMatchSpecFactory;
import org.apache.http.impl.cookie.BrowserCompatSpec;
import org.apache.http.impl.cookie.BrowserCompatSpecFactory;
import org.apache.http.protocol.HttpContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.nio.charset.CodingErrorAction;
import java.util.concurrent.ExecutorService;

@Component
public class MyHttpClientConfigInit {
    @Resource(name = "es")
    private ExecutorService es;
    private HttpClient httpClient;

    public HttpClient getClient() {
        return httpClient;
    }

    @PostConstruct
    private void init() {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        CookieSpecProvider easySpecProvider = new CookieSpecProvider() {
            public CookieSpec create(HttpContext context) {
                return new BrowserCompatSpec() {
                    public void validate(Cookie cookie, CookieOrigin origin) throws MalformedCookieException {
                    }
                };
            }
        };
        ConnectionConfig connectionConfig = ConnectionConfig.custom().setMalformedInputAction(CodingErrorAction.IGNORE).setUnmappableInputAction(CodingErrorAction.IGNORE).setCharset(Consts.UTF_8)
                .setMessageConstraints(MessageConstraints.DEFAULT).build();
        Registry<CookieSpecProvider> reg = RegistryBuilder.<CookieSpecProvider>create().register(CookieSpecs.DEFAULT, new BestMatchSpecFactory())
                .register(CookieSpecs.DEFAULT, new BrowserCompatSpecFactory()).register("mySpec", easySpecProvider).build();
        cm.setDefaultConnectionConfig(connectionConfig);
        cm.setMaxTotal(100);
        cm.setDefaultMaxPerRoute(10);
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(10000).setConnectTimeout(10000).setCookieSpec("mySpec").build();
        HttpClientBuilder hp = HttpClients.custom().setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.71 Safari/537.36")
                .setDefaultCookieSpecRegistry(reg).setConnectionManager(cm).setMaxConnPerRoute(5).setMaxConnTotal(5).setDefaultRequestConfig(requestConfig);
        httpClient = hp.build();
    }
}
