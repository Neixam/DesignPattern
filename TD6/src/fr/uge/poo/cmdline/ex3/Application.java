package fr.uge.poo.cmdline.ex3;

import java.net.InetSocketAddress;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        var optionsBuild = new PaintSettingsBuilder();
        String[] arguments={"-legacy", "-no-borders", "-window-name", "bidule", "filename1","filename2"};
        var cmdParser = new CmdLineParser();
        cmdParser.registerWithParameter("-legacy", (it) -> optionsBuild.setLegacy(true));
        cmdParser.registerWithParameter("-with-borders", (it) -> optionsBuild.setBordered(true));
        cmdParser.registerWithParameter("-no-borders", (it) -> optionsBuild.setBordered(false));
        cmdParser.registerWithParameter("-min-size",
                (it) -> optionsBuild.setWidth(Integer.parseInt(it.next())).setHeight(Integer.parseInt(it.next())));
        cmdParser.registerWithParameter("-remote-server",
                (it) -> optionsBuild.setAddress(new InetSocketAddress(it.next(), Integer.parseInt(it.next()))));
        cmdParser.registerWithParameter("-border-width", (it) -> optionsBuild.setBorderSize(Integer.parseInt(it.next())));
        cmdParser.registerWithParameter("-window-name", (it) -> optionsBuild.setName(it.next()));
        List<String> result = cmdParser.process(arguments);
        var options = optionsBuild.build();
        List<Path> files = result.stream().map(Path::of).collect(Collectors.toList());
        // this code replaces the rest of the application
        files.forEach(p -> System.out.println(p));
        System.out.println(options);
    }
}
