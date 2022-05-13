package Control;

import javax.swing.*;
import java.awt.*;

public class WearMenu {
    private JOptionPane jPopup;
    private JLabel lProtectiveGears;
    private JPanel pProtectiveGears;
    private MenuController menuController;

    public WearMenu(){
        init();
    }

    public void init(){
        JFrame wearmenu = new JFrame("Wear");
        wearmenu.setSize(new Dimension(300, 300));
        final JPanel jPanel = new JPanel(new BorderLayout());
        final JPanel jEmptyLeft = new JPanel();
        final JPanel jEmptyRight = new JPanel();
        final JPanel jEmptyBottom = new JPanel();
        pProtectiveGears = new JPanel();
        // Csak, hogy látszódjon
        pProtectiveGears.setBackground(Color.BLACK);
        lProtectiveGears = new JLabel("Protective gears");

        wearmenu.add(jPanel);
        jPanel.add(lProtectiveGears, BorderLayout.PAGE_START);
        jPanel.add(pProtectiveGears, BorderLayout.CENTER);
        jPanel.add(jEmptyLeft, BorderLayout.LINE_START);
        jPanel.add(jEmptyRight, BorderLayout.LINE_END);
        jPanel.add(jEmptyBottom, BorderLayout.PAGE_END);

        wearmenu.setVisible(true);
    }
}
