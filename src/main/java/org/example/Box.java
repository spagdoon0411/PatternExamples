package org.example;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Box implements DrawableShape {

    private Rectangle2D.Double rectangle;
    private Color color;

    private Point coords;

    public Box(double x, double y, double length, Color Color){
        rectangle = new Rectangle2D.Double(x, y, length, length);
        this.coords = new Point((int)x, (int)y);
        switch((int)(Math.random()*6)){
            case 0:
                color = Color.RED;
                break;
            case 1:
                color = Color.BLUE;
                break;
            case 2:
                color = Color.GREEN;
                break;
            case 3:
                color = Color.GRAY;
                break;
            case 4:
                color = Color.ORANGE;
                break;
            default:
                color = Color.MAGENTA;
                break;
        }
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        if(color != null)
            g2d.setColor(color);
        g2d.fill(this.rectangle);

    }

    @Override
    public Point getCoordinates() {
        return this.coords;
    }



}
