package fr.uge.poo.cmdline.ex3;

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
        parser.registerWithParameter("-lala", (it) -> ref.lala = true);
        parser.registerWithParameter("-donut", (it) -> ref.donut = true);
        parser.registerWithParameter("-lol", (it) -> ref.lol = true);
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
        parser.registerWithParameter("-donut", (it) -> ref.donut = true);
        parser.registerWithParameter("-nodonut", (it) -> ref.donut = false);
        String[] arguments={"bonjour", "lala", "coco", "-donut", "-nodonut"};
        var files = parser.process(arguments);
        assertFalse(ref.donut);
        assertEquals(files, List.of("bonjour", "lala", "coco"), "THIS IS BAD " + files);

    }

    @Test
    public void processShouldError() {
        var parser = new CmdLineParser();
        assertThrows(NullPointerException.class, () -> parser.registerWithParameter(null, (it) -> {}));
    }

    @Test
    public void processShouldError2() {
        var parser = new CmdLineParser();
        assertThrows(NullPointerException.class, () -> parser.registerWithParameter("-donut", null));
    }

    @Test
    public void processParameterBasicTest() {
        var parser = new CmdLineParser();
        var ref = new Object() {
            String donut = "";
        };
        parser.registerWithParameter("-donut", (it) -> ref.donut = it.next());
        String[] arguments={"bonjour", "lala", "coco", "-donut", "donjj"};
        var files = parser.process(arguments);
        assertEquals("donjj", ref.donut);
        assertEquals(List.of("bonjour", "lala", "coco"), files, "THIS IS BAD " + files);

    }
}