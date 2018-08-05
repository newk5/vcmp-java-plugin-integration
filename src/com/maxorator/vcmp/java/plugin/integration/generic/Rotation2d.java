package com.maxorator.vcmp.java.plugin.integration.generic;

@SuppressWarnings("unused")
public class Rotation2d {
    private float horizontal;
    private float vertical;

    public Rotation2d(float horizontal, float vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    /**
     * @return the horizontal
     */
    public float getHorizontal() {
        return horizontal;
    }

    @Override
    public String toString() {
        return "Rotation2d{" + "horizontal=" + horizontal + ", vertical=" + vertical + '}';
    }
    
    

    /**
     * @param horizontal the horizontal to set
     */
    public void setHorizontal(float horizontal) {
        this.horizontal = horizontal;
    }

    /**
     * @return the vertical
     */
    public float getVertical() {
        return vertical;
    }

    /**
     * @param vertical the vertical to set
     */
    public void setVertical(float vertical) {
        this.vertical = vertical;
    }
}
