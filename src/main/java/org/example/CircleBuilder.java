package org.example;

import java.awt.geom.Ellipse2D;
import java.awt.geom.RectangularShape;

/**
 * When run in a thread, places a new random circle every second in
 * Repository.
 */
public class CircleBuilder extends ShapeBuilder {

    /**
     * @param screenX Width of circle placement region
     * @param screenY Height of circle placement region
     * @param maxSize Maximum random circle size
     * @param minSize Minimum random circle size
     */
    public CircleBuilder(int screenX, int screenY, int maxSize, int minSize) {
        super(screenX, screenY, maxSize, minSize);
    }

    @Override
    protected DrawableShape makeShape() {
        double randX = screenX*Math.random();
        double randY = screenY*Math.random();
        double randD = minSize + (maxSize-minSize)*Math.random();
        return new Circle(randX, randY, randD);
    }
}
