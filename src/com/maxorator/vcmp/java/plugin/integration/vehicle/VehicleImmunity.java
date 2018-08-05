package com.maxorator.vcmp.java.plugin.integration.vehicle;

@SuppressWarnings("unused")
public class VehicleImmunity {
    public int hex;

    public VehicleImmunity(Flag... flags) {
        for (Flag flag : flags) {
            hex |= (1 << flag.ordinal());
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
