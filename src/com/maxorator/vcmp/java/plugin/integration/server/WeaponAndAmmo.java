package com.maxorator.vcmp.java.plugin.integration.server;

public class WeaponAndAmmo {
    private int weaponId;
    private int ammo;

    public WeaponAndAmmo(int weaponId, int ammo) {
        this.weaponId = weaponId;
        this.ammo = ammo;
    }

    /**
     * @return the weaponId
     */
    public int getWeaponId() {
        return weaponId;
    }

    /**
     * @param weaponId the weaponId to set
     */
    public void setWeaponId(int weaponId) {
        this.weaponId = weaponId;
    }

    /**
     * @return the ammo
     */
    public int getAmmo() {
        return ammo;
    }

    /**
     * @param ammo the ammo to set
     */
    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }
}
