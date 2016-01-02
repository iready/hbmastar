package org.zyq.huobi.other.bean;

import org.zyq.huobi.model.HttpUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;
import org.zyq.huobi.other.utils.DataUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

@Component
public class MyHttpUtils implements HttpUtils {
    @Resource(name = "httpclient")
    private HttpClient httpClient;

    public boolean isRightUrl(String uri) {
        try {
            new URI(uri);
            return true;
        } catch (URISyntaxException e) {
            return false;
        }
    }

    @Override
    public String SendGet(String Url, HttpContext httpContext) throws ClientProtocolException, IOException {
        HttpResponse res = SendGetRes(Url, httpContext);
        StringBuilder sb = new StringBuilder();
        HttpEntity entity = null;
        if (res != null) {
            try {
                entity = res.getEntity();
                sb.append(EntityUtils.toString(entity, "utf-8"));
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                if (entity != null) {
                    EntityUtils.consume(entity);
                }
            }
        }
        return sb.toString();
    }

    @Override
    public HttpResponse SendGetRes(String Url, HttpContext httpContext) throws ClientProtocolException, IOException {
        if (isRightUrl(Url)) {
            HttpGet get = new HttpGet(Url);
            get.setHeader("Content-Type", "application/x-www-form-urlencoded");
            HttpResponse response = httpClient.execute(get, httpContext);
            return response;
        } else
            throw new RuntimeException(new URISyntaxException(Url, "�Ƿ�URI"));
    }

    @Override
    public String SendPost(String Url, HttpContext httpContext, Map<String, String> param) throws IOException {
        HttpResponse res = SendPostRes(Url, httpContext, param);
        StringBuilder sb = new StringBuilder();
        HttpEntity entity = null;
        if (res != null) {
            try {
                entity = res.getEntity();
                sb.append(EntityUtils.toString(entity, "utf-8"));
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                if (entity != null) {
                    EntityUtils.consume(entity);
                }
            }
        }
        return sb.toString();
    }

    @Override
    public HttpResponse SendPostRes(String Url, HttpContext httpContext, Map<String, String> param) throws ClientProtocolException, IOException {
        if (isRightUrl(Url)) {
            HttpPost post = new HttpPost(Url);
            post.setEntity(new UrlEncodedFormEntity(DataUtils.getFormData(param)));
            post.setHeader("Content-Type", "application/x-www-form-urlencoded");
            HttpResponse response = httpClient.execute(post, httpContext);
            return response;
        } else
            throw new RuntimeException(new URISyntaxException(Url, "�Ƿ�URI"));
    }
}
