package fr.uge.poo.paint.ex5;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Figures {
    private final List<Figure> figures = new ArrayList<>();

    public void add(String typeElem, Integer[] args) {
        Figure figure;
        if (typeElem.equals("line")) {
            figure = new Line(args[0], args[1], args[2], args[3]);
        } else if (typeElem.equals("ellipse")) {
            figure = new Ellipse(args[0], args[1], args[2], args[3]);
        } else if (typeElem.equals("rectangle")) {
            figure = new Rectangle(args[0], args[1], args[2], args[3]);
        } else {
            throw new IllegalArgumentException(typeElem + " is not a valid object");
        }
        figures.add(figure);
    }

    public Figure closeFigure(Point use) {
        Figure ret = null;

        for (Figure f : figures) {
            if (ret == null || ret.center().distance(use) > f.center().distance(use)) {
                ret = f;
            }
        }
        return ret;
    }

    public void drawAll(Graphics2D graphics) {
        figures.forEach(f -> f.draw(graphics, Color.BLACK));
    }
}
