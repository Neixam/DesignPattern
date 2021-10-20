package fr.uge.poo.paint.ex3;

import fr.uge.poo.simplegraphics.SimpleGraphics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Paint {
    public static List<Figure> parser(String file) {
        Path path = Paths.get(file);
        try (Stream<String> lines = Files.lines(path)) {
            return lines.flatMap(s -> {
                String[] tokens = s.split(" ");
                if (tokens[0].equals("line"))
                    return Stream.of(new Line(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]),
                            Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4])));
                else if (tokens[0].equals("rectangle"))
                    return Stream.of(new Rectangle(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]),
                            Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4])));
                else if (tokens[0].equals("ellipse"))
                    return Stream.of(new Ellipse(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]),
                            Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4])));
                return Stream.empty();
            }).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        if (args.length >= 1) {
            SimpleGraphics area = new SimpleGraphics("area", 800, 600);
            var figures = parser(args[0]);
            figures.forEach(f -> area.render(f::draw));
        }
    }
}
