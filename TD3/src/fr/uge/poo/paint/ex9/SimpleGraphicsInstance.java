package fr.uge.poo.paint.ex9;

import fr.uge.poo.simplegraphics.SimpleGraphics;

import java.awt.*;
import java.util.Objects;
import java.util.function.Consumer;

public class SimpleGraphicsInstance implements Canvas {
    private SimpleGraphics area;
    private Consumer<Graphics2D> render = (g) -> {} ;

    @Override
    public void drawEllipse(int x, int y, int width, int height, CanvasColor color) {
        render = (g) -> {
            render.accept(g);
            g.setColor(color.toColor());
            g.drawOval(x, y, width, height);
        };
    }

    @Override
    public void drawRect(int x, int y, int width, int height, CanvasColor color) {
        render = (g) -> {
            render.accept(g);
            g.setColor(color.toColor());
            g.drawRect(x, y, width, height);
        };
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2, CanvasColor color) {
        render = (g) -> {
            render.accept(g);
            g.setColor(color.toColor());
            g.drawLine(x1, y1, x2, y2);
        };
    }


    @Override
    public void setArea(String name, int width, int height) {
        if (width <= 0)
            throw new IllegalStateException("width >= 1");
        if (height <= 0)
            throw new IllegalStateException("height >= 1");
        area = new SimpleGraphics(Objects.requireNonNull(name), width, height);
    }

    @Override
    public void clear(CanvasColor color) {
        area.clear(color.toColor());
    }

    @Override
    public void mouseWait(Callback callback) {
        area.waitForMouseEvents(callback::callback);
    }

    @Override
    public void actualise() {
        area.render(render);
    }
}
