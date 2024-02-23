package org.example;

import java.awt.geom.RectangularShape;

public abstract class ShapeBuilder implements Runnable{
    protected int screenX, screenY, maxSize, minSize;

    /**
     * @param screenX Width of shape placement region
     * @param screenY Height of shape placement region
     * @param maxSize Maximum random shape size
     * @param minSize Minimum random shape size
     */
    public ShapeBuilder(int screenX, int screenY, int maxSize, int minSize){
        this.screenX = screenX;
        this.screenY = screenY;
        this.maxSize = maxSize;
        this.minSize = minSize;
    }

    /**
     * Implemented by children to define how to construct
     * the RectangularShape that the builder class is meant
     * to add to the repository.
     *
     * @return The shape to be added.
     */
    protected abstract DrawableShape makeShape();

    /**
     * Adds a shape using makeShape every second.
     */
    @Override
    public void run(){
        while(true){
            DrawableShape ds = this.makeShape();
            DrawableShape decShape = ds;

            if(Math.random()<0.5){
                decShape = new Eye(ds);
            }
            Repository.getInstance().addShape(decShape);
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                System.err.println("Shape builder thread interrupted");
            }
        }
    }
}
