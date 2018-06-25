package com.maxorator.vcmp.java.plugin.integration.player;

import com.maxorator.vcmp.java.plugin.integration.generic.Colour;
import com.maxorator.vcmp.java.plugin.integration.generic.Entity;
import com.maxorator.vcmp.java.plugin.integration.vehicle.Vehicle;
import com.maxorator.vcmp.java.plugin.integration.generic.Vector;
import com.maxorator.vcmp.java.plugin.integration.placeable.GameObject;

@SuppressWarnings("unused")
public interface Player extends Entity {

    boolean isAdmin();

    void setAdmin(boolean isAdmin);

    String getIP();
    
    Vector getPos();

    void kick();

    void ban();

    void setSpeed(Double x, Double y, Double z);

    void setSpeed(Integer x, Integer y, Integer z);

    void addSpeed(Integer x, Integer y, Integer z);

    void addSpeed(Double x, Double y, Double z);

    void setHp(Integer hp);

    void setHp(Double hp);

    void setCameraPos(Double posX, Double posY, Double posZ, Double lookX, Double lookY, Double lookZ);

    void setCameraPos(Integer posX, Integer posY, Integer posZ, Integer lookX, Integer lookY, Integer lookZ);

    void setArmour(Integer armor);

    void setArmour(Double armor);

    void setPos(Integer x, Integer y, Integer z);

    void setPos(Double x, Double y, Double z);

    boolean isSpawned();

    boolean isStreamedForPlayer(Player player);

    long getUniqueId();

    void setWorld(int worldId);

    int getWorld();

    void setSecondaryWorld(int worldId);

    int getSecondaryWorld();

    int getUniqueWorld();

    boolean isCompatibleWithWorld(int worldId);

    int getState();

    String getName();

    boolean setName(String name);

    void setTeam(int teamId);

    int getTeam();

    void setSkin(int skinId);

    int getSkin();
    
    void requestModuleList();

    void setColour(Colour colour);

    void setColour(int colour);

    Colour getColour();

    int getColourHex();

    void forceSpawn();

    void forceSelect();

    void giveMoney(int amount);

    void setMoney(int amount);

    int getMoney();

    void setScore(int score);

    int getScore();

    int getPing();

    boolean isTyping();

    double getFPS();

    String getUID();

    String getUID2();

    void setHealth(float health);

    float getHealth();

    void setArmour(float armour);

    float getArmour();

    void setImmunities(PlayerImmunity vehicleImmunity);

    void setImmunityFlags(int flags);

    PlayerImmunity getImmunities();

    int getImmunityFlags();

    Vector getPosition();

    void setPosition(Vector position);

    void setPosition(float x, float y, float z);

    Vector getSpeed();

    void setSpeed(Vector speed);

    void setSpeed(float x, float y, float z);

    void addSpeed(Vector speed);

    void addSpeed(float x, float y, float z);

    void setHeading(float heading);

    float getHeading();

    void setAlpha(int alpha, int fadeTime);

    int getAlpha();

    boolean isOnFire();

    boolean isCrouching();

    int getAction();

    int getGameKeys();

    Vector getAimPosition();

    Vector getAimDirection();

    boolean putInVehicle(Vehicle vehicle, int slot, boolean makeRoom, boolean warp);

    boolean removeFromVehicle();

    int getInVehicleStatus();

    int getInVehicleSlot();

    Vehicle getVehicle();

    void setOption(PlayerOption setting, boolean value);

    void setOption(int settingId, boolean value);

    boolean getOption(PlayerOption setting);

    boolean getOption(int settingId);

    void giveWeapon(int weaponId, int ammo);

    void setWeapon(int weaponId, int ammo);
    
    int getWeapon();

    int getWeaponAmmo();

    void setWeaponSlot(int slot);

    int getWeaponSlot();

    int getWeaponAtSlot(int slot);

    int getAmmoAtSlot(int slot);

    void removeWeapon(int weaponId);

    void removeAllWeapons();

    void setCameraPosition(Vector position, Vector look);

    void setCameraPosition(float posX, float posY, float posZ, float lookX, float lookY, float lookZ);

    void restoreCamera();

    boolean isCameraLocked();

    void setAnimation(int groupId, int animationId);

    void setWantedLevel(int wantedLevel);

    int getWantedLevel();

    Vehicle getStandingOnVehicle();

    GameObject getStandingOnObject();

    boolean isAway();

    Player getSpectateTarget();

    void setSpectateTarget(Player target);

    int getPlayerClass();

    void redirectToServer(String address, int port, String nick, String serverPassword, String userPassword);
}
