package org.zyq.huobi.other.utils;

import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Yuquan Zou on 2015/12/20.
 */
public class DataUtils {
    public static List<BasicNameValuePair> getFormData(Map<String, String> map) {
        List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>() {
            @Override
            public boolean add(BasicNameValuePair e) {
                if (e.getValue() == null) {
                    e = new BasicNameValuePair(e.getName(), "");
                }
                return super.add(e);
            }
        };
        for (Map.Entry<String, String> e : map.entrySet()) {
            params.add(new BasicNameValuePair(e.getKey(), e.getValue()));
        }
        System.out.println(params);
        return params;
    }
}
