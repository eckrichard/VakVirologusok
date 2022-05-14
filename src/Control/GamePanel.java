package Control;

import Model.Tile;
import View.TileView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {
//    private GameControl gameControl;
//    public void run(){}
//    public void paintComponents(Graphics g){}
    private Game game;
    private ArrayList<TileView> tileViews = new ArrayList<>();

    public GamePanel(Game _game) {
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(1000, 700));
        this.setFocusable(true);
        this.setLayout(null);
        this.requestFocusInWindow();
        this.game = _game;
        for(int i = 0; i < game.getMap().getTiles().size(); i++) {
            TileView tmp = new TileView(game.getMap().getTile(i));
            tileViews.add(tmp);
        }

        this.requestFocusInWindow();
    }

    public void draw() {
        //this.grabFocus();
        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < tileViews.size(); i++) {
            tileViews.get(i).draw(g);
        }
    }
}
