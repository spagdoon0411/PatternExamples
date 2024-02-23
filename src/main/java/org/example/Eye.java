package org.example;

import java.awt.*;
public class Eye extends DecoratedShape{
    private static final int offsetX = 20;
    private static final int offsetY = 20;
    private static final int radius = 20;

    private static final int eyeDist = 30;
    private Color color;

    DrawableShape baseShape;

    public Eye(DrawableShape baseShape) {
        super(baseShape);
        this.baseShape = baseShape;

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
    public void draw(Graphics g){
        baseShape.draw(g);

        if(getDrawableShape() != null){
            int absX = (int)getDrawableShape().getCoordinates().getX();
            int absY = (int)getDrawableShape().getCoordinates().getY();
            g.setColor(Color.WHITE);
            g.fillOval(absX+offsetX, absY+offsetY, radius, radius);
            g.setColor(color);
            g.fillOval(absX+offsetX+radius/4, absY+offsetY+radius/4, radius/2, radius/2);

            g.setColor(Color.WHITE);
            g.fillOval(absX+eyeDist+offsetX, absY+offsetY, radius, radius);
            g.setColor(color);
            g.fillOval(absX+offsetX+eyeDist+radius/4, absY+offsetY+radius/4, radius/2, radius/2);
        }
        else{
            System.err.println("Disembodied eye, ouch");
        }
    }

    @Override
    public Point getCoordinates(){
        int totalX = (int)getDrawableShape().getCoordinates().getX()+offsetX;
        int totalY = (int)getDrawableShape().getCoordinates().getY()+offsetY;
        return new Point(totalX, totalY);
    }
}
