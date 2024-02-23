package org.example;

import java.beans.PropertyChangeSupport;
import java.util.List;
import java.util.ArrayList;

/**
 * Holds RectangularShape-type shapes and signals updates to observers upon
 * tge addition of a new shape.
 */
public class Repository extends PropertyChangeSupport{
    private static Repository instance = null;
    private List<DrawableShape> shapes;

    private Repository(){
        super(new Object());
        shapes = new ArrayList<>();
    }

    /**
     * @return A reference to the singleton repository, to be used
     * in observers, etc.
     */
    public static Repository getInstance(){
        if(instance == null){
            instance = new Repository();
        }
        return instance;
    }

    public List<DrawableShape> getShapes(){
        return shapes;
    }

    public void addShape(DrawableShape s){
        shapes.add(s);
        firePropertyChange("addShape", shapes, null);
    }
}
