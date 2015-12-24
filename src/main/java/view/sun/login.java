package view.sun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import other.bean.Dao;
import other.entity.FecUser;
import other.entity.Result;
import service.LoginService;

import javax.annotation.Resource;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * Created by Yuquan Zou on 2015/12/24.
 */
public class login {
    private JTextField username;
    private JButton login;
    private JLabel user;
    private JPanel loginJpanel;


    @Autowired
    private Dao dao;

    public login(JFrame frame, final LoginService loginService) {
        login.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Result<List<FecUser>> bool = loginService.validate(username.getText());
                if (!bool.isResult()) {
                    JOptionPane.showMessageDialog(null, "没有此用户", "警告", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    public JPanel getLoginJpanel() {
        return loginJpanel;
    }
}
