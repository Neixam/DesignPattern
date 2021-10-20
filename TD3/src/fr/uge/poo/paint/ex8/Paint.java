package fr.uge.poo.paint.ex8;

import com.evilcorp.coolgraphics.CoolGraphics;
import fr.uge.poo.ducks.Duck;
import fr.uge.poo.simplegraphics.SimpleGraphics;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.ServiceLoader;
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
            var figures = parser(args[0]);
            var tmp_width = figures.maxWidth().orElse(500);
            var tmp_height = figures.maxHeight().orElse(500);
            var width = Math.max(500, tmp_width);
            var height = Math.max(500, tmp_height);
            ServiceLoader<Canvas> loader = ServiceLoader.load(fr.uge.poo.paint.ex8.Canvas.class);
            Canvas area = loader.findFirst().orElse(new SimpleGraphicsInstance());
            area.setArea("area", width, height);
            area.mouseWait((x,y) -> {
                area.clear(CanvasColor.WHITE);
                Figure f = figures.closeFigure(new Point(x, y));
                    figures.drawAll(area);
                    f.draw(area, CanvasColor.ORANGE);
            });
        }
    }
}
