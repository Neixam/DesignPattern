package fr.uge.poo.paint.ex5;

import java.awt.*;

public sealed interface Figure permits Line, Ellipse, Rectangle {
    void draw(Graphics2D graphics, Color color);

    Point center();
}
