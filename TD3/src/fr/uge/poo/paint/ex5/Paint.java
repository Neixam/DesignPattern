package fr.uge.poo.paint.ex5;

import fr.uge.poo.simplegraphics.SimpleGraphics;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class Paint {
    public static Figures parser(String file) {
        Path path = Paths.get(file);
        Figures figures = new Figures();
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(s -> {
                String[] tokens = s.split(" ");
                Integer[] val = Arrays.stream(tokens).flatMap(s2 -> {
                    if (s2.matches("[0-9]+"))
                        return Stream.of(Integer.parseInt(s2));
                    return Stream.empty();
                }).toArray(Integer[]::new);
                figures.add(tokens[0], val);
            });
            return figures;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        if (args.length >= 1) {
            SimpleGraphics area = new SimpleGraphics("area", 800, 600);
            area.clear(Color.WHITE);
            var figures = parser(args[0]);
            area.render(figures::drawAll);
            area.waitForMouseEvents((x, y) -> {
                area.clear(Color.WHITE);
                Figure f = figures.closeFigure(new Point(x, y));
                area.render(g -> {
                    figures.drawAll(g);
                    f.draw(g, Color.ORANGE);
                });
            });
        }
    }
}
