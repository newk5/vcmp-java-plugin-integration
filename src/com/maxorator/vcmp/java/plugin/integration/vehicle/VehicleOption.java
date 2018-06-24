package com.maxorator.vcmp.java.plugin.integration.vehicle;

@SuppressWarnings("unused")
public class VehicleOption {

    public int hex;

    public VehicleOption(Flag... flags) {
        for (Flag flag : flags) {
            hex |= (1 << flag.ordinal());
        }
    }

    public VehicleOption(int hex) {
        this.hex = hex;
    }

    public void add(Flag flag) {
        hex |= (1 << flag.ordinal());
    }

    public void remove(Flag flag) {
        hex &= ~(1 << flag.ordinal());
    }

    public boolean has(Flag flag) {
        return (hex | (1 << flag.ordinal())) != 0;
    }

    public enum Flag {
        DoorsLocked,
        Alarm,
        Lights,
        RadioLocked,
        Ghost,
        Siren,
        SingleUse
    }
}
