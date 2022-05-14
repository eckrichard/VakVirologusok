package View;

import java.awt.*;

import Model.Virologist;

public class VirologistView extends Drawable{
    private Color color;
    private Virologist virologist;
    private double x;
    private double y;
    public void setCoordinates(Point p) {
        this.x = p.getX();
        this.y = p.getY();
    }
    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.fillOval((int)this.x,(int)this.y,50,50);
    }
}
