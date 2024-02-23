package org.example;

/**
 * When run in a thread, places a new random box every second in
 * Repository.
 */
public class BoxBuilder extends ShapeBuilder {

    /**
     * @param screenX Width of box placement region
     * @param screenY Height of box placement region
     * @param maxSize Maximum random box size
     * @param minSize Minimum random box size
     */
    public BoxBuilder(int screenX, int screenY, int maxSize, int minSize){
        super(screenX, screenY, maxSize, minSize);
    }

    @Override
    public DrawableShape makeShape() {
        double randX = screenX*Math.random();
        double randY = screenY*Math.random();
        double randD = minSize + (maxSize-minSize)*Math.random();

        return new Box(randX, randY, randD, null);
    }
}

