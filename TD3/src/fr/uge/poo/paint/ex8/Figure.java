package fr.uge.poo.paint.ex8;

import com.evilcorp.coolgraphics.CoolGraphics;
import fr.uge.poo.simplegraphics.SimpleGraphics;

import java.awt.*;

public sealed interface Figure permits Line, Ellipse, Rectangle {
    void draw(Canvas area, CanvasColor color);

    Point center();

    Point maxPoint();
}
