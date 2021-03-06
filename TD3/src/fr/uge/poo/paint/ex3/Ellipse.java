package fr.uge.poo.paint.ex3;

import java.awt.*;

public record Ellipse(int x, int y, int width, int height) implements Figure {
    @Override
    public void draw(Graphics2D graphics) {
        graphics.setColor(Color.BLACK);
        graphics.drawOval(x, y, width, height);
    }
}
