package com.maxorator.vcmp.java.plugin.integration.vehicle;

import com.maxorator.vcmp.java.plugin.integration.generic.EntityImpl;
import com.maxorator.vcmp.java.plugin.integration.generic.Quaternion;
import com.maxorator.vcmp.java.plugin.integration.generic.Rotation2d;
import com.maxorator.vcmp.java.plugin.integration.player.Player;
import com.maxorator.vcmp.java.plugin.integration.generic.Vector;

@SuppressWarnings("unused")
public class VehicleImpl extends EntityImpl implements Vehicle {

    VehicleImpl(int id) {
        super(id);
    }

    @Override
    public native void delete();

    @Override
    public native Player getSyncController();

    @Override
    public VehicleSyncReason getSyncReason() {
        return VehicleSyncReason.values()[getSyncReasonOrdinal()];
    }

    @Override
    public Vector getPos() {
        return getPosition();
    }

    @Override
    public void setPos(Integer x, Integer y, Integer z) {
        setPosition(new Float(x), new Float(y), new Float(z));
    }

    @Override
    public void setRotation(Double x, Double y, Double z, Double w) {
        setRotation(new Float(x), new Float(y), new Float(z), new Float(w));
    }

    @Override
    public void setRotation(Integer x, Integer y, Integer z, Integer w) {
        setRotation(new Float(x), new Float(y), new Float(z), new Float(w));
    }

    @Override
    public void setPos(Double x, Double y, Double z) {
        setPosition(new Float(x), new Float(y), new Float(z));
    }

    @Override
    public native int getSyncReasonOrdinal();

    @Override
    public native boolean isStreamedForPlayer(Player player);

    @Override
    public native void setWorld(int worldId);

    @Override
    public native int getWorld();

    @Override
    public native int getModel();

    @Override
    public native Player getOccupant(int slot);

    @Override
    public native void respawn();

    @Override
    public void setImmunities(VehicleImmunity vehicleImmunity) {
        setImmunityFlags(vehicleImmunity.getHex());
    }

    @Override
    public native void setImmunityFlags(int flags);

    @Override
    public VehicleImmunity getImmunities() {
        return new VehicleImmunity(getImmunityFlags());
    }

    @Override
    public native int getImmunityFlags();

    @Override
    public native void detonate();

    @Override
    public native boolean isWrecked();

    @Override
    public void setPosition(Vector position) {
        setPosition(position.getX(), position.getY(), position.getZ());
    }

    @Override
    public native void setPosition(float x, float y, float z);

    @Override
    public native Vector getPosition();

    @Override
    public void setRotation(Quaternion rotation) {
        setRotation(rotation.getX(), rotation.getY(), rotation.getZ(), rotation.getW());
    }

    public native void setRotation(float x, float y, float z, float w);

    @Override
    public native Quaternion getRotation();

    @Override
    public void setRotation(Vector rotation) {
        setRotationEuler(rotation.getX(), rotation.getY(), rotation.getZ());
    }

    @Override
    public native void setRotationEuler(float x, float y, float z);

    @Override
    public void setRotationEuler(Double x, Double y, Double z) {
        setRotationEuler(new Float(x), new Float(y), new Float(z));
    }

    @Override
    public void setRotationEuler(Integer x, Integer y, Integer z) {
        setRotationEuler(new Float(x), new Float(y), new Float(z));
    }

    @Override
    public native Vector getRotationEuler();

    @Override
    public void setSpeed(Vector speed, boolean add, boolean relative) {
        setSpeed(speed.getX(), speed.getY(), speed.getZ(), add, relative);
    }

    @Override
    public native void setSpeed(float x, float y, float z, boolean add, boolean relative);

    @Override
    public void setSpeed(Integer x, Integer y, Integer z, boolean add, boolean relative) {
        setSpeed(new Float(x), new Float(y), new Float(z), add, relative);
    }

    @Override
    public void setSpeed(Double x, Double y, Double z, boolean add, boolean relative) {
        setSpeed(new Float(x), new Float(y), new Float(z), add, relative);
    }

    @Override
    public native Vector getSpeed(boolean relative);

    @Override
    public void setTurnSpeed(Vector speed, boolean add, boolean relative) {
        setTurnSpeed(speed.getX(), speed.getY(), speed.getZ(), add, relative);
    }

    @Override
    public native void setTurnSpeed(float x, float y, float z, boolean add, boolean relative);

    @Override
    public void setTurnSpeed(Double x, Double y, Double z, boolean add, boolean relative) {
        setTurnSpeed(new Float(x), new Float(y), new Float(z), add, relative);
    }

    @Override
    public void setTurnSpeed(Integer x, Integer y, Integer z, boolean add, boolean relative) {
        setTurnSpeed(new Float(x), new Float(y), new Float(z), add, relative);
    }

    @Override
    public native Vector getTurnSpeed(boolean relative);

    @Override
    public void setSpawnPosition(Vector position) {
        setSpawnPosition(position.getX(), position.getY(), position.getZ());
    }

    @Override
    public native void setSpawnPosition(float x, float y, float z);

    @Override
    public void setSpawnPos(Double x, Double y, Double z) {
        setSpawnPosition(new Vector(x, y, z));
    }

    @Override
    public void setSpawnPos(Integer x, Integer y, Integer z) {
        setSpawnPosition(new Vector(x, y, z));
    }

    @Override
    public native Vector getSpawnPosition();

    @Override
    public void setSpawnRotation(Quaternion rotation) {
        setSpawnRotation(rotation.getX(), rotation.getY(), rotation.getZ(), rotation.getW());
    }

    @Override
    public native void setSpawnRotation(float x, float y, float z, float w);

    @Override
    public void setSpawnRotation(Double x, Double y, Double z, Double w) {
        setSpawnRotation(new Quaternion(x, y, z, w));
    }

    @Override
    public void setSpawnRotation(Integer x, Integer y, Integer z, Integer w) {
        setSpawnRotation(new Quaternion(x, y, z, w));
    }

    @Override
    public native Quaternion getSpawnRotation();

    @Override
    public void setSpawnRotation(Vector rotation) {
        setSpawnRotationEuler(rotation.getX(), rotation.getY(), rotation.getZ());
    }

    @Override
    public native void setSpawnRotationEuler(float x, float y, float z);

    @Override
    public void setSpawnRotationEuler(Double x, Double y, Double z) {
        setSpawnRotationEuler(new Float(x), new Float(y), new Float(z));
    }

    @Override
    public void setSpawnRotationEuler(Integer x, Integer y, Integer z) {
        setSpawnRotationEuler(new Float(x), new Float(y), new Float(z));
    }

    @Override
    public native Vector getSpawnRotationEuler();

    @Override
    public native void setIdleRespawnTimeout(int millis);

    @Override
    public native int getIdleRespawnTimeout();

    @Override
    public native void setHealth(float health);

    @Override
    public native float getHealth();

  

    @Override
    public float getHP() {
        return getHealth();
    }

    @Override
    public void setHP(Integer hp) {
        Float f = new Float(hp + "");
        setHealth(f);
    }
    @Override
    public void setHP(Double hp) {
        Float f = new Float(hp + "");
        setHealth(f);
    }

    @Override
    public void setColours(VehicleColours colours) {
        setColours(colours.getPrimary(), colours.getSecondary());
    }

    @Override
    public native void setColours(int primary, int secondary);

    @Override
    public native VehicleColours getColours();

    @Override
    public void setOption(VehicleOption setting, boolean value) {
        setOption(setting.ordinal(), value);
    }

    @Override
    public native void setOption(int settingId, boolean value);

    @Override
    public native int getLightsData();

    @Override
    public native void setLightsData(int val);

    @Override
    public boolean getOption(VehicleOption setting) {
        return getOption(setting.ordinal());
    }

    @Override
    public void setTaxiLight(boolean b) {
        if (b == (getTaxiLight() != false)) {
            return;
        }
        int vl = getLightsData();
        if (b) {
            vl |= (1 << 8);
        } else {
            vl &= ~(1 << 8);
        }
        setLightsData(vl);
    }

    @Override
    public boolean getTaxiLight() {
        return (getLightsData() & (1 << 8)) != 0;
    }

    @Override
    public native boolean getOption(int settingId);

    @Override
    public VehicleDamage getDamage() {
        return new VehicleDamage(getDamageHex());
    }

    @Override
    public native int getDamageHex();

    @Override
    public void setDamage(VehicleDamage damage) {
        setDamage(damage.getDamage());
    }

    @Override
    public native void setDamage(int damageHex);

    @Override
    public native void setRadio(int radioId);

    @Override
    public native int getRadio();

    @Override
    public native Rotation2d getTurrentRotation();

    @Override
    public boolean handlingRuleExists(HandlingRule rule) {
        return handlingRuleExists(rule.ordinal());
    }

    @Override
    public native boolean handlingRuleExists(int ruleIndex);

    @Override
    public void setHandlingRule(HandlingRule rule, double value) {
        setHandlingRule(rule.ordinal(), value);
    }

    @Override
    public native void setHandlingRule(int ruleIndex, double value);

    @Override
    public double getHandlingRule(HandlingRule rule) {
        return getHandlingRule(rule.ordinal());
    }

    @Override
    public native double getHandlingRule(int ruleIndex);

    @Override
    public void resetHandlingRule(HandlingRule rule) {
        resetHandlingRule(rule.ordinal());
    }

    @Override
    public native void resetHandlingRule(int ruleIndex);

    @Override
    public native void resetHandling();

    @Override
    public boolean hasOption(int settingId) {
       return getOption(settingId);
    }
}
