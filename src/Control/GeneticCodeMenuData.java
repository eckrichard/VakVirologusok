package Control;

import Model.Agent;
import Model.GeneticCode;
import Model.Item;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeneticCodeMenuData extends AbstractTableModel {

    List<Agent> data;
    List<ImageIcon> icons;

    public GeneticCodeMenuData(ArrayList<GeneticCode> i){
       ArrayList<Agent> agents = new ArrayList<>();
        icons = new ArrayList<ImageIcon>();
        for(GeneticCode codes : i){
            agents.add(codes.getAgent());
            try {
                ImageIcon icon = new ImageIcon(ImageIO.read(new File("images/code.png")));
                icons.add(icon);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        data = agents;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == 1){
            Item item = data.get(rowIndex);
            return item.getName();
        }
        else {
            ImageIcon icon = icons.get(rowIndex);
            return icon;
        }
    }

    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case 0: return ImageIcon.class;
            default: return String.class;
        }
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