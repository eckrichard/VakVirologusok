package gui;

import main.Virologist;

import javax.swing.*;
import java.awt.*;

public class GeneticCodesMenu {
    private JOptionPane jPopup;
    private JLabel lCodes;
    private JPanel pCodes;
    private MenuController menuController;
    private Virologist virologist;

    public GeneticCodesMenu(Virologist virologist) {
        this.virologist = virologist;
        init();
    }

    public void init(){
        JFrame geneteicCodes = new JFrame("Genteic Codes");
        geneteicCodes.setSize(new Dimension(300, 500));
        final JPanel jPanel = new JPanel(new BorderLayout());
        final JPanel jEmptyLeft = new JPanel();
        final JPanel jEmptyRight = new JPanel();
        final JPanel jEmptyBottom = new JPanel();
        pCodes = new JPanel();
        // Csak, hogy látszódjon
        pCodes.setBackground(Color.BLACK);
        lCodes = new JLabel("Codes");

        geneteicCodes.add(jPanel);
        jPanel.add(lCodes, BorderLayout.PAGE_START);
        jPanel.add(pCodes, BorderLayout.CENTER);
        jPanel.add(jEmptyLeft, BorderLayout.LINE_START);
        jPanel.add(jEmptyRight, BorderLayout.LINE_END);
        jPanel.add(jEmptyBottom, BorderLayout.PAGE_END);

        geneteicCodes.setVisible(true);
    }
}
