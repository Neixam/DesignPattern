package fr.uge.poo.paint.ex7;

import com.evilcorp.coolgraphics.CoolGraphics;
import fr.uge.poo.simplegraphics.SimpleGraphics;

import java.awt.*;

public sealed interface Figure permits Line, Ellipse, Rectangle {
    void draw(SimpleGraphics area, Color color);

    void draw(CoolGraphics area, CoolGraphics.ColorPlus color);

    Point center();

    Point maxPoint();
}
