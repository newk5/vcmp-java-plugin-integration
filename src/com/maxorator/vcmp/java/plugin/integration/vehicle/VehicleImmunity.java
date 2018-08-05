package com.maxorator.vcmp.java.plugin.integration.vehicle;

@SuppressWarnings("unused")
public class VehicleImmunity {

    private int hex;

    public VehicleImmunity(Flag... flags) {
        for (Flag flag : flags) {
            hex |= (1 << flag.ordinal());
        }
    }
    public VehicleImmunity(int... flags) {
        for (int flag : flags) {
            hex |= (1 << flag);
        }
    }

    public VehicleImmunity(int hex) {
        this.hex = hex;
    }

    public void add(Flag flag) {
        hex |= (1 << flag.ordinal());
    }

    public void remove(Flag flag) {
        hex &= ~(1 << flag.ordinal());
    }

    public boolean has(Flag flag) {
        return (hex & (1 << flag.ordinal())) != 0;
    }

    public void add(int flag) {
        hex |= (1 << flag);
    }

    public void remove(int flag) {
        hex &= ~(1 << flag);
    }

    public boolean has(int flag) {
        return (hex & (1 << flag)) != 0;
    }

    /**
     * @return the hex
     */
    public int getHex() {
        return hex;
    }

    /**
     * @param hex the hex to set
     */
    public void setHex(int hex) {
        this.hex = hex;
    }

    public enum Flag {
        BulletProof,
        FireProof,
        ExplosionProof,
        CollisionProof,
        MeleeProof,
        Windows,
        Tyres,
        FlipDamage
    }
}
