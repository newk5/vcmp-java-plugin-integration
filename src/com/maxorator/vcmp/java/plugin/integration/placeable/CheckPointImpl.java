package com.maxorator.vcmp.java.plugin.integration.placeable;

import com.maxorator.vcmp.java.plugin.integration.generic.Colour;
import com.maxorator.vcmp.java.plugin.integration.generic.EntityImpl;
import com.maxorator.vcmp.java.plugin.integration.generic.Vector;
import com.maxorator.vcmp.java.plugin.integration.player.Player;

@SuppressWarnings("unused")
public class CheckPointImpl extends EntityImpl implements CheckPoint {

    protected CheckPointImpl(int id) {
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
    public void setColour(Colour colour) {
        setColour(colour.red, colour.green, colour.blue, colour.alpha);
    }

    @Override
    public native void setColour(int red, int green, int blue, int alpha);

    @Override
    public Colour getColour() {
        return new Colour(getColourHex());
    }

    @Override
    public native int getColourHex();

    @Override
    public void setPosition(Vector position) {
        setPosition(position.x, position.y, position.z);
    }

    @Override
    public void setPos(Double x, Double y, Double z) {
        setPosition(new Vector(x, y, z));
    }

    @Override
    public void setPos(Integer x, Integer y, Integer z) {
        setPosition(new Vector(x, y, z));
    }

    @Override
    public Vector getPos() {
        return getPosition();
    }

    @Override
    public native void setPosition(float x, float y, float z);

    @Override
    public native Vector getPosition();

    @Override
    public native void setRadius(float radius);

    @Override
    public void setRadius(Double radius) {
        setRadius(new Float(radius));
    }
    
     @Override
    public void setRadius(Integer radius) {
        setRadius(new Float(radius));
    }

    @Override
    public native float getRadius();

    @Override
    public native Player getOwner();

}
