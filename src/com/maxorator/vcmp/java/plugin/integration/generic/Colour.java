package com.maxorator.vcmp.java.plugin.integration.generic;

@SuppressWarnings("unused")
public class Colour {
    private int red;
    private int green;
    private int blue;
    private int alpha;

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

    /**
     * @return the red
     */
    public int getRed() {
        return red;
    }

    /**
     * @param red the red to set
     */
    public void setRed(int red) {
        this.red = red;
    }

    /**
     * @return the green
     */
    public int getGreen() {
        return green;
    }

    /**
     * @param green the green to set
     */
    public void setGreen(int green) {
        this.green = green;
    }

    /**
     * @return the blue
     */
    public int getBlue() {
        return blue;
    }

    /**
     * @param blue the blue to set
     */
    public void setBlue(int blue) {
        this.blue = blue;
    }

    /**
     * @return the alpha
     */
    public int getAlpha() {
        return alpha;
    }

    /**
     * @param alpha the alpha to set
     */
    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }
}
