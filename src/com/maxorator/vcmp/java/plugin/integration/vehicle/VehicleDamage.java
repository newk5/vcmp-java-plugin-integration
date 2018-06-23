package com.maxorator.vcmp.java.plugin.integration.vehicle;

@SuppressWarnings("unused")
public class VehicleDamage {

    public int damage;

    public VehicleDamage(int damage) {
        this.damage = damage;
    }

    private int getDoorShift(Door door) {
        switch (door) {
            case FrontLeft:
            case FrontRight:
            case RearLeft:
            case RearRight:
                return 2 * door.ordinal() + 4;
            case Bonnet:
            case Boot:
                return 2 * door.ordinal() + 8;
        }
        return 4;
    }

    private void setStatus(int shift, int value) {
        damage &= ~(3 << shift);
        damage |= value << shift;
    }

    public void setDoorStatus(Door door, DoorStatus doorStatus) {
        setStatus(getDoorShift(door), doorStatus.ordinal());
    }

    public DoorStatus getDoorStatus(Door door) {
        return DoorStatus.values()[(damage >>> getDoorShift(door)) & 3];
    }

    public enum DoorStatus {
        Undamaged,
        Damaged,
        Flapping,
        Detached
    }

    public enum Door {
        FrontLeft,
        FrontRight,
        RearLeft,
        RearRight,
        Bonnet,
        Boot
    }

    private int getPanelShift(Panel panel) {
        switch (panel) {
            case LeftWing:
                return 12;
            case RightWing:
                return 14;
            case FrontBumper:
                return 0;
            case RearBumper:
                return 2;
            case Windscreen:
                return 20;
        }
        return 12;
    }

    public void setPanelStatus(Panel panel, PanelStatus panelStatus) {
        setStatus(getPanelShift(panel), panelStatus.ordinal());
    }

    public PanelStatus getPanelStatus(Panel panel) {
        int value = (damage >>> getPanelShift(panel)) & 3;

        return PanelStatus.values()[Math.min(value, 2)];
    }

    public enum PanelStatus {
        Undamaged,
        Damaged,
        Detached
    }

    public enum Panel {
        LeftWing,
        RightWing,
        FrontBumper,
        RearBumper,
        Windscreen
    }

    private int getTyreShift(Tyre tyre) {
        return tyre.ordinal() * 2 + 22;
    }

    public void setTyreStatus(Tyre tyre, TyreStatus tyreStatus) {
        setStatus(getTyreShift(tyre), tyreStatus.ordinal());
        int shift = getTyreShift(tyre);
        damage &= ~(3 << shift);
        damage |= tyreStatus.ordinal() << shift;
    }

    public TyreStatus getTyreStatus(Tyre tyre) {
        int value = (damage >>> getTyreShift(tyre)) & 3;

        return TyreStatus.values()[Math.min(value, 2)];
    }

    public enum TyreStatus {
        Undamaged,
        Flat,
        Detached
    }

    public enum Tyre {
        LeftFront,
        LeftRear,
        RightFront,
        RightRear
    }
}
