package Control;

import Model.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GameMenu implements ActionListener {
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
    private JPanel virologistout;
    private JFrame fGame;
    private MenuController menuController;
    private Game game;

    public GameMenu(Game game){
        this.game = game;
        init();
    }

    public JFrame getFrame() {
        return fGame;
    }

    public void init(){
        fGame = new JFrame("VakVirologusok");
        fGame.setSize(new Dimension(1280,720));

        final JMenuBar jMenuBar = new JMenuBar();
        JMenu gameMenu = new JMenu("Game");
        JMenuItem newGame = new JMenuItem("New Game", KeyEvent.VK_P);
        newGame.addActionListener(e -> {
            MainMenu mainMenu = new MainMenu(game, this);
        });
        gameMenu.add(newGame);
        jMenuBar.add(gameMenu);
        fGame.setJMenuBar(jMenuBar);

        JPanel table = new JPanel();
        table.setBackground(Color.BLACK);
        fGame.add(table, BorderLayout.CENTER);
        JPanel rightSide = new JPanel(new GridLayout(0,1));
        JPanel buttons = new JPanel(new GridLayout(0,1));
        lBag = new JLabel("Open Bag");
        bBag = new JButton("Bag");
        bBag.addActionListener(e -> {
            BagMenu Bagmenu = new BagMenu(game.getMap().getVirologists().get(game.getActive()).getBag());
        });

        lGeneticCodes = new JLabel("Open Genteic Codes");
        bGeneticCodes = new JButton("Genteic Codes");
        bGeneticCodes.addActionListener(e -> {
            GeneticCodesMenu GCmenu = new GeneticCodesMenu(game.getMap().getVirologists().get(game.getActive()));
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
        bEndTurn.setActionCommand("endturn");
        bEndTurn.addActionListener(this);

        lVirologistStats = new JLabel("Virologist stats:");
        pVirologistStats = new JPanel(new BorderLayout());
        virologistout = initStats();

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
        fGame.add(rightPanel, BorderLayout.LINE_END);

        fGame.setVisible(true);
        fGame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JPanel initStats(){
        JPanel virologistout = new JPanel(new GridLayout(0,2));
        virologistout.add(new JLabel("Code count: "));
        virologistout.add(new JLabel(String.valueOf(game.getMap().getVirologists().get(game.getActive()).getCodeCount())));
        virologistout.add(new JLabel("Agent resistance: "));
        virologistout.add(new JLabel(String.valueOf(game.getMap().getVirologists().get(game.getActive()).getAgentResistance())));
        virologistout.add(new JLabel("Throwback available: "));
        virologistout.add(new JLabel(String.valueOf(game.getMap().getVirologists().get(game.getActive()).isThrowBackAvailable())));
        virologistout.add(new JLabel("Effects count:"));
        virologistout.add(new JLabel(String.valueOf(game.getMap().getVirologists().get(game.getActive()).getEffects().size())));
        virologistout.add(new JLabel("Bag size: "));
        virologistout.add(new JLabel(String.valueOf(game.getMap().getVirologists().get(game.getActive()).getBag().getSize()) +
                " / " + String.valueOf(game.getMap().getVirologists().get(game.getActive()).getBag().getUsedSize())));
        virologistout.add(new JLabel("Untouchable: "));
        virologistout.add(new JLabel(String.valueOf(game.getMap().getVirologists().get(game.getActive()).getUntouchable())));
        return virologistout;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("endturn"))
        {
            game.setActive();
            pVirologistStats.remove(virologistout);
            virologistout = initStats();
            pVirologistStats.add(virologistout);
            pVirologistStats.revalidate();
            pVirologistStats.repaint();
        }
    }
}
