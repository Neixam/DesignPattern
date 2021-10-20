package fr.uge.poo.paint.ex9;

public sealed interface Figure permits Line, Ellipse, Rectangle {
    void draw(Canvas area, CanvasColor color);

    Point center();

    Point maxPoint();
}
