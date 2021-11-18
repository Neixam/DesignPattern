package fr.uge.poo.cmdline.ex5;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;

public class OptionSettings {
    public static class OptionSettingsBuilder {
        private Consumer<Iterator<String>> act = (it) ->  {};
        private int nb_param = 0;
        private boolean needable = false;
        private String usage = "";

        public void setUsage(String usage) {
            this.usage = usage;
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

        public OptionSettings build() {
            return new OptionSettings(this);
        }
    }
    private Consumer<Iterator<String>> act;
    private int nb_param;
    private boolean needable;
    private String usage;

    private OptionSettings(OptionSettingsBuilder builder) {
        Objects.requireNonNull(builder.act);
        if (builder.nb_param < 0)
            throw new IllegalStateException("nb_param >= 0");
        this.act = builder.act;
        this.nb_param = builder.nb_param;
        this.needable = builder.needable;
        this.usage = builder.usage;
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

    public boolean isNeedable() {
        return needable;
    }

    @Override
    public String toString() {
        return "\tnb_param=" + nb_param +
                "\n\tneedable=" + needable +
                "\n\t" + usage ;
    }
}
