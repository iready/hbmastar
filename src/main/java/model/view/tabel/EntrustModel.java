package model.view.tabel;

import javax.swing.table.DefaultTableModel;

/**
 * Created by Yuquan Zou on 2016/1/1.委托表格模型
 */
public class EntrustModel extends DefaultTableModel {
    public EntrustModel(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return true;
    }
}
