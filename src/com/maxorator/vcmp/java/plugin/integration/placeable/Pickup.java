package com.maxorator.vcmp.java.plugin.integration.placeable;

import com.maxorator.vcmp.java.plugin.integration.generic.Entity;
import com.maxorator.vcmp.java.plugin.integration.player.Player;
import com.maxorator.vcmp.java.plugin.integration.generic.Vector;

@SuppressWarnings("unused")
public interface Pickup extends Entity {

    void delete();

    boolean isStreamedForPlayer(Player player);

    void setWorld(int worldId);

    int getWorld();

    void setAlpha(int alpha);

    int getAlpha();

    void setAutomatic(boolean value);

    boolean isAutomatic();

    void setAutomaticTimer(int millis);

    int getAutomaticTimer();

    void refresh();

    void setPosition(Vector position);

    void setPosition(float x, float y, float z);

    void setPos(Double x, Double y, Double z);

    void setPos(Integer x, Integer y, Integer z);

    Vector getPos();

    Vector getPosition();

    int getModel();

    int getQuantity();
}
