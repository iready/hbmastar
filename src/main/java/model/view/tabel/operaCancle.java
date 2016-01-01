package model.view.tabel;

import controller.APIOperation;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuquan Zou on 2016/1/1.
 */
public class operaCancle extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
    private APIOperation api;
    private List<JButton> buttonList = new ArrayList<JButton>();

    public operaCancle(final APIOperation api) {
        this.api = api;
    }


    public Object getCellEditorValue() {

        return null;
    }

    public Component getTableCellEditorComponent(final JTable table, Object value, boolean isSelected, final int row, int column) {
        return buttonList.get(row);
    }

    public Component getTableCellRendererComponent(final JTable table, Object value, boolean isSelected, boolean hasFocus, final int row, int column) {
        if (buttonList.size() < table.getRowCount()) {
            JButton jButton = new JButton("撤销");
            jButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        api.cancel_order(table.getValueAt(row, 0).toString());
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            });
            buttonList.add(jButton);
        }
        return buttonList.get(row);
    }
}
