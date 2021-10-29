package fr.uge.poo.cmdline.ex1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("static-method")
class CmdLineParserTest {

    @Test
    public void processShouldFailFastOnNullArgument() {
        var parser = new CmdLineParser();
        assertThrows(NullPointerException.class, () -> parser.process(null));
    }

    @Test
    public void processBasicTest() {
        var parser = new CmdLineParser();
        var ref = new Object() {
            boolean donut = false;
            boolean lol = false;
            boolean lala = false;
        };
        parser.registerOption("-lala", () -> ref.lala = true);
        parser.registerOption("-donut", () -> ref.donut = true);
        parser.registerOption("-lol", () -> ref.lol = true);
        String[] arguments={"bonjour", "-lala", "coco", "-donut"};
        var files = parser.process(arguments);
        assertTrue(ref.lala);
        assertTrue(ref.donut);
        assertFalse(ref.lol);
        assertEquals(files, List.of("bonjour", "coco"), "THIS IS BAD " + files);
    }

    @Test
    public void processOtherBasicTest() {
        var parser = new CmdLineParser();
        var ref = new Object() {
            boolean donut = false;
        };
        parser.registerOption("-donut", () -> ref.donut = true);
        parser.registerOption("-nodonut", () -> ref.donut = false);
        String[] arguments={"bonjour", "lala", "coco", "-donut", "-nodonut"};
        var files = parser.process(arguments);
        assertFalse(ref.donut);
        assertEquals(files, List.of("bonjour", "lala", "coco"), "THIS IS BAD " + files);

    }

    @Test
    public void processShouldError() {
        var parser = new CmdLineParser();
        assertThrows(NullPointerException.class, () -> parser.registerOption(null, () -> {}));
    }

    @Test
    public void processShouldError2() {
        var parser = new CmdLineParser();
        assertThrows(NullPointerException.class, () -> parser.registerOption("-donut", null));
    }
}