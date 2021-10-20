package fr.uge.poo.paint.ex7;

public record Point(double x, double y) {
    double distance(Point p) {
        return (x - p.x()) * (x - p.x()) + (y - p.y()) * (y - p.y());
    }
}
