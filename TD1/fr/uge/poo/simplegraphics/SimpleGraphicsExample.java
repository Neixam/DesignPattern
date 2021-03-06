package fr.uge.poo.simplegraphics;



import java.awt.Color;
import java.awt.Graphics2D;

public class SimpleGraphicsExample {
    private static void drawAll(Graphics2D graphics) {
        graphics.setColor(Color.BLACK);
        graphics.drawRect(100, 20, 40, 140);
        graphics.setColor(Color.RED);
        graphics.drawLine(100, 20, 140, 160);
        graphics.setColor(Color.GREEN);
        graphics.drawLine(100, 160, 140, 20);
        graphics.setColor(Color.PINK);
        graphics.drawOval(100, 20, 40, 140);
    }

    public static void main(String[] args) {
        SimpleGraphics area = new SimpleGraphics("area", 800, 600);
        area.clear(Color.WHITE);
        area.render(SimpleGraphicsExample::drawAll);
        //canvas.render(graphics -> drawAll(graphics));
    }
}
