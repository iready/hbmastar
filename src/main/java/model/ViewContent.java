package model;

import controller.APIOperation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.swing.*;

/**
 * Created by Yuquan Zou on 2015/12/26.
 */
@Component
@Lazy
public class ViewContent {
    @Resource
    private JFrame frame;
    @Resource
    private ApplicationContext applicationContext;

    private APIOperation apiOperation;

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
}
