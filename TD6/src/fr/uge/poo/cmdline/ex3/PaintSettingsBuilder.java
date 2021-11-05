package fr.uge.poo.cmdline.ex3;

import java.net.InetSocketAddress;

public class PaintSettingsBuilder {
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
        return new PaintSettings(name, legacy, bordered, borderSize, width, height, address);
    }
}
