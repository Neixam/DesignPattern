package fr.uge.poo.paint.ex5;

import java.awt.*;

public record Rectangle(int x, int y, int width, int height) implements Figure {
    @Override
    public void draw(Graphics2D graphics, Color color) {
        graphics.setColor(color);
        graphics.drawRect(x, y, width, height);
    }

    @Override
    public Point center() {
        return new Point(x + width / 2, y + height / 2);
    }
}
