package fr.uge.poo.cmdline.ex5;

import java.util.*;
import java.util.function.Consumer;

public class OptionSettings {
    public static class OptionSettingsBuilder {
        private Consumer<Iterator<String>> act = (it) ->  {};
        private int nb_param = 0;
        private boolean needable = false;
        private String usage = "";
        private final List<String> otherName = new ArrayList<>();

        public OptionSettingsBuilder setUsage(String usage) {
            this.usage = usage;
            return this;
        }

        public OptionSettingsBuilder setAct(Consumer<Iterator<String>> act) {
            this.act = act;
            return this;
        }

        public OptionSettingsBuilder setNb_param(int nb_param) {
            this.nb_param = nb_param;
            return this;
        }

        public OptionSettingsBuilder setNeedable(boolean needable) {
            this.needable = needable;
            return this;
        }

        public OptionSettingsBuilder setOtherName(String ...names) {
            this.otherName.addAll(List.of(names));
            return this;
        }

        public OptionSettingsBuilder setOtherName(List<String> names) {
            this.otherName.addAll(names);
            return this;
        }

        public OptionSettings build() {
            return new OptionSettings(this);
        }
    }
    private Consumer<Iterator<String>> act;
    private int nb_param;
    private boolean needable;
    private String usage;
    private final List<String> otherName = new ArrayList<>();

    private OptionSettings(OptionSettingsBuilder builder) {
        Objects.requireNonNull(builder.act);
        if (builder.nb_param < 0)
            throw new IllegalStateException("nb_param >= 0");
        this.act = builder.act;
        this.nb_param = builder.nb_param;
        this.needable = builder.needable;
        this.usage = builder.usage;
        this.otherName.addAll(builder.otherName);
    }

    public void accept(Iterator<String> it) {
        act.accept(it);
    }

    public int getNb_param() {
        return nb_param;
    }

    public String getUsage() {
        return usage;
    }

    public List<String> getOtherName() {
        return List.copyOf(otherName);
    }

    public boolean isNeedable() {
        return needable;
    }

    @Override
    public String toString() {
        var ret = "";
        var otherNames = otherName.stream().map(s -> new StringJoiner(", ").add(s))
                .reduce(new StringJoiner(", "), (a, v) -> a.add(v.toString()));
        if (!otherNames.equals(""))
            ret = "\tother names : " + otherNames;
        return  ret +
                "\n\tnb_param=" + nb_param +
                "\n\tneedable=" + needable +
                "\n\t" + usage ;
    }
}
