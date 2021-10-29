package fr.uge.poo.cmdline.ex1;

import java.util.*;

public class CmdLineParser {

    private final Map<String, Runnable> registeredOptions = new HashMap<>();

    /**
     * Register the name of option and his run code
     * @param option is a String which is a name of option
     * @param run is a Runnable which is code if this option are find
     */
    public void registerOption(String option, Runnable run) {
        Objects.requireNonNull(option);
        Objects.requireNonNull(run);
        registeredOptions.put(option, run);
    }

    /**
     * Parse the command line of program execute the running code has associate with option in and return the
     * list of files input
     * @param arguments is a String which contains the options program or file input
     * @return a list of name of file which find in arguments
     */
    public List<String> process(String[] arguments) {
        ArrayList<String> files = new ArrayList<>();
        for (String argument : arguments) {
            Runnable tmp = registeredOptions.get(argument);
            if (tmp == null) {
                files.add(argument);
            } else {
                tmp.run();
            }
        }
        return files;
    }
}
