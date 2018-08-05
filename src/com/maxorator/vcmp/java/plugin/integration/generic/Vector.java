package com.maxorator.vcmp.java.plugin.integration.generic;

@SuppressWarnings("unused")
public class Vector {

    private float x;
    private float y;
    private float z;

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

    @Override
    public String toString() {
        return "Vector{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }

    /**
     * @return the x
     */
    public float getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public float getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * @return the z
     */
    public float getZ() {
        return z;
    }

    /**
     * @param z the z to set
     */
    public void setZ(float z) {
        this.z = z;
    }
}
