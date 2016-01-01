package model.view.tabel;

import javax.swing.table.DefaultTableModel;

/**
 * Created by Yuquan Zou on 2016/1/1.
 */
public class Entrust extends DefaultTableModel {
    public Entrust(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
