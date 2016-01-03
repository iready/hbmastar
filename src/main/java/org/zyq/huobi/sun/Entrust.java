package org.zyq.huobi.sun;

import org.zyq.huobi.controller.APIOperation;
import org.zyq.huobi.model.view.tabel.EntrustModel;
import org.zyq.huobi.model.view.tabel.operaCancle;
import org.zyq.huobi.model.ViewContent;
import org.zyq.huobi.other.entity.api.Get_orders;
import org.zyq.huobi.other.utils.SwingUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

/**
 * Created by Yuquan Zou on 2016/1/3.
 */
public class Entrust {
    final APIOperation api;
    String[] headers;
    private JPanel content;
    private JTable entable;
    private JButton refresh;
    private JLabel L1;

    public Entrust(ViewContent viewContent) {
        JFrame jFrame = new JFrame("委托");
        api = viewContent.getApiOperation();
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        init();
        jFrame.setContentPane(this.content);
        SwingUtils.window_centered(jFrame);
        jFrame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    private void init() {
        headers = new String[]{"id", "类型", "委托价格", "委托数量", "委托时间", "委托操作"};
        try {
            entable.setModel(new EntrustModel(data_handle(api.get_orders()), headers));
            operaCancle operaCancle = new operaCancle(api);
            entable.getColumnModel().getColumn(5).setCellEditor(operaCancle);
            entable.getColumnModel().getColumn(5).setCellRenderer(operaCancle);
            refresh.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        List<Get_orders> list = api.get_orders();
                        EntrustModel model = (EntrustModel) entable.getModel();
                        model.setDataVector(data_handle(list), headers);
                        operaCancle operaCancle = new operaCancle(api);
                        entable.getColumnModel().getColumn(5).setCellEditor(operaCancle);
                        entable.getColumnModel().getColumn(5).setCellRenderer(operaCancle);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Object[][] data_handle(List<Get_orders> orderses) {
        int l = 5;
        Object[][] objects = new Object[orderses.size()][l];
        for (int i = 0; i < orderses.size(); i++) {
            Get_orders get_orders = orderses.get(i);
            Object[] object = new Object[l];
            object[0] = get_orders.getId();
            object[1] = get_orders.getType().equals("1") ? "买入" : "卖出";
            object[2] = get_orders.getOrder_price();
            object[3] = get_orders.getOrder_amount();
            object[4] = get_orders.getOrder_time();
            objects[i] = object;
        }
        return objects;
    }
}
