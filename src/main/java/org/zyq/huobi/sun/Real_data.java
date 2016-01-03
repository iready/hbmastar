package org.zyq.huobi.sun;

import org.zyq.huobi.controller.APIOperation;
import org.zyq.huobi.controller.ResultProxy;
import org.zyq.huobi.other.entity.ViewContent;
import org.apache.log4j.Logger;
import org.zyq.huobi.other.entity.api.Get_account_info;
import org.zyq.huobi.other.entity.api.Ticker;
import org.zyq.huobi.other.entity.api.Ticker_btc_json;
import org.zyq.huobi.other.utils.SwingUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Yuquan Zou on 2015/12/24.
 */
public class Real_data {
    private final APIOperation api;
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
    private JLabel L11;
    private JLabel L12;
    private JLabel RMB;
    private JLabel L13;
    private JLabel BTB;
    private JLabel L21;
    private JLabel L22;
    private JLabel L23;
    private JLabel DGRMB;
    private JLabel DGBTB;
    private JLabel L33;
    private JButton openTrans;
    private JButton openZN;
    private JButton wt;
    private ViewContent viewContent;
    private Logger logger = Logger.getLogger(Real_data.class);

    public Real_data(final ViewContent viewContent) {
        this.viewContent = viewContent;
        api = viewContent.getApiOperation();
        creatUIRun();
        openTrans.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new buyAndSell(viewContent);
            }
        });
        wt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Entrust(viewContent);
            }
        });
    }

    private void creatUIRun() {
        ScheduledThreadPoolExecutor ste = viewContent.getApplicationContext().getBean("stpe", ScheduledThreadPoolExecutor.class);
        username.setText(api.getUserId());
        final JLabel[] jrr = new JLabel[]{top, low, open, RMB, BTB, DGRMB, DGBTB, nowprice, userprice};
        ste.scheduleAtFixedRate(new Runnable() {
            public void run() {
                try {
                    Get_account_info gai = ResultProxy.proxy(api.get_account_info(), Get_account_info.class);
                    Ticker_btc_json tbj = ResultProxy.proxy(api.TransactionReal(), Ticker_btc_json.class);
                    Ticker ticker = tbj.getTicker();
                    String[] srr = new String[jrr.length];
                    srr[0] = ticker.getHigh();
                    srr[1] = ticker.getLow();
                    srr[2] = ticker.getOpen();
                    srr[3] = gai.getAvailable_cny_display();
                    srr[4] = gai.getAvailable_btc_display();
                    srr[5] = gai.getFrozen_cny_display();
                    srr[6] = gai.getFrozen_btc_display();
                    srr[7] = ticker.getLast();
                    srr[8] = gai.getNet_asset();
                    for (int i = 0; i < srr.length; i++) {
                        SwingUtils.label_update_text(jrr[i], srr[i]);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 0, 1, TimeUnit.SECONDS);
    }

    public JPanel getContent() {
        return content;
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

}
