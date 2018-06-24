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

    Vector getPosition();

    void setOption(PickupOption setting, boolean value);

    void setOption(int settingId, boolean value);

    int getModel();

    int getQuantity();
}
