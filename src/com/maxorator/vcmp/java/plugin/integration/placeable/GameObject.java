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

    void rotateBy(Double x, Double y, Double z, Double w, int millis);

    void rotateBy(Integer x, Integer y, Integer z, Integer w, int millis);

    void rotateByEuler(Double x, Double y, Double z, int millis);

    void rotateByEuler(Integer x, Integer y, Integer z, int millis);

    void moveTo(Vector position, int millis);

    void moveTo(float x, float y, float z, int millis);

    void moveTo(Double x, Double y, Double z, int millis);

    void moveBy(Double x, Double y, Double z, int millis);

    void moveTo(Integer x, Integer y, Integer z, int millis);

    void moveBy(Integer x, Integer y, Integer z, int millis);

    void setPos(Integer x, Integer y, Integer z);

    void setPos(Double x, Double y, Double z);

    Vector getPos();

    void rotateTo(Double x, Double y, Double z, Double w, int millis);

    void rotateTo(Integer x, Integer y, Integer z, Integer w, int millis);

    void rotateToEuler(Double x, Double y, Double z,  int millis);

    void rotateToEuler(Integer x, Integer y, Integer z,  int millis);

    void moveBy(Vector delta, int millis);

    void moveBy(float x, float y, float z, int millis);

    void setPosition(Vector position);

    void setPosition(float x, float y, float z);

    Vector getPosition();

    void rotateTo(Quaternion rotation, int millis);

    void rotateTo(Vector rotation, int millis);

    void rotateBy(Quaternion rotation, int millis);

    void rotateBy(Vector rotation, int millis);

    Quaternion getRotation();

    Vector getRotationEuler();

    void setShotReportEnabled(boolean value);

    boolean isShotReportEnabled();

    void setTouchedReportEnabled(boolean value);

    boolean isTouchedReportEnabled();

    void rotateTo(float x, float y, float z, float w, int millis);

    void rotateToEuler(float x, float y, float z, int millis);

    void rotateBy(float x, float y, float z, float w, int millis);

    void rotateByEuler(float x, float y, float z, int millis);
}
