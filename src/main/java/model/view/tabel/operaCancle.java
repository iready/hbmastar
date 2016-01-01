package model.view.tabel;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * Created by Yuquan Zou on 2016/1/1.
 */
public class operaCancle extends JButton implements TableCellRenderer {
    public operaCancle() {
        setText("撤销");
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return this;
    }
}
