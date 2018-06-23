package com.maxorator.vcmp.java.plugin.integration.server;

public class MapBounds {

    public float maxX;
    public float minX;
    public float maxY;
    public float minY;

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
}
