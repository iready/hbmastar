package view.sun;

import model.ViewContent;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Yuquan Zou on 2015/12/24.
 */
public class Real_data {
    private JLabel L1;
    private JLabel username;
    private JLabel L2;
    private JLabel L3;
    private JPanel content;
    private JLabel userprice;
    private JLabel nowprice;
    private JLabel L4;
    private JLabel top;
    private JLabel L5;
    private JLabel low;
    private JLabel L6;
    private JLabel open;
    private ViewContent viewContent;
    private Logger logger = Logger.getLogger(Real_data.class);

    public Real_data(ViewContent viewContent) {
        this.viewContent = viewContent;
        creatUIRun();
    }

    private void creatUIRun() {
        ScheduledThreadPoolExecutor ste = viewContent.getApplicationContext().getBean("stpe", ScheduledThreadPoolExecutor.class);
        ste.scheduleAtFixedRate(new Runnable() {
            public void run() {

            }
        }, 0, 1, TimeUnit.SECONDS);
    }

    public JPanel getContent() {
        return content;
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        System.out.println("12");

    }

}
