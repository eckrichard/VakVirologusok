package gui;

import javax.swing.*;
import java.awt.*;

public class MainMenu {
    private JRadioButton rMap1;
    private JRadioButton rMap2;
    private JRadioButton rPlayers4;
    private JRadioButton rPlayers5;
    private JRadioButton rPlayers6;
    private JLabel lMapSelect;
    private JLabel lPlayerSelect;
    private JButton bStartGame;
    private JLabel lMap1;
    private JLabel lMap2;
    private MenuController menuController;

    public MainMenu(){
        init();
    }

    public void init(){
        JFrame newGame = new JFrame("New Game");
        newGame.setSize(300,500);
        JPanel jPanel = new JPanel(new BorderLayout());
        JPanel top = new JPanel(new BorderLayout());
        JPanel maps = new JPanel(new GridLayout(0,1));
        JPanel map1 = new JPanel(new BorderLayout());
        JPanel map2 = new JPanel(new BorderLayout());
        JPanel bottom = new JPanel(new BorderLayout());
        JPanel playres = new JPanel(new GridLayout(0,3));

        rMap1 = new JRadioButton("Map1");
        rMap2 = new JRadioButton("Map2");
        final ButtonGroup mapbuttons = new ButtonGroup();
        mapbuttons.add(rMap1);
        mapbuttons.add(rMap2);
        rMap1.setSelected(true);

        rPlayers4 = new JRadioButton("4 playres");
        rPlayers5 = new JRadioButton("5 playres");
        rPlayers6 = new JRadioButton("6 playres");
        final ButtonGroup playerbuttons = new ButtonGroup();
        playerbuttons.add(rPlayers4);
        playerbuttons.add(rPlayers5);
        playerbuttons.add(rPlayers6);
        rPlayers4.setSelected(true);

        lMap1 = new JLabel("Map1");
        lMap2 = new JLabel("Map2");
        lMapSelect = new JLabel("Map select");
        lPlayerSelect = new JLabel("Players count");

        bStartGame = new JButton("Start Game");
        bStartGame.addActionListener(e -> {
            // Elindítja a megfelelő paraméterezéssel az új játékot
        });

        map1.add(rMap1, BorderLayout.PAGE_START);
        map1.add(lMap1, BorderLayout.CENTER);

        map2.add(rMap2, BorderLayout.PAGE_START);
        map2.add(lMap2, BorderLayout.CENTER);

        maps.add(map1);
        maps.add(map2);

        top.add(lMapSelect, BorderLayout.PAGE_START);
        top.add(maps, BorderLayout.CENTER);

        playres.add(rPlayers4);
        playres.add(rPlayers5);
        playres.add(rPlayers6);

        bottom.add(lPlayerSelect, BorderLayout.PAGE_START);
        bottom.add(playres, BorderLayout.CENTER);
        bottom.add(bStartGame, BorderLayout.PAGE_END);

        jPanel.add(top, BorderLayout.CENTER);
        jPanel.add(bottom, BorderLayout.PAGE_END);
        newGame.add(jPanel);

        newGame.setVisible(true);
    }
}
