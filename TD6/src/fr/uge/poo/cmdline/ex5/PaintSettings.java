package fr.uge.poo.cmdline.ex5;

import java.net.InetSocketAddress;
import java.util.Objects;

public class PaintSettings {
    private String name;
    private boolean legacy;
    private boolean bordered;
    private int borderSize;
    private int width;
    private int height;
    private InetSocketAddress address;

    public static class PaintSettingsBuilder {
        private String name;
        private boolean legacy = false;
        private boolean bordered = false;
        private int borderSize = 10;
        private int width = 500;
        private int height = 500;
        private InetSocketAddress address = null;

        public PaintSettingsBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PaintSettingsBuilder setLegacy(boolean legacy) {
            this.legacy = legacy;
            return this;
        }

        public PaintSettingsBuilder setBordered(boolean bordered) {
            this.bordered = bordered;
            return this;
        }

        public PaintSettingsBuilder setBorderSize(int borderSize) {
            this.borderSize = borderSize;
            return this;
        }

        public PaintSettingsBuilder setWidth(int width) {
            this.width = width;
            return this;
        }

        public PaintSettingsBuilder setHeight(int height) {
            this.height = height;
            return this;
        }

        public PaintSettingsBuilder setAddress(InetSocketAddress address) {
            this.address = address;
            return this;
        }

        public PaintSettings build() {
            return new PaintSettings(this);
        }
    }

    private PaintSettings(PaintSettingsBuilder builder) {
        this.name = Objects.requireNonNull(builder.name);
        this.legacy = builder.legacy;
        this.bordered = builder.bordered;
        this.borderSize = builder.borderSize;
        this.width = builder.width;
        this.height = builder.height;
        this.address = builder.address;
    }

    public void setLegacy(boolean legacy) {
        this.legacy = legacy;
    }

    public boolean isLegacy(){
        return legacy;
    }

    public void setBordered(boolean bordered){
        this.bordered=bordered;
    }

    public boolean isBordered(){
        return bordered;
    }

    @Override
    public String toString() {
        return "PaintSettings{" +
                "name='" + name + '\'' +
                ", legacy=" + legacy +
                ", bordered=" + bordered +
                ", borderSize=" + borderSize +
                ", width=" + width +
                ", height=" + height +
                ", address=" + address +
                '}';
    }
}
