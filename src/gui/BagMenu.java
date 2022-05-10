package gui;

import javax.swing.*;
import java.awt.*;

public class BagMenu {
    private JOptionPane jPopup;
    private JLabel lAgent;
    private JLabel lProtectiveGears;
    private JLabel lMaterials;
    private JPanel pAgent;
    private JPanel pProtectiveGears;
    private JPanel pMaterials;
    private MenuController menuController;

    public BagMenu(){
        init();
    }

    public void init(){
        JFrame bag = new JFrame("Bag");
        bag.setSize(new Dimension(400, 500));
        final JPanel jPanel = new JPanel(new BorderLayout());
        final JPanel grid = new JPanel(new GridLayout(0,1));
        final JPanel jEmptyLeft = new JPanel();
        final JPanel jEmptyRight = new JPanel();
        final JPanel jEmptyBottom = new JPanel();
        final JPanel jEmptyTop = new JPanel();
        pAgent = new JPanel();
        JPanel agent = new JPanel(new BorderLayout());
        pProtectiveGears = new JPanel();
        JPanel gear = new JPanel(new BorderLayout());
        pMaterials = new JPanel();
        JPanel material = new JPanel(new BorderLayout());
        // Csak, hogy látszódjon
        pAgent.setBackground(Color.RED);
        pProtectiveGears.setBackground(Color.WHITE);
        pMaterials.setBackground(Color.GREEN);

        lAgent = new JLabel("Agents");
        lProtectiveGears = new JLabel("Protecive gears");
        lMaterials = new JLabel("Materials");

        bag.add(jPanel);
        jPanel.add(grid);
        grid.add(agent);
        grid.add(gear);
        grid.add(material);
        agent.add(lAgent, BorderLayout.PAGE_START);
        agent.add(pAgent, BorderLayout.CENTER);
        gear.add(lProtectiveGears, BorderLayout.PAGE_START);
        gear.add(pProtectiveGears, BorderLayout.CENTER);
        material.add(lMaterials, BorderLayout.PAGE_START);
        material.add(pMaterials, BorderLayout.CENTER);
        jPanel.add(jEmptyLeft, BorderLayout.LINE_START);
        jPanel.add(jEmptyRight, BorderLayout.LINE_END);
        jPanel.add(jEmptyBottom, BorderLayout.PAGE_END);
        jPanel.add(jEmptyTop, BorderLayout.PAGE_START);

        bag.setVisible(true);
    }
}
