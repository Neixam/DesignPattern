package fr.uge.poo.paint.ex6;

import java.awt.*;

public record Ellipse(int x, int y, int width, int height) implements Figure {
    @Override
    public void draw(Graphics2D graphics, Color color) {
        graphics.setColor(color);
        graphics.drawOval(x, y, width, height);
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
