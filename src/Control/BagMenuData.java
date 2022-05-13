package Control;

import Model.Item;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class BagMenuData extends AbstractTableModel {

    List<Item> data;

    public BagMenuData(ArrayList<Item> i){
        data = i;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Item item = data.get(rowIndex);
        return item.getName();
    }

    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void addItem(String name) {
    }

    public void removeItem(int row) {
        data.remove(row);
        if(data.size() == 0)
            fireTableRowsDeleted(0, 0);
        else
            fireTableRowsDeleted(0, data.size() - 1);
    }
}
