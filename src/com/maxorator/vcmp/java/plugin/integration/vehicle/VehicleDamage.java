package com.maxorator.vcmp.java.plugin.integration.vehicle;

@SuppressWarnings("unused")
public class VehicleDamage {

    private int damage;

    public VehicleDamage(int damage) {
        this.damage = damage;
    }

    public VehicleDamage(Double damage) {
        this.damage = damage.intValue();
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

    public int getDoorShift(int door) {

        if (door == Door.FrontLeft.ordinal()
                || door == Door.FrontRight.ordinal()
                || door == Door.RearLeft.ordinal()
                || door == Door.RearRight.ordinal()) {
            return 2 * door + 4;
        } else if (door == Door.Bonnet.ordinal() || door == Door.Boot.ordinal()) {
            return 2 * door + 8;
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

    public void setDoorStatus(int door, int doorStatus) {
        setStatus(getDoorShift(door), doorStatus);
    }

    public DoorStatus getDoorStatus(Door door) {
        return DoorStatus.values()[(damage >>> getDoorShift(door)) & 3];
    }

    public DoorStatus getDoorStatus(int door) {
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

    private int getPanelShift(int panel) {
        if (panel == Panel.LeftWing.ordinal()) {
            return 12;
        } else if (panel == Panel.RightWing.ordinal()) {
            return 14;
        } else if (panel == Panel.FrontBumper.ordinal()) {
            return 0;
        } else if (panel == Panel.RearBumper.ordinal()) {
            return 2;
        } else if (panel == Panel.Windscreen.ordinal()) {
            return 20;
        }

        return 12;

    }

    public void setPanelStatus(Panel panel, PanelStatus panelStatus) {
        setStatus(getPanelShift(panel), panelStatus.ordinal());
    }

    public void setPanelStatus(int panel, int panelStatus) {
        setStatus(getPanelShift(panel), panelStatus);
    }

    public PanelStatus getPanelStatus(Panel panel) {
        int value = (damage >>> getPanelShift(panel)) & 3;

        return PanelStatus.values()[Math.min(value, 2)];
    }

    public PanelStatus getPanelStatus(int panel) {
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

    private int getTyreShift(int tyre) {
        return tyre * 2 + 22;
    }

    public void setTyreStatus(Tyre tyre, TyreStatus tyreStatus) {
        setStatus(getTyreShift(tyre), tyreStatus.ordinal());
        int shift = getTyreShift(tyre);
        damage &= ~(3 << shift);
        damage |= tyreStatus.ordinal() << shift;
    }

    public void setTyreStatus(int tyre, int tyreStatus) {
        setStatus(getTyreShift(tyre), tyreStatus);
        int shift = getTyreShift(tyre);
        damage &= ~(3 << shift);
        damage |= tyreStatus << shift;
    }

    public TyreStatus getTyreStatus(Tyre tyre) {
        int value = (damage >>> getTyreShift(tyre)) & 3;

        return TyreStatus.values()[Math.min(value, 2)];
    }

    public TyreStatus getTyreStatus(int tyre) {
        int value = (damage >>> getTyreShift(tyre)) & 3;

        return TyreStatus.values()[Math.min(value, 2)];
    }

    /**
     * @return the damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * @param damage the damage to set
     */
    public void setDamage(int damage) {
        this.damage = damage;
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
