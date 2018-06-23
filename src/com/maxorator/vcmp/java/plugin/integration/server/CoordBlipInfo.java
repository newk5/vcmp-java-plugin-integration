package com.maxorator.vcmp.java.plugin.integration.server;

import com.maxorator.vcmp.java.plugin.integration.generic.Colour;
import com.maxorator.vcmp.java.plugin.integration.generic.Vector;

public class CoordBlipInfo {

    public int index;
    public int worldId;
    public Vector position;
    public int scale;
    public Colour colour;
    public int spriteId;

    public CoordBlipInfo(int index, int worldId, Vector position, int scale, Colour colour, int spriteId) {
        this.index = index;
        this.worldId = worldId;
        this.position = position;
        this.scale = scale;
        this.colour = colour;
        this.spriteId = spriteId;
    }

    public CoordBlipInfo(int index, int worldId, float posX, float posY, float posZ, int scale, int colourHex, int spriteId) {
        this(index, worldId, new Vector(posX, posY, posZ), scale, new Colour(colourHex), spriteId);
    }

    public CoordBlipInfo(int index, int worldId, Double posX, Double posY, Double posZ, int scale, int colourHex, int spriteId) {
        this(index, worldId, new Vector(posX, posY, posZ), scale, new Colour(colourHex), spriteId);
    }

    public CoordBlipInfo(int index, int worldId, Integer posX, Integer posY, Integer posZ, int scale, int colourHex, int spriteId) {
        this(index, worldId, new Vector(posX, posY, posZ), scale, new Colour(colourHex), spriteId);
    }
}
