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
    public void sendClientMsg(Player recipient, Object colour, String message) {
        if (colour instanceof Integer) {
            sendClientMessage(recipient, (int) colour, message);
        } else {
            sendClientMessage(recipient, (Colour) colour, message);
        }
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
    public native void setWorldBounds(float maxX, float minX, float maxY, float minY);

    @Override
    public void setWorldBounds(MapBounds bounds) {
        setWorldBounds(bounds.getMaxX(), bounds.getMinX(), bounds.getMaxY(), bounds.getMinY());
    }

    @Override
    public native MapBounds getWorldBounds();

    @Override
    public native void setWastedSettings(int deathTimeMillis, int fadeTimeMillis, float fadeInSpeed, float fadeOutSpeed, int fadeColourHex, int corpseFadeStart, int corpseFadeDuration);

    @Override
    public void setWastedSettings(WastedSettings settings) {
        setWastedSettings(settings.getDeathTimeMillis(), settings.getFadeTimeMillis(), settings.getFadeInSpeed(), settings.getFadeOutSpeed(), settings.getFadeColour().getHex(), settings.getCorpseFadeStart(), settings.getCorpseFadeDuration());
    }

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
    public native void setFallTimer(int ms);

    @Override
    public native int getFallTimer();

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
    public native void createExplosion(int worldId, int type, float x, float y, float z, Player responsiblePlayer, boolean atGroundLevel);

    @Override
    public void createExplosion(int worldId, int type, Vector position, Player responsiblePlayer, boolean atGroundLevel) {
        createExplosion(worldId, type, position.getX(), position.getY(), position.getZ(), responsiblePlayer, atGroundLevel);
    }

    @Override
    public native void playSound(int worldId, int soundId, float x, float y, float z);

    @Override
    public void playSound(int worldId, int soundId, Vector position) {
        playSound(worldId, soundId, position.getX(), position.getY(), position.getZ());
    }

    @Override
    public native void hideMapObject(int modelId, float x, float y, float z);

    @Override
    public void hideMapObject(int modelId, Vector position) {
        hideMapObject(modelId, position.getX(), position.getY(), position.getZ());
    }

    @Override
    public native void showMapObject(int modelId, float x, float y, float z);

    @Override
    public void showMapObject(int modelId, Vector position) {
        showMapObject(modelId, position.getX(), position.getY(), position.getZ());
    }

    @Override
    public native void showAllMapObjects();

    @Override
    public void setWeaponDataValue(int weaponId, WeaponField field, double value) {
        setWeaponDataValue(weaponId, field.ordinal(), value);
    }

    @Override
    public void setWeaponValue(int wepId, int fieldId, Object val) {
        setWeaponDataValue(wepId, fieldId, (double) val);
    }

    @Override
    public native void setWeaponDataValue(int weaponId, int fieldId, double value);

    @Override
    public double getWeaponDataValue(int weaponId, WeaponField field) {
        return getWeaponDataValue(weaponId, field.ordinal());
    }

    @Override
    public double getWeaponValue(int weaponId, int field) {
        return getWeaponDataValue(weaponId, field);
    }

    @Override
    public native double getWeaponDataValue(int weaponId, int fieldId);

    @Override
    public void resetWeaponDataValue(int weaponId, WeaponField field) {
        resetWeaponDataValue(weaponId, field.ordinal());
    }

    @Override
    public void resetWeaponValue(int weaponId, int field) {
        resetWeaponDataValue(weaponId, field);
    }

    @Override
    public native void resetWeaponDataValue(int weaponId, int fieldId);

    @Override
    public boolean isWeaponDataValueModified(int weaponId, WeaponField field) {
        return isWeaponDataValueModified(weaponId, field.ordinal());
    }

    @Override
    public boolean isWeaponValueModified(int weaponId, int field) {
        return isWeaponDataValueModified(weaponId, field);
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
    public native boolean registerKeyBind(int keyBindId, boolean onRelease, int keyOne, int keyTwo, int keyThree);

    @Override
    public boolean registerKeyBind(KeyBind keyBind) {
        return registerKeyBind(keyBind.getId(), keyBind.isOnRelease(), keyBind.getKeys()[0], keyBind.getKeys()[1], keyBind.getKeys()[2]);
    }

    @Override
    public native boolean removeKeyBind(int keyBindId);

    @Override
    public native void removeAllKeyBinds();

    @Override
    public native int createCoordBlip(int index, int worldId, float x, float y, float z, int scale, int colourHex, int spriteId);

    @Override
    public int createCoordBlip(CoordBlipInfo info) {
        return createCoordBlip(info.getIndex(), info.getWorldId(), info.getPosition().getX(), info.getPosition().getY(), info.getPosition().getZ(), info.getScale(), info.getColour().getHex(), info.getSpriteId());
    }

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

        return addPlayerClass(teamId, colour.getHex(), modelId, position.getX(), position.getY(), position.getZ(), angle, defaults[0].getWeaponId(), defaults[0].getAmmo(), defaults[1].getWeaponId(), defaults[1].getAmmo(), defaults[2].getWeaponId(), defaults[2].getAmmo());
    }

    @Override
    public native int addPlayerClass(int teamId, int colourHex, int modelId, float x, float y, float z, float angle, int weaponOne, int weaponOneAmmo, int weaponTwo, int weaponTwoAmmo, int weaponThree, int weaponThreeAmmo);

    @Override
    public native void setSpawnScreenPlayerPos(float x, float y, float z);

    @Override
    public void setSpawnScreenPlayerPos(Vector position) {
        setSpawnScreenPlayerPos(position.getX(), position.getY(), position.getZ());
    }

    @Override
    public native void setSpawnScreenCameraPos(float x, float y, float z);

    @Override
    public void setSpawnScreenCameraPos(Vector position) {
        setSpawnScreenCameraPos(position.getX(), position.getY(), position.getZ());
    }

    @Override
    public native void setSpawnScreenCameraLookAt(float x, float y, float z);

    @Override
    public void setSpawnScreenCameraLookAt(Vector position) {
        setSpawnScreenCameraLookAt(position.getX(), position.getY(), position.getZ());
    }

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

    @Deprecated
    @Override
    public native Vehicle createVehicle(int modelId, int worldId, float x, float y, float z, float angle, int mainColour, int secondaryColour);

    @Override
    public Vehicle createVehicle(int modelId, int worldId, Vector position, float angle, VehicleColours colours) {
        Vehicle v = createVehicle(modelId, worldId, position.getX(), position.getY(), position.getZ(), angle, colours.getPrimary(), colours.getSecondary());
        v.clearData();
        return v;
    }

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
    public void setVehiclesRespawnAltitude(Object v) {
        setVehiclesForcedRespawnAltitude(Float.valueOf(v+""));
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

    @Deprecated
    @Override
    public native Pickup createPickup(int modelId, int worldId, int quantity, float x, float y, float z, int alpha, boolean automatic);

    @Override
    public Pickup createPickup(int modelId, int worldId, int quantity, Vector position, int alpha, boolean automatic) {
        Pickup p = createPickup(modelId, worldId, quantity, position.getX(), position.getY(), position.getZ(), alpha, automatic);
        p.clearData();
        return p;
    }

    @Override
    public native GameObject getObject(int index);

    @Deprecated
    @Override
    public native GameObject createObject(int modelId, int worldId, float x, float y, float z, int alpha);

    @Override
    public GameObject createObject(int modelId, int worldId, Vector position, int alpha) {
        GameObject go = createObject(modelId, worldId, position.getX(), position.getY(), position.getZ(), alpha);
        go.clearData();
        return go;
    }

    @Override
    public native CheckPoint getCheckPoint(int index);

    @Deprecated
    @Override
    public native CheckPoint createCheckPoint(Player player, int worldId, boolean isSphere, float x, float y, float z, int r, int g, int b, int a, float radius);

    @Override
    public CheckPoint createCheckPoint(Player player, int worldId, boolean isSphere, Vector position, Colour colour, Object radius) {
        CheckPoint cp = createCheckPoint(player, worldId, isSphere, position.getX(), position.getY(), position.getZ(), colour.getRed(), colour.getGreen(), colour.getBlue(), colour.getAlpha(), Float.valueOf(radius+""));
        cp.clearData();
        return cp;
    }

}
