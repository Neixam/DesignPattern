package fr.uge.poo.cmdline.ex5;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class CmdLineParser {
    private final Map<String, OptionSettings> registeredOptions = new HashMap<>();

    public void addOptionWithOneInt(String option, IntConsumer consumer) {
        addOptionWithOneParameter(option, s -> consumer.accept(Integer.parseInt(s)));
    }

    public void addOptionWithTwoInt(String option, BiConsumer<Integer, Integer> biConsumer) {
        addOption(option,
                new OptionSettings.OptionSettingsBuilder()
                        .setAct(it -> biConsumer.accept(Integer.parseInt(it.next()), Integer.parseInt(it.next())))
                        .setNb_param(2));
    }

    public void addOptionInetAddress(String option, BiConsumer<String, Integer> biConsumer) {
        addOption(option,
                new OptionSettings.OptionSettingsBuilder()
                        .setAct(it -> biConsumer.accept(it.next(), Integer.parseInt(it.next())))
                        .setNb_param(2));
    }


    public void addFlag(String option, Runnable run) {
        Objects.requireNonNull(option);
        Objects.requireNonNull(run);
        registeredOptions.put(option,
                new OptionSettings.OptionSettingsBuilder()
                        .setAct(it -> run.run())
                        .build());
    }

    public void addOptionWithOneParameter(String option, Consumer<String> consumer) {
        Objects.requireNonNull(option);
        Objects.requireNonNull(consumer);
        registeredOptions.put(option,
                new OptionSettings.OptionSettingsBuilder()
                        .setAct(it -> consumer.accept(it.next()))
                        .setNb_param(1)
                        .build());
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
        registeredOptions.put(option,
                new OptionSettings.OptionSettingsBuilder()
                        .setAct(consumer)
                        .setNb_param(nb_param)
                        .build());
    }

    public void addOption(String option, OptionSettings.OptionSettingsBuilder settings) {
        Objects.requireNonNull(option);
        Objects.requireNonNull(settings);
        registeredOptions.put(option, settings.build());
    }

    /**
     * Parse the command line of program execute the running code has associate with option in and return the
     * list of files input
     * @param arguments is String array which have a arguments of program
     * @return a list of string which are filename of command line
     */
    public List<String> process(String[] arguments) {
        var files = new ArrayList<String>();
        var allOptions = registeredOptions.values()
                .stream()
                .map(v -> v.getOtherName())
                .reduce(new ArrayList<>(), (a, v) -> {
                    a.addAll(v);
                    return a;
                });
        for (var i = 0; i < arguments.length; i++) {
            if (arguments[i].startsWith("-")) {
                var tmp = registeredOptions.get(arguments[i]);
                if (tmp == null) {
                    if (!allOptions.contains(arguments[1]))
                        throw new RuntimeException("Option " + arguments[i] + " is not valid");
                    tmp = registeredOptions.values()
                            .stream()
                            .filter(v -> v.getOtherName().contains(arguments[1]))
                            .findFirst()
                            .get();
                }
                if (i + tmp.getNb_param() >= arguments.length)
                    throw new RuntimeException("Not enough parameter for option " + arguments[i]);
                for (var j = 1; j <= tmp.getNb_param(); j++) {
                    if (arguments[i + j].startsWith("-"))
                        throw new RuntimeException("Not enough parameter for option " + arguments[i]);
                }
                tmp.accept(List.of(arguments).listIterator(i + 1));
                i = i + tmp.getNb_param();
            }
            else {
                files.add(arguments[i]);
            }
        }
        registeredOptions.forEach((k, v) -> {
            if (v.isNeedable() && (!Arrays.asList(arguments).contains(k)
                    && v.getOtherName().stream().anyMatch(s -> Arrays.asList(arguments).contains(s))))
                throw new RuntimeException("Need the option " + k);
        });
        return files;
    }

    public String usage() {
        return registeredOptions
                .keySet()
                .stream()
                .sorted(String::compareTo)
                .map(s -> new StringJoiner("\n").add(s))
                .reduce(new StringJoiner("\n"), (a, k) -> a.add(k + "\n" + registeredOptions.get(k.toString())))
                .toString();
    }
}