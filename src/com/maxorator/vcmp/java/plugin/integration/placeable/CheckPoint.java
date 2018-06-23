package com.maxorator.vcmp.java.plugin.integration.placeable;

import com.maxorator.vcmp.java.plugin.integration.generic.Colour;
import com.maxorator.vcmp.java.plugin.integration.generic.Entity;
import com.maxorator.vcmp.java.plugin.integration.generic.Vector;
import com.maxorator.vcmp.java.plugin.integration.player.Player;

@SuppressWarnings("unused")
public interface CheckPoint extends Entity {

    void delete();

    boolean isStreamedForPlayer(Player player);

    void setWorld(int worldId);

    int getWorld();

    void setColour(Colour colour);

    void setColour(int red, int green, int blue, int alpha);

    Colour getColour();

    int getColourHex();

    void setPosition(Vector position);

    void setPosition(float x, float y, float z);

    void setPos(Double x, Double y, Double z);

    void setPos(Integer x, Integer y, Integer z);
    
    void setRadius(Double radius);
    
    void setRadius(Integer radius);
    
    Vector getPos();

    Vector getPosition();

    void setRadius(float radius);

    float getRadius();

    Player getOwner();

}
