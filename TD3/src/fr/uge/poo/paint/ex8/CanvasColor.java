package fr.uge.poo.paint.ex8;

import com.evilcorp.coolgraphics.CoolGraphics;

import java.awt.*;

public enum CanvasColor {
    WHITE(Color.WHITE),
    BLACK(Color.BLACK),
    ORANGE(Color.ORANGE);

    private final Color color;

    CanvasColor(Color color) {
        this.color = color;
    }

    public Color toColor() {
        return this.color;
    }

    public CoolGraphics.ColorPlus toColorPlus() {
        return CoolGraphics.ColorPlus.valueOf(this.name());
    }

}
