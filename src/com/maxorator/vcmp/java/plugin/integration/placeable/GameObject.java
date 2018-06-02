package com.maxorator.vcmp.java.plugin.integration.placeable;

import com.maxorator.vcmp.java.plugin.integration.generic.Entity;
import com.maxorator.vcmp.java.plugin.integration.generic.Quaternion;
import com.maxorator.vcmp.java.plugin.integration.generic.Vector;
import com.maxorator.vcmp.java.plugin.integration.player.Player;

@SuppressWarnings("unused")
public interface GameObject extends Entity {
    void delete();

    boolean isStreamedForPlayer(Player player);

    int getModel();

    void setWorld(int worldId);

    int getWorld();

    void setAlpha(int alpha, int fadeTime);

    int getAlpha();

    void moveTo(Vector position, int millis);

    void moveTo(float x, float y, float z, int millis);

    void moveBy(Vector delta, int millis);

    void moveBy(float x, float y, float z, int millis);

    void setPosition(Vector position);

    void setPosition(float x, float y, float z);

    Vector getPosition();

    void rotateTo(Quaternion rotation, int millis);

    void rotateTo(float x, float y, float z, float w, int millis);

    void rotateTo(Vector rotation, int millis);

    void rotateToEuler(float x, float y, float z, int millis);

    void rotateBy(Quaternion rotation, int millis);

    void rotateBy(float x, float y, float z, float w, int millis);

    void rotateBy(Vector rotation, int millis);

    void rotateByEuler(float x, float y, float z, int millis);

    Quaternion getRotation();

    Vector getRotationEuler();

    void setShotReportEnabled(boolean value);

    boolean isShotReportEnabled();

    void setTouchedReportEnabled(boolean value);

    boolean isTouchedReportEnabled();
}
