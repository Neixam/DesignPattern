package fr.uge.poo.paint.ex8;

import com.evilcorp.coolgraphics.CoolGraphics;

import java.util.Objects;

public class CoolGraphicsInstance implements Canvas {
    private CoolGraphics area;

    public void setArea(String name, int width, int height) {
        if (width <= 0)
            throw new IllegalStateException("width >= 1");
        if (height <= 0)
            throw new IllegalStateException("height >= 1");
        area = new CoolGraphics(Objects.requireNonNull(name), width, height);
    }

    @Override
    public void drawEllipse(int x, int y, int width, int height, CanvasColor color) {
        area.drawEllipse(x, y, width, height, color.toColorPlus());
    }

    @Override
    public void drawRect(int x, int y, int width, int height, CanvasColor color) {
        area.drawLine(x, y, x + width, y, color.toColorPlus());
        area.drawLine(x, y + height, x + width, y + height, color.toColorPlus());
        area.drawLine(x, y, x, y + height, color.toColorPlus());
        area.drawLine(x + width, y, x + width, y + height, color.toColorPlus());
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2, CanvasColor color) {
        area.drawLine(x1, y1, x2, y2, color.toColorPlus());
    }

    @Override
    public void clear(CanvasColor color) {
        area.repaint(color.toColorPlus());
    }

    @Override
    public void mouseWait(Callback callback) {
        area.waitForMouseEvents(callback::callback);
    }
}