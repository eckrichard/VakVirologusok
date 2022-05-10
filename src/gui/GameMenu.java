package gui;

import main.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GameMenu {
    private JButton bBag;
    private JButton bGeneticCodes;
    private JButton bCollect;
    private JButton bWear;
    private JButton bEndTurn;
    private JLabel lBag;
    private JLabel lGeneticCodes;
    private JLabel lCollect;
    private JLabel lWear;
    private JLabel lVirologistStats;
    private JPanel pVirologistStats;
    private MenuController menuController;
    private Map map;

    public GameMenu(){
        init();
    }

    public void init(){
        JFrame game = new JFrame("VakVirologusok");
        game.setSize(new Dimension(1280,720));

        final JMenuBar jMenuBar = new JMenuBar();
        JMenu gamemenu = new JMenu("Game");
        JMenuItem newgame = new JMenuItem("New Game", KeyEvent.VK_P);
        newgame.addActionListener(e -> {
            MainMenu mainMenu = new MainMenu();
        });
        gamemenu.add(newgame);
        jMenuBar.add(gamemenu);
        game.setJMenuBar(jMenuBar);

        JPanel table = new JPanel();
        table.setBackground(Color.BLACK);
        game.add(table, BorderLayout.CENTER);
        JPanel rightSide = new JPanel(new GridLayout(0,1));
        JPanel buttons = new JPanel(new GridLayout(0,1));
        lBag = new JLabel("Open Bag");
        bBag = new JButton("Bag");
        bBag.addActionListener(e -> {
            BagMenu Bagmenu = new BagMenu();
        });

        lGeneticCodes = new JLabel("Open Genteic Codes");
        bGeneticCodes = new JButton("Genteic Codes");
        bGeneticCodes.addActionListener(e -> {
            GeneticCodesMenu GCmenu = new GeneticCodesMenu();
        });

        lCollect = new JLabel("Collect collectable");
        bCollect = new JButton("Collect");
        bCollect.addActionListener(e -> {
            // Majd meghívja a virológus mezőjének a getCollectable-t
        });

        lWear = new JLabel("Open wear");
        bWear = new JButton("Wear");
        bWear.addActionListener(e -> {
            WearMenu Waarmenu = new WearMenu();
        });

        bEndTurn = new JButton("End Turn");
        bEndTurn.addActionListener(e -> {
            // Majd a következő virológusra vált
        });

        lVirologistStats = new JLabel("Virologist stats:");
        pVirologistStats = new JPanel(new BorderLayout());
        JPanel virologistout = new JPanel(new GridLayout(0,2));
        virologistout.add(new JLabel("Code count: "));
        virologistout.add(new JLabel("szam"));
        virologistout.add(new JLabel("Agent resistance: "));
        virologistout.add(new JLabel("szam"));
        virologistout.add(new JLabel("Throwback available: "));
        virologistout.add(new JLabel("true/false"));
        virologistout.add(new JLabel("Effects count:"));
        virologistout.add(new JLabel("szam"));
        virologistout.add(new JLabel("Bag size: "));
        virologistout.add(new JLabel("max/jelenlegi"));
        virologistout.add(new JLabel("Untouchable: "));
        virologistout.add(new JLabel("true/false"));

        buttons.add(lBag);
        buttons.add(bBag);
        buttons.add(lGeneticCodes);
        buttons.add(bGeneticCodes);
        buttons.add(lCollect);
        buttons.add(bCollect);
        buttons.add(lWear);
        buttons.add(bWear);
        buttons.add(new JLabel(""));
        buttons.add(bEndTurn);
        rightSide.add(buttons);

        pVirologistStats.add(lVirologistStats, BorderLayout.PAGE_START);
        pVirologistStats.add(virologistout, BorderLayout.CENTER);
        rightSide.add(pVirologistStats);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(rightSide, BorderLayout.CENTER);
        rightPanel.add(new JPanel(), BorderLayout.PAGE_END);
        rightPanel.add(new JPanel(), BorderLayout.PAGE_START);
        rightPanel.add(new JPanel(), BorderLayout.LINE_START);
        rightPanel.add(new JPanel(), BorderLayout.LINE_END);
        game.add(rightPanel, BorderLayout.LINE_END);

        game.setVisible(true);
        game.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
