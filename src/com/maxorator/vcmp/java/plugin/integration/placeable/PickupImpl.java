package com.maxorator.vcmp.java.plugin.integration.placeable;

import com.maxorator.vcmp.java.plugin.integration.player.Player;
import com.maxorator.vcmp.java.plugin.integration.generic.EntityImpl;
import com.maxorator.vcmp.java.plugin.integration.generic.Vector;

@SuppressWarnings("unused")
public class PickupImpl extends EntityImpl implements Pickup {
    protected PickupImpl(int id) {
        super(id);
    }

    @Override
    public native void delete();

    @Override
    public native boolean isStreamedForPlayer(Player player);

    @Override
    public native void setWorld(int worldId);

    @Override
    public native int getWorld();

    @Override
    public native void setAlpha(int alpha);

    @Override
    public native int getAlpha();

    @Override
    public native void setAutomatic(boolean value);

    @Override
    public native boolean isAutomatic();

    @Override
    public native void setAutomaticTimer(int millis);

    @Override
    public native int getAutomaticTimer();

    @Override
    public native void refresh();

    @Override
    public void setPosition(Vector position) {
        setPosition(position.x, position.y, position.z);
    }

    @Override
    public native void setPosition(float x, float y, float z);

    @Override
    public native Vector getPosition();

    @Override
    public native int getModel();

    @Override
    public native int getQuantity();
}
