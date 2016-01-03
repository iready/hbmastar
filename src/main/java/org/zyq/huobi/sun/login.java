package org.zyq.huobi.sun;

import org.zyq.huobi.controller.APIOperation;
import org.zyq.huobi.other.entity.ViewContent;
import org.zyq.huobi.other.entity.FecUser;
import org.zyq.huobi.other.entity.Result;
import org.zyq.huobi.other.utils.SwingUtils;
import org.zyq.huobi.service.LoginService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Yuquan Zou on 2015/12/24.
 */
public class login {
    private JTextField username;
    private JButton login;
    private JLabel user;
    private JPanel loginJpanel;


    public login(final ViewContent viewContent) {
        final LoginService loginService = viewContent.getApplicationContext().getBean(LoginService.class);
        final JFrame frame = viewContent.getFrame();
        username.setText("13299266512");
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Result<List<FecUser>> bool = loginService.validate(username.getText());
                if (!bool.isResult()) {
                    JOptionPane.showMessageDialog(null, "没有此用户", "警告", JOptionPane.WARNING_MESSAGE);
                } else {
                    APIOperation apiOperation = viewContent.getApiOperation();
                    apiOperation.setUserId(username.getText().trim());
                    Real_data real_data = new Real_data(viewContent);
                    SwingUtils.window_replace(frame, real_data.getContent(), "main");
                }
            }

        });
    }

    public JPanel getLoginJpanel() {
        return loginJpanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

}
