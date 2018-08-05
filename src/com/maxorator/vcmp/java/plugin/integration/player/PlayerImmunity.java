package com.maxorator.vcmp.java.plugin.integration.player;

@SuppressWarnings("unused")
public class PlayerImmunity { 

    private int flags;

    public PlayerImmunity(Flag... flags) {
        for (Flag flag : flags) {
            this.flags |= (1 << flag.ordinal());
        }
    }

    public PlayerImmunity(int... flags) {
        for (int flag : flags) {
            this.flags |= (1 << flag);
        }
    }

    public PlayerImmunity(int hex) {
        this.flags = hex;
    }

    public void add(Flag flag) {
        flags |= (1 << flag.ordinal());
    }

    public void remove(Flag flag) {
        flags &= ~(1 << flag.ordinal());
    }

    public boolean has(Flag flag) {
        return (flags & (1 << flag.ordinal())) != 0;
    }

    public void add(int flag) {
        flags |= (1 << flag);
    }

    public void remove(int flag) {
        flags &= ~(1 << flag);
    }

    public boolean has(int flag) {
        return (flags & (1 << flag)) != 0;
    }

    /**
     * @return the flags
     */
    public int getFlags() {
        return flags;
    }

    /**
     * @param flags the flags to set
     */
    public void setFlags(int flags) {
        this.flags = flags;
    }

    public enum Flag {
        BulletProof,
        FireProof,
        ExplosionProof,
        CollisionProof,
        MeleeProof,
        CannotFall,
        NoCriticals
    }
}
