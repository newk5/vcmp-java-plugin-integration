package com.maxorator.vcmp.java.plugin.integration.server;

public class MapBounds {

    private float maxX;
    private float minX;
    private float maxY;
    private float minY;

    public MapBounds(float maxX, float minX, float maxY, float minY) {
        this.maxX = maxX;
        this.minX = minX;
        this.maxY = maxY;
        this.minY = minY;
    }

    public MapBounds(Double maxX, Double minX, Double maxY, Double minY) {
        this.maxX = new Float(maxX);
        this.minX = new Float(minX);
        this.maxY = new Float(maxY);
        this.minY = new Float(minY);
    }

    public MapBounds(Double maxX, Integer minX, Integer maxY, Integer minY) {
        this.maxX = new Float(maxX);
        this.minX = new Float(minX);
        this.maxY = new Float(maxY);
        this.minY = new Float(minY);
    }

    /**
     * @return the maxX
     */
    public float getMaxX() {
        return maxX;
    }

    /**
     * @param maxX the maxX to set
     */
    public void setMaxX(float maxX) {
        this.maxX = maxX;
    }

    /**
     * @return the minX
     */
    public float getMinX() {
        return minX;
    }

    /**
     * @param minX the minX to set
     */
    public void setMinX(float minX) {
        this.minX = minX;
    }

    /**
     * @return the maxY
     */
    public float getMaxY() {
        return maxY;
    }

    /**
     * @param maxY the maxY to set
     */
    public void setMaxY(float maxY) {
        this.maxY = maxY;
    }

    /**
     * @return the minY
     */
    public float getMinY() {
        return minY;
    }

    /**
     * @param minY the minY to set
     */
    public void setMinY(float minY) {
        this.minY = minY;
    }
}
