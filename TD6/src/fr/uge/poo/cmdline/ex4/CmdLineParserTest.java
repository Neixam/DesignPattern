package fr.uge.poo.cmdline.ex4;

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
        parser.addFlag("-lala", () -> ref.lala = true);
        parser.addFlag("-donut", () -> ref.donut = true);
        parser.addFlag("-lol", () -> ref.lol = true);
        String[] arguments={"bonjour", "-lala", "coco", "-donut"};
        var files = parser.process(arguments);
        assertTrue(ref.lala);
        assertTrue(ref.donut);
        assertFalse(ref.lol);
        assertEquals(List.of("bonjour", "coco"), files, "THIS IS BAD " + files);
    }

    @Test
    public void processOtherBasicTest() {
        var parser = new CmdLineParser();
        var ref = new Object() {
            boolean donut = false;
        };
        parser.addFlag("-donut", () -> ref.donut = true);
        parser.addFlag("-nodonut", () -> ref.donut = false);
        String[] arguments={"bonjour", "lala", "coco", "-donut", "-nodonut"};
        var files = parser.process(arguments);
        assertFalse(ref.donut);
        assertEquals(files, List.of("bonjour", "lala", "coco"), "THIS IS BAD " + files);

    }

    @Test
    public void processShouldError() {
        var parser = new CmdLineParser();
        assertThrows(NullPointerException.class, () -> parser.registerWithParameter(null, (it) -> {}, 0));
    }

    @Test
    public void processShouldError2() {
        var parser = new CmdLineParser();
        assertThrows(NullPointerException.class, () -> parser.registerWithParameter("-donut", null, 0));
    }

    @Test
    public void processParameterBasicTest() {
        var parser = new CmdLineParser();
        var ref = new Object() {
            String donut = "";
        };
        parser.addOptionWithOneParameter("-donut", (s) -> ref.donut = s);
        String[] arguments={"bonjour", "lala", "coco", "-donut", "donjj"};
        var files = parser.process(arguments);
        assertEquals("donjj", ref.donut);
        assertEquals(List.of("bonjour", "lala", "coco"), files, "THIS IS BAD " + files);

    }
}