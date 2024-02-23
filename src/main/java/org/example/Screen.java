package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RectangularShape;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Screen extends JPanel implements PropertyChangeListener {

    Repository repo;

    public Screen() {
        this.repo = Repository.getInstance();
    }

    private void drawShape(RectangularShape shape, Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.draw(shape);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.repo.getShapes().forEach(s -> s.draw(g));
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.repaint();
    }
}
