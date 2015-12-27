package other.utils;

import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;

public class SwingUtils {
    public static void window_replace(JFrame jFrame, JPanel nextJPanel, String title) {
        jFrame.setTitle(title);
        jFrame.setContentPane(nextJPanel);
        jFrame.pack();
    }

    public static String getTextFromSelectedButtonGroup(ButtonGroup bg) {
        Enumeration<AbstractButton> en = bg.getElements();
        while (en.hasMoreElements()) {
            AbstractButton ab = en.nextElement();
            if (ab.isSelected()) {
                return ab.getText();
            }
        }
        return null;
    }


    public static void window_centered(JFrame frame) {
        frame.pack();
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        int x = (width - frame.getWidth()) / 2;
        int y = (height - frame.getHeight()) / 2;
        frame.setLocation(x, y);
    }

    public static void label_update_text(JLabel jLabel, String text) {
        if (!jLabel.getText().equals(text))
            jLabel.setText(text);
    }
}
