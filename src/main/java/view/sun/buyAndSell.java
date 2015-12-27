package view.sun;

import model.ViewContent;
import other.utils.SwingUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * Created by Yuquan Zou on 2015/12/26.
 */
public class buyAndSell {
    private JPanel content;
    private JLabel L1;
    private JRadioButton a25RadioButton;
    private JRadioButton a50RadioButton;
    private JRadioButton a75RadioButton;
    private JRadioButton a100RadioButton;
    private JLabel L2;
    private JRadioButton buy;
    private JRadioButton sell;
    private JRadioButton shijia;
    private JRadioButton weituo;
    private JLabel L3;
    private JTextField textField1;
    private JButton submit;
    private JRadioButton othersradion;
    private JTextField textField2;
    private String value[] = new String[4];

    public buyAndSell(final ViewContent viewContent) {
        JFrame jFrame = new JFrame("交易");
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jFrame.setContentPane(this.content);
        SwingUtils.window_centered(jFrame);
        jFrame.setVisible(true);
        ActionListener listener1 = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JRadioButton jRadioButton = (JRadioButton) e.getSource();
                if (jRadioButton.getText().equals("买入")) {
                    value[1] = "0";
                } else {
                    value[1] = "1";
                }
            }
        };
        buy.addActionListener(listener1);
        sell.addActionListener(listener1);
        ActionListener listener2 = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JRadioButton jRadioButton = (JRadioButton) e.getSource();
                if (jRadioButton.getText().equals("委托")) {
                    value[2] = "0";
                    textField1.setEnabled(true);
                } else {
                    value[2] = "1";
                    textField1.setEnabled(false);
                }
            }
        };
        shijia.addActionListener(listener2);
        weituo.addActionListener(listener2);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (String s : value)
                    System.out.println(s);
            }
        });
        textField1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                System.out.println(1);
            }

            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                System.out.println(2);
            }
        });
        othersradion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField2.setEnabled(true);
                value[0] = textField2.getText();

            }
        });
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JRadioButton radioButton = (JRadioButton) e.getSource();
                value[0] = (radioButton.getText().replace("%", ""));
                textField2.setEnabled(false);
            }
        };
        a25RadioButton.addActionListener(listener);
        a50RadioButton.addActionListener(listener);
        a75RadioButton.addActionListener(listener);
        a100RadioButton.addActionListener(listener);
        textField2.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                JTextField tf = (JTextField) e.getSource();
                value[0] = tf.getText();
            }
        });
        textField1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                JTextField tf = (JTextField) e.getSource();
                value[3] = tf.getText();
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

}
