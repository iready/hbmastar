package org.zyq.huobi.other.entity;

import org.zyq.huobi.controller.APIOperation;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yuquan Zou on 2015/12/26.
 */
public class ViewContent {
    private JFrame frame; //主体
    private ApplicationContext applicationContext;//spring 上下文

    private APIOperation apiOperation;//操作api

    private Map<String, JFrame> jFrameMap = new HashMap<String, JFrame>();//窗口

    public APIOperation getApiOperation() {
        return apiOperation;
    }

    public void setApiOperation(APIOperation apiOperation) {
        this.apiOperation = apiOperation;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public Map<String, JFrame> getjFrameMap() {
        return jFrameMap;
    }

    public void setjFrameMap(Map<String, JFrame> jFrameMap) {
        this.jFrameMap = jFrameMap;
    }
}
