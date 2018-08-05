package com.maxorator.vcmp.java.plugin.integration.placeable;

import com.maxorator.vcmp.java.plugin.integration.generic.EntityImpl;
import com.maxorator.vcmp.java.plugin.integration.generic.Quaternion;
import com.maxorator.vcmp.java.plugin.integration.generic.Vector;
import com.maxorator.vcmp.java.plugin.integration.player.Player;

@SuppressWarnings("unused")
public class GameObjectImpl extends EntityImpl implements GameObject {

    protected GameObjectImpl(int id) {
        super(id);
    }

    @Override
    public native void delete();

    @Override
    public native boolean isStreamedForPlayer(Player player);

    @Override
    public native int getModel();

    @Override
    public native void setWorld(int worldId);

    @Override
    public native int getWorld();

    @Override
    public native void setAlpha(int alpha, int fadeTime);

    @Override
    public native int getAlpha();

    @Override
    public void moveTo(Vector position, int millis) {
        moveTo(position.getX(), position.getY(), position.getZ(), millis);
    }

    @Override
    public void moveTo(Double x, Double y, Double z, int millis) {
        moveTo(new Vector(x, y, z), millis);
    }

    @Override
    public void moveTo(Integer x, Integer y, Integer z, int millis) {
        moveTo(new Vector(x, y, z), millis);
    }

    @Override
    public native void moveTo(float x, float y, float z, int millis);

    @Override
    public void moveBy(Vector delta, int millis) {
        moveBy(delta.getX(), delta.getY(), delta.getZ(), millis);
    }

    @Override
    public native void moveBy(float x, float y, float z, int millis);

    @Override
    public void moveBy(Double x, Double y, Double z, int millis) {
        moveBy(new Vector(x, y, z), millis);
    }

    @Override
    public void moveBy(Integer x, Integer y, Integer z, int millis) {
        moveBy(new Vector(x, y, z), millis);
    }

    @Override
    public void setPosition(Vector position) {
        setPosition(position.getX(), position.getY(), position.getZ());
    }

    @Override
    public native void setPosition(float x, float y, float z);

    @Override
    public void setPos(Integer x, Integer y, Integer z) {
        setPosition(new Vector(x, y, z));
    }

    @Override
    public void setPos(Double x, Double y, Double z) {
        setPosition(new Vector(x, y, z));
    }

    @Override
    public Vector getPos() {
        return getPosition();
    }

    @Override
    public native Vector getPosition();

    @Override
    public void rotateTo(Quaternion rotation, int millis) {
        rotateTo(rotation.getX(), rotation.getY(), rotation.getZ(), rotation.getW(), millis);
    }

    @Override
    public native void rotateTo(float x, float y, float z, float w, int millis);

    @Override
    public void rotateTo(Double x, Double y, Double z, Double w, int millis) {
        rotateTo(new Quaternion(x, y, z, w), millis);
    }

    @Override
    public void rotateTo(Integer x, Integer y, Integer z, Integer w, int millis) {
        rotateTo(new Quaternion(x, y, z, w), millis);
    }

    @Override
    public void rotateTo(Vector rotation, int millis) {
        rotateToEuler(rotation.getX(), rotation.getY(), rotation.getZ(), millis);
    }

    @Override
    public native void rotateToEuler(float x, float y, float z, int millis);

    @Override
    public void rotateToEuler(Double x, Double y, Double z, Double w, int millis) {
        rotateToEuler(new Float(x), new Float(y), new Float(z), millis);
    }

    @Override
    public void rotateToEuler(Integer x, Integer y, Integer z, Integer w, int millis) {
        rotateToEuler(new Float(x), new Float(y), new Float(z), millis);
    }

    @Override
    public void rotateBy(Quaternion rotation, int millis) {
        rotateBy(rotation.getX(), rotation.getY(), rotation.getZ(), rotation.getW(), millis);
    }

    @Override
    public void rotateBy(Double x, Double y, Double z, Double w, int millis) {
        rotateBy(new Quaternion(x, y, z, w), millis);
    }

    @Override
    public void rotateBy(Integer x, Integer y, Integer z, Integer w, int millis) {
        rotateBy(new Quaternion(x, y, z, w), millis);
    }

    @Override
    public native void rotateBy(float x, float y, float z, float w, int millis);

    @Override
    public void rotateBy(Vector rotation, int millis) {
        rotateByEuler(rotation.getX(), rotation.getY(), rotation.getZ(), millis);
    }

    @Override
    public native void rotateByEuler(float x, float y, float z, int millis);
    
     @Override
    public void rotateByEuler(Double x, Double y, Double z, int millis) {
        rotateByEuler(new Float(x), new Float(y), new Float(z), millis);
    }

    @Override
    public void rotateByEuler(Integer x, Integer y, Integer z, int millis) {
        rotateByEuler(new Float(x), new Float(y), new Float(z), millis);
    }

    @Override
    public native Quaternion getRotation();

    @Override
    public native Vector getRotationEuler();

    @Override
    public native void setShotReportEnabled(boolean value);

    @Override
    public native boolean isShotReportEnabled();

    @Override
    public native void setTouchedReportEnabled(boolean value);

    @Override
    public native boolean isTouchedReportEnabled();
}
