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
        moveTo(position.x, position.y, position.z, millis);
    }

    @Override
    public native void moveTo(float x, float y, float z, int millis);

    @Override
    public void moveBy(Vector delta, int millis) {
        moveBy(delta.x, delta.y, delta.z, millis);
    }

    @Override
    public native void moveBy(float x, float y, float z, int millis);

    @Override
    public void setPosition(Vector position) {
        setPosition(position.x, position.y, position.z);
    }

    @Override
    public native void setPosition(float x, float y, float z);

    @Override
    public native Vector getPosition();

    @Override
    public void rotateTo(Quaternion rotation, int millis) {
        rotateTo(rotation.x, rotation.y, rotation.z, rotation.w, millis);
    }

    @Override
    public native void rotateTo(float x, float y, float z, float w, int millis);

    @Override
    public void rotateTo(Vector rotation, int millis) {
        rotateToEuler(rotation.x, rotation.y, rotation.z, millis);
    }

    @Override
    public native void rotateToEuler(float x, float y, float z, int millis);

    @Override
    public void rotateBy(Quaternion rotation, int millis) {
        rotateBy(rotation.x, rotation.y, rotation.z, rotation.w, millis);
    }

    @Override
    public native void rotateBy(float x, float y, float z, float w, int millis);

    @Override
    public void rotateBy(Vector rotation, int millis) {
        rotateByEuler(rotation.x, rotation.y, rotation.z, millis);
    }

    @Override
    public native void rotateByEuler(float x, float y, float z, int millis);

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
