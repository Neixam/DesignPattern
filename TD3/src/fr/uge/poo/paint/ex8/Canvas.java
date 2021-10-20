package fr.uge.poo.paint.ex8;


public interface Canvas {
    void drawEllipse(int x, int y, int width, int height, CanvasColor color);

    void drawRect(int x, int y, int width, int height, CanvasColor color);

    void drawLine(int x1, int y1, int x2, int y2, CanvasColor color);

    void setArea(String name, int width, int height);

    void clear(CanvasColor color);

    void mouseWait(Callback callback);
}
