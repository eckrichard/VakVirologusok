package Control;

import View.TileView;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
//    private GameControl gameControl;
//    public void run(){}
//    public void paintComponents(Graphics g){}
    private Game game;
    private TileView tileView;

    public GamePanel(Game _game) {
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(1000, 700));
        this.setFocusable(true);
        this.setLayout(null);
        this.requestFocusInWindow();
        this.game = _game;
        tileView = new TileView(Color.cyan, game.getMap().getTile(0));

        this.requestFocusInWindow();
    }

    public void Draw() {
        //this.grabFocus();
        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        tileView.draw(g);
    }
}
