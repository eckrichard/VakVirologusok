package View;

import java.awt.*;

import Model.Tile;

public class TileView extends Drawable{
    private Color color;
    private int sides;
    private Tile tile;

    public TileView(Color color, Tile tile) {
        this.color = color;
        this.tile = tile;
    }

    public void draw(Graphics g){
        g.setColor(color);
        g.fillPolygon(tile.getPointsX(), tile.getPointsY(), tile.getN());
    }
}
