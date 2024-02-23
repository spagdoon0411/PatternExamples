package org.example;

import java.awt.*;

public abstract class DecoratedShape implements DrawableShape{
    private DrawableShape drawableShape;
    public DecoratedShape(DrawableShape baseShape){
        this.drawableShape = baseShape;
    }
    public abstract void draw(Graphics g);
    public DrawableShape getDrawableShape(){
        return drawableShape;
    }
}
