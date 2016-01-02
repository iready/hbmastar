package org.zyq.huobi.model;

import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;
import java.util.Map;

public interface HttpUtils {
    String SendGet(String Url, HttpContext httpContext) throws IOException;

    HttpResponse SendGetRes(String Url, HttpContext httpContext) throws IOException;

    String SendPost(String Url, HttpContext httpContext, Map<String, String> param) throws IOException;

    HttpResponse SendPostRes(String Url, HttpContext httpContext, Map<String, String> param) throws IOException;
}
