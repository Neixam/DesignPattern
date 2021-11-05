package fr.uge.poo.cmdline.ex3;

import java.util.*;
import java.util.function.Consumer;

public class CmdLineParser {

    private final Map<String, Consumer<Iterator<String>>> registeredOptions = new HashMap<>();

    /**
     * Register option with their parameter gestion
     * @param option is a String which is a name of option
     * @param consumer is a Consumer of Iterator of String which take each string in iterator like a param of consumer
     */
    public void registerWithParameter(String option, Consumer<Iterator<String>> consumer) {
        Objects.requireNonNull(option);
        Objects.requireNonNull(consumer);
        registeredOptions.put(option, consumer);
    }

    /**
     * Parse the command line of program execute the running code has associate with option in and return the
     * list of files input
     * @param arguments is String array which have a arguments of program
     * @return a list of string which are filename of command line
     */
    public List<String> process(String[] arguments) {
        ArrayList<String> files = new ArrayList<>();
        var it = Arrays.stream(arguments).iterator();
        while (it.hasNext()) {
            var argument = it.next();
            var tmp = registeredOptions.get(argument);
            if (tmp == null) {
                files.add(argument);
            } else {
                tmp.accept(it);
            }
        }
        return files;
    }
}
