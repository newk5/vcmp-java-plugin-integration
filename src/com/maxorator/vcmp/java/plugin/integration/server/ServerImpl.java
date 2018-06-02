package com.maxorator.vcmp.java.plugin.integration.server;

import com.maxorator.vcmp.java.plugin.integration.RootEventHandler;
import com.maxorator.vcmp.java.plugin.integration.generic.Colour;
import com.maxorator.vcmp.java.plugin.integration.generic.Vector;
import com.maxorator.vcmp.java.plugin.integration.placeable.CheckPoint;
import com.maxorator.vcmp.java.plugin.integration.placeable.GameObject;
import com.maxorator.vcmp.java.plugin.integration.placeable.Pickup;
import com.maxorator.vcmp.java.plugin.integration.player.Player;
import com.maxorator.vcmp.java.plugin.integration.vehicle.HandlingRule;
import com.maxorator.vcmp.java.plugin.integration.vehicle.Vehicle;
import com.maxorator.vcmp.java.plugin.integration.vehicle.VehicleColours;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

@SuppressWarnings("unused")
public class ServerImpl implements Server {

    private final LinkedBlockingQueue<SyncBlock> waitingBlocks;
    private final Thread initialThread;
    private volatile boolean unloaded;

    protected ServerImpl() {
        this.waitingBlocks = new LinkedBlockingQueue<>();
        this.initialThread = Thread.currentThread();
        this.unloaded = false;
    }

    @Override
    public native void reloadScript();

    @Override
    public boolean isUnloaded() {
        return unloaded;
    }

    public void setUnloaded() {
        unloaded = true;
    }

    public void runSyncBlocks() {
        SyncBlock block;

        while ((block = waitingBlocks.poll()) != null) {
            block.start();

            while (true) {
                try {
                    block.waitForFinish();
                    break;
                } catch (InterruptedException e) {
                    Thread.interrupted();
                }
            }
        }
    }

    public native void startThreadSynced();

    public native void endThreadSynced();

    protected void checkUnloaded() throws IOException {
        if (unloaded) {
            throw new IOException("Entering synchronize block in terminated script context.");
        }
    }

    @Override
    public SyncBlock sync() throws IOException {
        if (Thread.currentThread().getId() == initialThread.getId()) {
            return new SyncBlock(this);
        }

        checkUnloaded();

        SyncBlock block = new SyncBlock(this);
        waitingBlocks.offer(block);

        while (true) {
            try {
                if (block.waitForSync()) {
                    break;
                }
            } catch (InterruptedException e) {
                Thread.interrupted();
            }

            checkUnloaded();
        }

        return block;
    }

    @Override
    public native void rewireEvents(RootEventHandler handler, long usedEvents);

    @Override
    public native boolean sendScriptData(Player recipient, byte[] data);

    @Override
    public native void sendPluginCommand(int type, String command);

    @Override
    public void sendClientMessage(Player recipient, Colour colour, String message) {
        sendClientMessage(recipient, colour.getHex(), message);
    }

    @Override
    public native void sendClientMessage(Player recipient, int colourHex, String message);

    @Override
    public native void sendGameMessage(Player recipient, int type, String message);

    @Override
    public native int getServerVersion();

    @Override
    public native int getServerPort();

    @Override
    public native void setServerName(String name);

    @Override
    public native String getServerName();

    @Override
    public native void setPlayerLimit(int playerLimit);

    @Override
    public native int getPlayerLimit();

    @Override
    public native void setServerPassword(String password);

    @Override
    public native String getServerPassword();

    @Override
    public native void setGameModeText(String gameMode);

    @Override
    public native String getGameModeText();

    @Override
    public native void shutdownServer();

    @Override
    public void setWorldBounds(MapBounds bounds) {
        setWorldBounds(bounds.maxX, bounds.minX, bounds.maxY, bounds.minY);
    }

    @Override
    public native void setWorldBounds(float maxX, float minX, float maxY, float minY);

    @Override
    public native MapBounds getWorldBounds();

    @Override
    public void setWastedSettings(WastedSettings settings) {
        setWastedSettings(settings.deathTimeMillis, settings.fadeTimeMillis, settings.fadeInSpeed, settings.fadeOutSpeed, settings.fadeColour.getHex(), settings.corpseFadeStart, settings.corpseFadeDuration);
    }

    @Override
    public native void setWastedSettings(int deathTimeMillis, int fadeTimeMillis, float fadeInSpeed, float fadeOutSpeed, int fadeColourHex, int corpseFadeStart, int corpseFadeDuration);

    @Override
    public native WastedSettings getWastedSettings();

    @Override
    public native void setTimeRate(int timeRate);

    @Override
    public native int getTimeRate();

    @Override
    public native void setHour(int hour);

    @Override
    public native int getHour();

    @Override
    public native void setMinute(int minute);

    @Override
    public native int getMinute();

    @Override
    public native void setWeather(int weather);

    @Override
    public native int getWeather();

    @Override
    public native void setGravity(float gravity);

    @Override
    public native float getGravity();

    @Override
    public native void setGameSpeed(float gameSpeed);

    @Override
    public native float getGameSpeed();

    @Override
    public native void setWaterLevel(float waterLevel);

    @Override
    public native float getWaterLevel();

    @Override
    public native void setAltitudeLimit(float altitudeLimit);

    @Override
    public native float getAltitudeLimit();

    @Override
    public native void setKillCommandDelay(int delayMillis);

    @Override
    public native int getKillCommandDelay();

    @Override
    public native void setVehiclesForcedRespawnAltitude(float height);

    @Override
    public native float getVehiclesForcedRespawnAltitude();

    @Override
    public void setOption(ServerOption setting, boolean value) {
        setOption(setting.ordinal(), value);
    }

    @Override
    public native void setOption(int settingId, boolean value);

    @Override
    public boolean getOption(ServerOption setting) {
        return getOption(setting.ordinal());
    }

    @Override
    public native boolean getOption(int settingId);

    @Override
    public void createExplosion(int worldId, int type, Vector position, Player responsiblePlayer, boolean atGroundLevel) {
        createExplosion(worldId, type, position.x, position.y, position.z, responsiblePlayer, atGroundLevel);
    }

    @Override
    public native void createExplosion(int worldId, int type, float x, float y, float z, Player responsiblePlayer, boolean atGroundLevel);

    @Override
    public void playSound(int worldId, int soundId, Vector position) {
        playSound(worldId, soundId, position.x, position.y, position.z);
    }

    @Override
    public native void playSound(int worldId, int soundId, float x, float y, float z);

    @Override
    public void hideMapObject(int modelId, Vector position) {
        hideMapObject(modelId, position.x, position.y, position.z);
    }

    @Override
    public native void hideMapObject(int modelId, float x, float y, float z);

    @Override
    public void showMapObject(int modelId, Vector position) {
        showMapObject(modelId, position.x, position.y, position.z);
    }

    @Override
    public native void showMapObject(int modelId, float x, float y, float z);

    @Override
    public native void showAllMapObjects();

    @Override
    public void setWeaponDataValue(int weaponId, WeaponField field, double value) {
        setWeaponDataValue(weaponId, field.ordinal(), value);
    }

    @Override
    public native void setWeaponDataValue(int weaponId, int fieldId, double value);

    @Override
    public double getWeaponDataValue(int weaponId, WeaponField field) {
        return getWeaponDataValue(weaponId, field.ordinal());
    }

    @Override
    public native double getWeaponDataValue(int weaponId, int fieldId);

    @Override
    public void resetWeaponDataValue(int weaponId, WeaponField field) {
        resetWeaponDataValue(weaponId, field.ordinal());
    }

    @Override
    public native void resetWeaponDataValue(int weaponId, int fieldId);

    @Override
    public boolean isWeaponDataValueModified(int weaponId, WeaponField field) {
        return isWeaponDataValueModified(weaponId, field.ordinal());
    }

    @Override
    public native boolean isWeaponDataValueModified(int weaponId, int fieldId);

    @Override
    public native void resetWeaponData(int weaponId);

    @Override
    public native void resetAllWeaponData();

    @Override
    public native int getUnusedKeybindSlot();

    @Override
    public native KeyBind getKeyBind(int keyBindId);

    @Override
    public boolean registerKeyBind(KeyBind keyBind) {
        return registerKeyBind(keyBind.id, keyBind.onRelease, keyBind.keys[0], keyBind.keys[1], keyBind.keys[2]);
    }

    @Override
    public native boolean registerKeyBind(int keyBindId, boolean onRelease, int keyOne, int keyTwo, int keyThree);

    @Override
    public native boolean removeKeyBind(int keyBindId);

    @Override
    public native void removeAllKeyBinds();

    @Override
    public int createCoordBlip(CoordBlipInfo info) {
        return createCoordBlip(info.index, info.worldId, info.position.x, info.position.y, info.position.z, info.scale, info.colour.getHex(), info.spriteId);
    }

    @Override
    public native int createCoordBlip(int index, int worldId, float x, float y, float z, int scale, int colourHex, int spriteId);

    @Override
    public native void destroyCoordBlip(int index);

    @Override
    public native CoordBlipInfo getCoordBlipInfo(int index);

    @Override
    public native void addRadioStream(int radioId, String name, String url, boolean isListed);

    @Override
    public native void removeRadioStream(int radioId);

    @Override
    public int addPlayerClass(int teamId, Colour colour, int modelId, Vector position, float angle, WeaponAndAmmo[] weapons) {
        WeaponAndAmmo[] defaults = new WeaponAndAmmo[]{new WeaponAndAmmo(0, 0), new WeaponAndAmmo(0, 0), new WeaponAndAmmo(0, 0)};

        for (int i = 0; i < defaults.length && i < weapons.length; i++) {
            defaults[i] = weapons[i];
        }

        return addPlayerClass(teamId, colour.getHex(), modelId, position.x, position.y, position.z, angle, defaults[0].weaponId, defaults[0].ammo, defaults[1].weaponId, defaults[1].ammo, defaults[2].weaponId, defaults[2].ammo);
    }

    @Override
    public native int addPlayerClass(int teamId, int colourHex, int modelId, float x, float y, float z, float angle, int weaponOne, int weaponOneAmmo, int weaponTwo, int weaponTwoAmmo, int weaponThree, int weaponThreeAmmo);

    @Override
    public void setSpawnScreenPlayerPos(Vector position) {
        setSpawnScreenPlayerPos(position.x, position.y, position.z);
    }

    @Override
    public native void setSpawnScreenPlayerPos(float x, float y, float z);

    @Override
    public void setSpawnScreenCameraPos(Vector position) {
        setSpawnScreenCameraPos(position.x, position.y, position.z);
    }

    @Override
    public native void setSpawnScreenCameraPos(float x, float y, float z);

    @Override
    public void setSpawnScreenCameraLookAt(Vector position) {
        setSpawnScreenCameraLookAt(position.x, position.y, position.z);
    }

    @Override
    public native void setSpawnScreenCameraLookAt(float x, float y, float z);

    @Override
    public native void banAddress(String ip);

    @Override
    public native void unbanAddress(String ip);

    @Override
    public native boolean isAddressBanned(String ip);

    @Override
    public native Player getPlayer(int index);

    @Override
    public native Player[] getAllPlayers();

    @Override
    public native Player findPlayer(String name);

    @Override
    public Vehicle createVehicle(int modelId, int worldId, Vector position, float angle, VehicleColours colours) {
        Vehicle v = createVehicle(modelId, worldId, position.x, position.y, position.z, angle, colours.primary, colours.secondary);
        v.clearData();
        return v;
    }

    @Deprecated
    @Override
    public native Vehicle createVehicle(int modelId, int worldId, float x, float y, float z, float angle, int mainColour, int secondaryColour);

    @Override
    public native Vehicle getVehicle(int index);

    @Override
    public native Vehicle[] getAllVehicles();

    @Override
    public native void resetAllVehicleHandlings();

    @Override
    public boolean handlingRuleExists(int modelId, HandlingRule rule) {
        return handlingRuleExists(modelId, rule.ordinal());
    }

    @Override
    public native boolean handlingRuleExists(int modelId, int ruleIndex);

    @Override
    public void setHandlingRule(int modelId, HandlingRule rule, double value) {
        setHandlingRule(modelId, rule.ordinal(), value);
    }

    @Override
    public native void setHandlingRule(int modelId, int ruleIndex, double value);

    @Override
    public double getHandlingRule(int modelId, HandlingRule rule) {
        return getHandlingRule(modelId, rule.ordinal());
    }

    @Override
    public native double getHandlingRule(int modelId, int ruleIndex);

    @Override
    public void resetHandlingRule(int modelId, HandlingRule rule) {
        resetHandlingRule(modelId, rule.ordinal());
    }

    @Override
    public native void resetHandlingRule(int modelId, int ruleIndex);

    @Override
    public native void resetHandling(int modelId);

    @Override
    public native Pickup getPickup(int index);

    @Override
    public Pickup createPickup(int modelId, int worldId, int quantity, Vector position, int alpha, boolean automatic) {
        Pickup p = createPickup(modelId, worldId, quantity, position.x, position.y, position.z, alpha, automatic);
        p.clearData();
        return p;
    }

    @Deprecated
    @Override
    public native Pickup createPickup(int modelId, int worldId, int quantity, float x, float y, float z, int alpha, boolean automatic);

    @Override
    public native GameObject getObject(int index);

    @Override
    public GameObject createObject(int modelId, int worldId, Vector position, int alpha) {
        GameObject go = createObject(modelId, worldId, position.x, position.y, position.z, alpha);
        go.clearData();
        return go;
    }

    @Deprecated
    @Override
    public native GameObject createObject(int modelId, int worldId, float x, float y, float z, int alpha);

    @Override
    public native CheckPoint getCheckPoint(int index);

    @Override
    public CheckPoint createCheckPoint(Player player, int worldId, boolean isSphere, Vector position, Colour colour, float radius) {
        CheckPoint cp = createCheckPoint(player, worldId, isSphere, position.x, position.y, position.z, colour.red, colour.green, colour.blue, colour.alpha, radius);
        cp.clearData();
        return cp;
    }

    @Deprecated
    @Override
    public native CheckPoint createCheckPoint(Player player, int worldId, boolean isSphere, float x, float y, float z, int r, int g, int b, int a, float radius);

}
