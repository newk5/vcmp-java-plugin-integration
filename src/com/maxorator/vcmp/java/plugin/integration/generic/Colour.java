package com.maxorator.vcmp.java.plugin.integration.generic;

@SuppressWarnings("unused")
public class Colour {
    public int red;
    public int green;
    public int blue;
    public int alpha;

    public Colour(int hex) {
        blue = hex & 0xFF;
        hex >>>= 8;
        green = hex & 0xFF;
        hex >>>= 8;
        red = hex & 0xFF;
        hex >>>= 8;
        alpha = hex;
    }

    public Colour(int red, int green, int blue, int alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    public Colour(int red, int green, int blue) {
        this(red, green, blue, 255);
    }

    public int getHex() {
        return ((alpha & 0xFF) << 24) | ((red & 0xFF) << 16) | ((green & 0xFF) << 8) | (blue & 0xFF);
    }
}
