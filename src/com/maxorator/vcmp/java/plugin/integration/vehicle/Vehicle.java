package com.maxorator.vcmp.java.plugin.integration.vehicle;

import com.maxorator.vcmp.java.plugin.integration.generic.Entity;
import com.maxorator.vcmp.java.plugin.integration.generic.Quaternion;
import com.maxorator.vcmp.java.plugin.integration.generic.Rotation2d;
import com.maxorator.vcmp.java.plugin.integration.generic.Vector;
import com.maxorator.vcmp.java.plugin.integration.player.Player;

@SuppressWarnings("unused")
public interface Vehicle extends Entity {
    void delete();

    Player getSyncController();

    VehicleSyncReason getSyncReason();

    int getSyncReasonOrdinal();

    boolean isStreamedForPlayer(Player player);

    void setWorld(int worldId);

    int getWorld();

    int getLightsData();

    void setLightsData(int val);

    int getModel();

    void setTaxiLight(boolean b);

    boolean getTaxiLight();

    Player getOccupant(int slot);

    void respawn();

    void setImmunities(VehicleImmunity vehicleImmunity);

    void setImmunityFlags(int flags);

    VehicleImmunity getImmunities();

    int getImmunityFlags();

    void detonate();

    boolean isWrecked();

    void setPosition(Vector position);

    void setPosition(float x, float y, float z);

    Vector getPosition();

    void setRotation(Quaternion rotation);

    void setRotation(float x, float y, float z, float w);

    Quaternion getRotation();

    void setRotation(Vector rotation);

    void setRotationEuler(float x, float y, float z);

    Vector getRotationEuler();

    void setSpeed(Vector speed, boolean add, boolean relative);

    void setSpeed(float x, float y, float z, boolean add, boolean relative);

    Vector getSpeed(boolean relative);

    void setTurnSpeed(Vector speed, boolean add, boolean relative);

    void setTurnSpeed(float x, float y, float z, boolean add, boolean relative);

    Vector getTurnSpeed(boolean relative);

    void setSpawnPosition(Vector position);

    void setSpawnPosition(float x, float y, float z);

    Vector getSpawnPosition();

    void setSpawnRotation(Quaternion rotation);

    void setSpawnRotation(float x, float y, float z, float w);

    Quaternion getSpawnRotation();

    void setSpawnRotation(Vector rotation);

    void setSpawnRotationEuler(float x, float y, float z);

    Vector getSpawnRotationEuler();

    void setIdleRespawnTimeout(int millis);

    int getIdleRespawnTimeout();

    void setHealth(float health);

    float getHealth();

    void setColours(VehicleColours colours);

    void setColours(int primary, int secondary);

    VehicleColours getColours();

    void setOption(VehicleOption setting, boolean value);

    void setOption(int settingId, boolean value);

    boolean getOption(VehicleOption setting);

    boolean getOption(int settingId);

    VehicleDamage getDamage();

    int getDamageHex();

    void setDamage(VehicleDamage damage);

    void setDamage(int damageHex);

    void setRadio(int radioId);

    int getRadio();

    Rotation2d getTurrentRotation();

    boolean handlingRuleExists(HandlingRule rule);

    boolean handlingRuleExists(int ruleIndex);

    void setHandlingRule(HandlingRule rule, double value);

    void setHandlingRule(int ruleIndex, double value);

    double getHandlingRule(HandlingRule rule);

    double getHandlingRule(int ruleIndex);

    void resetHandlingRule(HandlingRule rule);

    void resetHandlingRule(int ruleIndex);

    void resetHandling();
}
