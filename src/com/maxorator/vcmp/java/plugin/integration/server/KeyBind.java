package com.maxorator.vcmp.java.plugin.integration.server;

public class KeyBind {
    public int id;
    public boolean onRelease;
    public final int[] keys;

    public KeyBind() {
        this.keys = new int[3];
    }

    public KeyBind(int id, boolean onRelease, int keyOne, int keyTwo, int keyThree) {
        this.id = id;
        this.onRelease = onRelease;
        this.keys = new int[] { keyOne, keyTwo, keyThree };
    }
}
