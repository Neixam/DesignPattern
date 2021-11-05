package fr.uge.poo.cmdline.ex4;

import java.util.Iterator;
import java.util.function.Consumer;

public class OptionSettings {
    public static class OptionSettingsBuilder {
        private Consumer<Iterator<String>> act = (it) ->  {};
        private int nb_param = 0;
        private boolean needable = false;

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

    private OptionSettings(OptionSettingsBuilder builder) {
        this.act = builder.act;
        this.nb_param = builder.nb_param;
        this.needable = builder.needable;
    }

    public void accept(Iterator<String> it) {
        act.accept(it);
    }

    public int getNb_param() {
        return nb_param;
    }

    public boolean isNeedable() {
        return needable;
    }
}
