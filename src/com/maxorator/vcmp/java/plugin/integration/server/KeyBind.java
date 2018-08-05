package com.maxorator.vcmp.java.plugin.integration.server;

public class KeyBind {
    private int id;
    private boolean onRelease;
    private final int[] keys;

    public KeyBind() {
        this.keys = new int[3];
    }

    public KeyBind(int id, boolean onRelease, int keyOne, int keyTwo, int keyThree) {
        this.id = id;
        this.onRelease = onRelease;
        this.keys = new int[] { keyOne, keyTwo, keyThree };
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the onRelease
     */
    public boolean isOnRelease() {
        return onRelease;
    }

    /**
     * @param onRelease the onRelease to set
     */
    public void setOnRelease(boolean onRelease) {
        this.onRelease = onRelease;
    }

    /**
     * @return the keys
     */
    public int[] getKeys() {
        return keys;
    }
}
