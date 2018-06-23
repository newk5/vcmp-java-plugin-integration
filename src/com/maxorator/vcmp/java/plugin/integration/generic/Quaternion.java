package com.maxorator.vcmp.java.plugin.integration.generic;

@SuppressWarnings("unused")
public class Quaternion {
    public float x, y, z, w;

    public Quaternion(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Quaternion(Integer x, Integer y, Integer z, Integer w) {
        this.x = new Float(x);
        this.y = new Float(y);
        this.z = new Float(z);
        this.w = new Float(w);
    }

    public Quaternion(Double x, Double y, Double z, Double w) {
        this.x = new Float(x);
        this.y = new Float(y);
        this.z = new Float(z);
        this.w = new Float(w);

    }

}
