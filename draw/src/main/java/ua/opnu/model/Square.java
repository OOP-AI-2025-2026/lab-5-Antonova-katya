package ua.opnu.model;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Square extends DrawShape {

    public Square() {
    }

    public Square(Point startPoint, Point endPoint) {
        super(startPoint, endPoint);
    }

    @Override
    public Shape getShape(Point startPoint, Point endPoint) {
        double x = Math.min(startPoint.getX(), endPoint.getX());
        double y = Math.min(startPoint.getY(), endPoint.getY());

        // Щоб це був квадрат, ширина і висота мають бути однаковими.
        double width = Math.abs(startPoint.getX() - endPoint.getX());
        double height = Math.abs(startPoint.getY() - endPoint.getY());
        double side = Math.max(width, height);
        return new Rectangle2D.Double(x, y, side, side);
    }
}