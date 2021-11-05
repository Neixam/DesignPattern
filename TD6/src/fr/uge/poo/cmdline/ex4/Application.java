package fr.uge.poo.cmdline.ex4;

import java.net.InetSocketAddress;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        var optionsBuild = new PaintSettings.PaintSettingsBuilder();
        String[] arguments={"dogmat", "-legacy", "-no-borders", "-window-name", "bidule", "-kok", "filename1","filename2"};
        var cmdParser = new CmdLineParser();
        cmdParser.addFlag("-legacy", () -> optionsBuild.setLegacy(true));
        cmdParser.addFlag("-with-borders", () -> optionsBuild.setBordered(true));
        cmdParser.addFlag("-no-borders", () -> optionsBuild.setBordered(false));
        cmdParser.registerWithParameter("-min-size",
                (it) -> optionsBuild.setWidth(Integer.parseInt(it.next())).setHeight(Integer.parseInt(it.next())), 2);
        cmdParser.registerWithParameter("-remote-server",
                (it) -> optionsBuild.setAddress(new InetSocketAddress(it.next(), Integer.parseInt(it.next()))), 2);
        cmdParser.addOptionWithOneParameter("-border-width", (s) -> optionsBuild.setBorderSize(Integer.parseInt(s)));
        cmdParser.addOptionWithOneParameter("-window-name", optionsBuild::setName);
        List<String> result = cmdParser.process(arguments);
        var options = optionsBuild.build();
        List<Path> files = result.stream().map(Path::of).collect(Collectors.toList());
        // this code replaces the rest of the application
        files.forEach(System.out::println);
        System.out.println(options);
    }
}
