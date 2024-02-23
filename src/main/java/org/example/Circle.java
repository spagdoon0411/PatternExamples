package org.example;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle implements DrawableShape {

    private Ellipse2D.Double circle;

    private Color color;

    private Point coords;

    public Circle(double x, double y, double diam){
        this.coords = new Point((int)x, (int)y);
        this.circle = new Ellipse2D.Double(x, y, diam, diam);

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
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        if(color != null)
            g2d.setColor(color);
        g2d.fill(this.circle);
    }

    public Point getCoordinates() {
        return this.coords;
    }
}
