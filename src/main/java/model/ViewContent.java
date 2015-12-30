package model;

import controller.APIOperation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yuquan Zou on 2015/12/26.
 */
public class ViewContent {
    private JFrame frame; //主体
    private ApplicationContext applicationContext;

    private APIOperation apiOperation;

    private Map<String, JFrame> jFrameMap = new HashMap<String, JFrame>();

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
