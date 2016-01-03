package org.zyq.huobi.controller;

import org.zyq.huobi.model.ViewContent;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.zyq.huobi.other.utils.SwingUtils;
import org.zyq.huobi.sun.login;

import javax.annotation.Resource;
import javax.swing.*;

@Service
public class FecMain {
    @Resource
    ApplicationContext ah;

    public void begain() {
        try {
            JFrame frame=new JFrame("main");
            ViewContent viewContent=new ViewContent();
            viewContent.setApplicationContext(ah);
            viewContent.setFrame(frame);
            viewContent.setApiOperation(ah.getBean(APIOperation.class));
            login login=new login(viewContent);
            SwingUtils.window_replace(frame, login.getLoginJpanel(), "login");
            SwingUtils.window_centered(frame);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
