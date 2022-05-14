package Control;

import Model.Tile;
import Model.Virologist;
import View.TileView;
import View.VirologistView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import static javax.swing.text.StyleConstants.getBackground;

public class GamePanel extends JPanel {
//    private GameControl gameControl;
//    public void run(){}
//    public void paintComponents(Graphics g){}
    private Game game;
    private ArrayList<TileView> tileViews = new ArrayList<>();
    private ArrayList<VirologistView> virologistViews = new ArrayList<>();

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
        for(int i = 0; i < game.getMap().getVirologists().size(); i++) {
            Virologist virologist = game.getMap().getVirologists().get(i);
            Tile tile = virologist.getTile();
            Polygon polygon = new Polygon(tile.getPointsX(), tile.getPointsY(), tile.getN());
            int xcenter,ycenter;
            int pX[]=tile.getPointsX();
            int pY[]=tile.getPointsY();
            xcenter=(getMaxValue(pX)+getMinValue(pX))/2;
            ycenter=(getMaxValue(pY)+getMinValue(pY))/2;
            VirologistView tmp = new VirologistView();
            Point po =new Point(xcenter,ycenter);
            tmp.setCoordinates(po);
            virologistViews.add(tmp);
        }
        addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                Point p = e.getPoint();
                int activeVirologist = game.getActive();
                Tile virologistOnTile = game.getMap().getVirologists().get(activeVirologist).getTile();
                ArrayList<Tile> adjacentTiles = virologistOnTile.getAdjacentTiles();
                for( Tile tile : adjacentTiles) {
                    int[] xpoints = tile.getPointsX();
                    int[] ypoints = tile.getPointsY();
                    int npoints = tile.getN();
                    Polygon poly = new Polygon(xpoints,ypoints,npoints);
                    if(poly.contains(p)) {
                        virologistViews.get(activeVirologist).setCoordinates(p);
                    }
                }
            }

        });
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
        for (int i = 0; i < virologistViews.size(); i++) {
            virologistViews.get(i).draw(g);
        }
    }

    public static int getMaxValue(int[] numbers){
        int maxValue = numbers[0];
        for(int i=1;i < numbers.length;i++){
            if(numbers[i] > maxValue){
                maxValue = numbers[i];
            }
        }
        return maxValue;
    }
    public static int getMinValue(int[] numbers){
        int minValue = numbers[0];
        for(int i=1;i<numbers.length;i++){
            if(numbers[i] < minValue){
                minValue = numbers[i];
            }
        }
        return minValue;
    }
}
