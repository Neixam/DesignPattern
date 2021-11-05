package fr.uge.poo.cmdline.ex3;

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

    public PaintSettings(String name, boolean legacy, boolean bordered, int borderSize, int width, int height, InetSocketAddress address) {
        this.name = Objects.requireNonNull(name);
        this.legacy = legacy;
        this.bordered = bordered;
        this.borderSize = borderSize;
        this.width = width;
        this.height = height;
        this.address = address;
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
