package com.maxorator.vcmp.java.plugin.integration.generic;

@SuppressWarnings("unused")
public class Quaternion {
    private float x;
    private float y;
    private float z;
    private float w;

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

    @Override
    public String toString() {
        return "Quaternion{" + "x=" + x + ", y=" + y + ", z=" + z + ", w=" + w + '}';
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

    /**
     * @return the w
     */
    public float getW() {
        return w;
    }

    /**
     * @param w the w to set
     */
    public void setW(float w) {
        this.w = w;
    }

}
