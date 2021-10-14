package fr.uge.poo.paint.ex7;

import com.evilcorp.coolgraphics.CoolGraphics;
import fr.uge.poo.simplegraphics.SimpleGraphics;

import java.awt.*;

public record Ellipse(int x, int y, int width, int height) implements Figure {
    @Override
    public void draw(SimpleGraphics area, Color color) {
        area.render(g -> {
            g.setColor(color);
            g.drawOval(x, y, width, height);
        });
    }

    @Override
    public void draw(CoolGraphics area, CoolGraphics.ColorPlus color) {
        area.drawEllipse(x, y, width, height, color);
    }

    @Override
    public Point center() {
        return new Point(x + width / 2, y + height / 2);
    }

    @Override
    public Point maxPoint() {
        return new Point(x + width, y + height);
    }
}
