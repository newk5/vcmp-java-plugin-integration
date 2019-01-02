package com.maxorator.vcmp.java.plugin.integration.server;

import com.maxorator.vcmp.java.plugin.integration.generic.Colour;
import com.maxorator.vcmp.java.plugin.integration.generic.Vector;

public class CoordBlipInfo {

    private int index;
    private int worldId;
    private Vector position;
    private int scale;
    private Colour colour;
    private int spriteId;
    private Vector pos;
    
    
    private Server server;

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

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * @return the worldId
     */
    public int getWorldId() {
        return worldId;
    }

    /**
     * @param worldId the worldId to set
     */
    public void setWorldId(int worldId) {
        this.worldId = worldId;
        recreate();

    }

    public void recreate() {
        server.destroyCoordBlip(index);
        server.createCoordBlip(this);
    }

    public CoordBlipInfo makeCopy(CoordBlipInfo old) {
        CoordBlipInfo b = new CoordBlipInfo(index, worldId, position, scale, colour, spriteId);

        return b;
    }

    /**
     * @return the position
     */
    public Vector getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(Vector position) {
        this.position = position;

        recreate();
    }

    /**
     * @return the scale
     */
    public int getScale() {
        return scale;
    }

    /**
     * @param scale the scale to set
     */
    public void setScale(int scale) {
        this.scale = scale;
        recreate();
    }

    /**
     * @return the colour
     */
    public Colour getColour() {
        return colour;
    }

    /**
     * @param colour the colour to set
     */
    public void setColour(Colour colour) {
        this.colour = colour;
        recreate();
    }

    /**
     * @return the spriteId
     */
    public int getSpriteId() {
        return spriteId;
    }

    /**
     * @param spriteId the spriteId to set
     */
    public void setSpriteId(int spriteId) {
        this.spriteId = spriteId;
        recreate();
    }

    /**
     * @return the server
     */
    public Server getServer() {
        return server;
    }

    /**
     * @param server the server to set
     */
    public void setServer(Server server) {
        this.server = server;
    }

    /**
     * @return the pos
     */
    public Vector getPos() {
        return pos;
    }

    /**
     * @param pos the pos to set
     */
    public void setPos(Vector pos) {
        this.pos = pos;
        this.position = pos;
        recreate();
    }
}
