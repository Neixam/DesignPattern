package fr.uge.poo.paint.ex8;

public record Rectangle(int x, int y, int width, int height) implements Figure {

    @Override
    public void draw(Canvas area, CanvasColor color) {
        area.drawRect(x, y, width, height, color);
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
