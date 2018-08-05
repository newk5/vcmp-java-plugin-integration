package com.maxorator.vcmp.java.plugin.integration.vehicle;

public class VehicleColours {
    private int primary;
    private int secondary;

    public VehicleColours(int primary, int secondary) {
        this.primary = primary;
        this.secondary = secondary;
    }

    /**
     * @return the primary
     */
    public int getPrimary() {
        return primary;
    }

    /**
     * @param primary the primary to set
     */
    public void setPrimary(int primary) {
        this.primary = primary;
    }

    /**
     * @return the secondary
     */
    public int getSecondary() {
        return secondary;
    }

    /**
     * @param secondary the secondary to set
     */
    public void setSecondary(int secondary) {
        this.secondary = secondary;
    }
}
