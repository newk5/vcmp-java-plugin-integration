package com.maxorator.vcmp.java.plugin.integration.generic;

@SuppressWarnings("unused")
public class Vector {
    public float x, y, z;

    public Vector(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector(Integer x, Integer y, Integer z) {
        this.x = new Float(x);
        this.y = new Float(y);
        this.z = new Float(z);
    }

    public Vector(Double x, Double y, Double z) {
        this.x = new Float(x);
        this.y = new Float(y);
        this.z = new Float(z);
    }
}
