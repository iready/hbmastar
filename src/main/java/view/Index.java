package view;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import other.utils.SwingUtils;
import service.LoginService;
import view.sun.login;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.swing.*;

/**
 * Created by Yuquan Zou on 2015/12/24.
 */
@Controller
@Lazy
public class Index extends JFrame {
    @Resource
    protected LoginService loginService;
    @Resource(name = "loginView")
    protected login loginView;

    public Index() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @PostConstruct
    public void init() {
        SwingUtils.window_replace(this, loginView.getLoginJpanel(), "login");
        SwingUtils.window_centered(this);
    }
}
