package ua.opnu.model;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle extends DrawShape {

    public Circle() {
    }

    public Circle(Point startPoint, Point endPoint) {
        super(startPoint, endPoint);
    }

    @Override
    public Shape getShape(Point startPoint, Point endPoint) {
        double x = Math.min(startPoint.getX(), endPoint.getX());
        double y = Math.min(startPoint.getY(), endPoint.getY());

        // Логіка аналогічна до квадрата, щоб отримати ідеальне коло
        double width = Math.abs(startPoint.getX() - endPoint.getX());
        double height = Math.abs(startPoint.getY() - endPoint.getY());
        double diameter = Math.max(width, height);
        return new Ellipse2D.Double(x, y, diameter, diameter);
    }
}
