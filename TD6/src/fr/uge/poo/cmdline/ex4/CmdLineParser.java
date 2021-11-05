package fr.uge.poo.cmdline.ex4;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

public class CmdLineParser {

    private final Map<String, OptionSettings> registeredOptions = new HashMap<>();


    public void addFlag(String option, Runnable run) {
        Objects.requireNonNull(option);
        Objects.requireNonNull(run);
        registeredOptions.put(option, (it) -> run.run());
    }

    public void addOptionWithOneParameter(String option, Consumer<String> consumer) {
        Objects.requireNonNull(option);
        Objects.requireNonNull(consumer);
        registeredOptions.put(option, (it) -> consumer.accept(it.next()));
    }

    /**
     * Register option with their parameter gestion
     * @param option is a String which is a name of option
     * @param consumer is a Consumer of Iterator of String which take each string in iterator like a param of consumer
     */
    public void registerWithParameter(String option, Consumer<Iterator<String>> consumer, int nb_param) {
        Objects.requireNonNull(option);
        Objects.requireNonNull(consumer);
        if (nb_param < 0) {
            throw new IllegalArgumentException("nb_param >= 0");
        }
        registeredOptions.put(option, consumer);
        numberParam.put(option, nb_param);
    }

    /**
     * Parse the command line of program execute the running code has associate with option in and return the
     * list of files input
     * @param arguments is String array which have a arguments of program
     * @return a list of string which are filename of command line
     */
    public List<String> process(String[] arguments) {
        ArrayList<String> files = new ArrayList<>();
        var args = new HashMap<String, List<String>>();
        AtomicReference<String> s_tmp = new AtomicReference<>("");
        args.put(s_tmp.get(), new ArrayList<>());
        Arrays.stream(arguments).forEach(s -> {
            if (s.startsWith("-")) {
                args.put(s, new ArrayList<>());
                s_tmp.set(s);
            } else {
                args.get(s_tmp.get()).add(s);
            }
        });
        args.forEach((k, v) -> {
            var tmp = registeredOptions.get(k);
            if (tmp == null && !k.equals("")) {
                throw new RuntimeException("Option " + k + " is not valid");
            } else {
                var nb_param = numberParam.get(k);
                if (nb_param != null && v.size() < numberParam.get(k))
                    throw new RuntimeException("Not enough parameter for option " + k);
                var it = v.iterator();
                if (!k.equals("")) {
                    tmp.accept(it);
                }
                while (it.hasNext()) {
                    files.add(it.next());
                }
            }
        });
        return files;
    }
}