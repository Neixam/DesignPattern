package fr.uge.poo.paint.ex4;

import java.awt.*;

public sealed interface Figure permits Line, Ellipse, Rectangle {
    void draw(Graphics2D graphics);

    Point center();
}
