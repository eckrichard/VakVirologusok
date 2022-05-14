package Control;

import Model.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BagMenuData extends AbstractTableModel {

    List<Item> data;
    List<ImageIcon> icons;

    public BagMenuData(ArrayList<Item> i){
        data = i;
        icons = new ArrayList<ImageIcon>();
        for(Item item : data){
            if(item instanceof Axe){
                try {
                    ImageIcon icon = new ImageIcon(ImageIO.read(new File("images/axe.png")));
                    icons.add(icon);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if(item instanceof Cape){
                try {
                    ImageIcon icon = new ImageIcon(ImageIO.read(new File("images/cape.png")));
                    icons.add(icon);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if(item instanceof BonusBag){
                try {
                    ImageIcon icon = new ImageIcon(ImageIO.read(new File("images/bag.png")));
                    icons.add(icon);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if(item instanceof Glove){
                try {
                    ImageIcon icon = new ImageIcon(ImageIO.read(new File("images/gloves.png")));
                    icons.add(icon);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if(item instanceof Agent){
                try {
                    ImageIcon icon = new ImageIcon(ImageIO.read(new File("images/cream.png")));
                    icons.add(icon);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if(item instanceof Material){
                if(item.getName().equalsIgnoreCase("Valin") ||
                        item.getName().equalsIgnoreCase("Szerin") ||
                        item.getName().equalsIgnoreCase("tdp") ||
                        item.getName().equalsIgnoreCase("Timidin-difoszfát")) {
                    try {
                        ImageIcon icon = new ImageIcon(ImageIO.read(new File("images/amino-acids.png")));
                        icons.add(icon);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    try {
                        ImageIcon icon = new ImageIcon(ImageIO.read(new File("images/material.png")));
                        icons.add(icon);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
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
