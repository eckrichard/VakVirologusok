package gui;

import javax.swing.*;
import java.awt.*;

public class ThrowbackMenu {
    public ThrowbackMenu(){
        init();
    }

    public void init(){
        JFrame throwback = new JFrame("Throback agent");
        throwback.setSize(250,150);
        final JPanel jPanel = new JPanel(new BorderLayout());
        final JPanel buttons = new JPanel(new GridLayout(0,2));
        jPanel.add(new JLabel("Do you want throwback the agent?"), BorderLayout.CENTER);
        JButton yes = new JButton("Yes");
        JButton no = new JButton("No");

        yes.addActionListener(e -> {
            // Visszadobja
        });

        no.addActionListener(e -> {
            // Nem dobja vissza
        });

        buttons.add(yes);
        buttons.add(no);

        jPanel.add(buttons, BorderLayout.PAGE_END);

        throwback.add(jPanel);
        throwback.setVisible(true);
    }
}
