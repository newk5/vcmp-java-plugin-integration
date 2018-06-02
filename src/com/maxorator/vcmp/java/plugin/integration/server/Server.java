package com.maxorator.vcmp.java.plugin.integration.server;

import com.maxorator.vcmp.java.plugin.integration.RootEventHandler;
import com.maxorator.vcmp.java.plugin.integration.generic.Colour;
import com.maxorator.vcmp.java.plugin.integration.placeable.CheckPoint;
import com.maxorator.vcmp.java.plugin.integration.player.Player;
import com.maxorator.vcmp.java.plugin.integration.vehicle.Vehicle;
import com.maxorator.vcmp.java.plugin.integration.vehicle.VehicleColours;
import com.maxorator.vcmp.java.plugin.integration.placeable.GameObject;
import com.maxorator.vcmp.java.plugin.integration.placeable.Pickup;
import com.maxorator.vcmp.java.plugin.integration.vehicle.HandlingRule;
import com.maxorator.vcmp.java.plugin.integration.generic.Vector;

import java.io.IOException;

@SuppressWarnings("unused")
public interface Server {
    void reloadScript();

    boolean isUnloaded();

    SyncBlock sync() throws IOException;

    void rewireEvents(RootEventHandler handler, long usedEvents);

    boolean sendScriptData(Player recipient, byte[] data);

    void sendPluginCommand(int type, String command);

    void sendClientMessage(Player recipient, Colour colour, String message);

    void sendClientMessage(Player recipient, int colourHex, String message);

    void sendGameMessage(Player recipient, int type, String message);

    int getServerVersion();

    int getServerPort();

    void setServerName(String name);

    String getServerName();

    void setPlayerLimit(int playerLimit);

    int getPlayerLimit();

    void setServerPassword(String password);

    String getServerPassword();

    void setGameModeText(String gameMode);

    String getGameModeText();

    void shutdownServer();

    void setWorldBounds(MapBounds bounds);

    void setWorldBounds(float maxX, float minX, float maxY, float minY);

    MapBounds getWorldBounds();

    void setWastedSettings(WastedSettings settings);

    void setWastedSettings(int deathTimeMillis, int fadeTimeMillis, float fadeInSpeed, float fadeOutSpeed, int fadeColourHex, int corpseFadeStart, int corpseFadeDuration);

    WastedSettings getWastedSettings();

    void setTimeRate(int timeRate);

    int getTimeRate();

    void setHour(int hour);

    int getHour();

    void setMinute(int minute);

    int getMinute();

    void setWeather(int weather);

    int getWeather();

    void setGravity(float gravity);

    float getGravity();

    void setGameSpeed(float gameSpeed);

    float getGameSpeed();

    void setWaterLevel(float waterLevel);

    float getWaterLevel();

    void setAltitudeLimit(float altitudeLimit);

    float getAltitudeLimit();

    void setKillCommandDelay(int delayMillis);

    int getKillCommandDelay();

    void setVehiclesForcedRespawnAltitude(float height);

    float getVehiclesForcedRespawnAltitude();

    void setOption(ServerOption setting, boolean value);

    void setOption(int settingId, boolean value);

    boolean getOption(ServerOption setting);

    boolean getOption(int settingId);

    void createExplosion(int worldId, int type, Vector position, Player responsiblePlayer, boolean atGroundLevel);

    void createExplosion(int worldId, int type, float x, float y, float z, Player responsiblePlayer, boolean atGroundLevel);

    void playSound(int worldId, int soundId, Vector position);

    void playSound(int worldId, int soundId, float x, float y, float z);

    void hideMapObject(int modelId, Vector position);

    void hideMapObject(int modelId, float x, float y, float z);

    void showMapObject(int modelId, Vector position);

    void showMapObject(int modelId, float x, float y, float z);

    void showAllMapObjects();

    void setWeaponDataValue(int weaponId, WeaponField field, double value);

    void setWeaponDataValue(int weaponId, int fieldId, double value);

    double getWeaponDataValue(int weaponId, WeaponField field);

    double getWeaponDataValue(int weaponId, int fieldId);

    void resetWeaponDataValue(int weaponId, WeaponField field);

    void resetWeaponDataValue(int weaponId, int fieldId);

    boolean isWeaponDataValueModified(int weaponId, WeaponField field);

    boolean isWeaponDataValueModified(int weaponId, int fieldId);

    void resetWeaponData(int weaponId);

    void resetAllWeaponData();

    int getUnusedKeybindSlot();

    KeyBind getKeyBind(int keyBindId);

    boolean registerKeyBind(KeyBind keyBind);

    boolean registerKeyBind(int keyBindId, boolean onRelease, int keyOne, int keyTwo, int keyThree);

    boolean removeKeyBind(int keyBindId);

    void removeAllKeyBinds();

    int createCoordBlip(CoordBlipInfo info);

    int createCoordBlip(int index, int worldId, float x, float y, float z, int scale, int colourHex, int spriteId);

    void destroyCoordBlip(int index);

    CoordBlipInfo getCoordBlipInfo(int index);

    void addRadioStream(int radioId, String name, String url, boolean isListed);

    void removeRadioStream(int radioId);

    int addPlayerClass(int teamId, Colour colour, int modelId, Vector position, float angle, WeaponAndAmmo[] weapons);

    int addPlayerClass(int teamId, int colourHex, int modelId, float x, float y, float z, float angle, int weaponOne, int weaponOneAmmo, int weaponTwo, int weaponTwoAmmo, int weaponThree, int weaponThreeAmmo);

    void setSpawnScreenPlayerPos(Vector position);

    void setSpawnScreenPlayerPos(float x, float y, float z);

    void setSpawnScreenCameraPos(Vector position);

    void setSpawnScreenCameraPos(float x, float y, float z);

    void setSpawnScreenCameraLookAt(Vector position);

    void setSpawnScreenCameraLookAt(float x, float y, float z);

    void banAddress(String ip);

    void unbanAddress(String ip);

    boolean isAddressBanned(String ip);

    Player getPlayer(int index);

    Player[] getAllPlayers();

    Player findPlayer(String name);

    Vehicle createVehicle(int modelId, int worldId, Vector position, float angle, VehicleColours colours);

    Vehicle createVehicle(int modelId, int worldId, float x, float y, float z, float angle, int mainColour, int secondaryColour);

    Vehicle getVehicle(int index);

    Vehicle[] getAllVehicles();

    void resetAllVehicleHandlings();

    boolean handlingRuleExists(int modelId, HandlingRule rule);

    boolean handlingRuleExists(int modelId, int ruleIndex);

    void setHandlingRule(int modelId, HandlingRule rule, double value);

    void setHandlingRule(int modelId, int ruleIndex, double value);

    double getHandlingRule(int modelId, HandlingRule rule);

    double getHandlingRule(int modelId, int ruleIndex);

    void resetHandlingRule(int modelId, HandlingRule rule);

    void resetHandlingRule(int modelId, int ruleIndex);

    void resetHandling(int modelId);

    Pickup getPickup(int index);

    Pickup createPickup(int modelId, int worldId, int quantity, Vector position, int alpha, boolean automatic);

    Pickup createPickup(int modelId, int worldId, int quantity, float x, float y, float z, int alpha, boolean automatic);

    GameObject getObject(int index);

    GameObject createObject(int modelId, int worldId, Vector position, int alpha);

    GameObject createObject(int modelId, int worldId, float x, float y, float z, int alpha);

    CheckPoint getCheckPoint(int index);

    CheckPoint createCheckPoint(Player player, int worldId, boolean isSphere, Vector position, Colour colour, float radius);

    CheckPoint createCheckPoint(Player player, int worldId, boolean isSphere, float x, float y, float z, int r, int g, int b, int a, float radius);
}
