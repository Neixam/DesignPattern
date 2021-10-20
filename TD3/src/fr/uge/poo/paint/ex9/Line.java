package fr.uge.poo.paint.ex9;

public record Line(int x1, int y1, int x2, int y2) implements Figure {
    @Override
    public void draw(Canvas area, CanvasColor color) {
        area.drawLine(x1, y1, x2, y2, color);
    }

    @Override
    public Point center() {
        return new Point(x1 + x2 / 2, y1 + y2 / 2);
    }

    @Override
    public Point maxPoint() {
        return new Point((x2 >= x1) ? x2 : x1, (y2 >= y1) ? y2 : y1);
    }
}
