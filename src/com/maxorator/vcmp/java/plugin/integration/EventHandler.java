package com.maxorator.vcmp.java.plugin.integration;

import com.maxorator.vcmp.java.plugin.integration.placeable.CheckPoint;
import com.maxorator.vcmp.java.plugin.integration.placeable.GameObject;
import com.maxorator.vcmp.java.plugin.integration.placeable.Pickup;
import com.maxorator.vcmp.java.plugin.integration.player.Player;
import com.maxorator.vcmp.java.plugin.integration.vehicle.Vehicle;

public interface EventHandler {
    void onServerLoadScripts();

    void onServerUnloadScripts();

    boolean onServerInitialise();

    void onServerShutdown();

    void onServerFrame();

    void onPluginCommand(int identifier, String message);

    String onIncomingConnection(String name, String password, String ip);

    void onClientScriptData(Player player, byte[] data);

    void onPlayerConnect(Player player);

    void onPlayerDisconnect(Player player, int reason);

    boolean onPlayerRequestClass(Player player, int classIndex);

    boolean onPlayerRequestSpawn(Player player);

    void onPlayerSpawn(Player player);

    void onPlayerDeath(Player player, Player killer, int reason, int bodyPart);

    void onPlayerUpdate(Player player, int updateType);

    boolean onPlayerRequestEnterVehicle(Player player, Vehicle vehicle, int slot);

    void onPlayerEnterVehicle(Player player, Vehicle vehicle, int slot);

    void onPlayerExitVehicle(Player player, Vehicle vehicle);

    void onPlayerNameChange(Player player, String oldName, String newName);

    void onPlayerStateChange(Player player, int oldState, int newState);

    void onPlayerActionChange(Player player, int oldAction, int newAction);

    void onPlayerOnFireChange(Player player, boolean isOnFire);

    void onPlayerCrouchChange(Player player, boolean isCrouching);

    void onPlayerGameKeysChange(Player player, int oldKeys, int newKeys);

    void onPlayerBeginTyping(Player player);

    void onPlayerEndTyping(Player player);

    void onPlayerAwayChange(Player player, boolean isAway);

    boolean onPlayerMessage(Player player, String message);

    void onPlayerCrashReport(Player player, String crashLog);

    boolean onPlayerCommand(Player player, String message);

    boolean onPlayerPrivateMessage(Player player, Player recipient, String message);

    void onPlayerKeyBindDown(Player player, int keyBindIndex);

    void onPlayerKeyBindUp(Player player, int keyBindIndex);

    void onPlayerSpectate(Player player, Player spectated);

    void onVehicleUpdate(Vehicle vehicle, int updateType);

    void onVehicleExplode(Vehicle vehicle);

    void onVehicleRespawn(Vehicle vehicle);

    void onObjectShot(GameObject object, Player player, int weaponId);

    void onObjectTouched(GameObject object, Player player);

    boolean onPickupPickAttempt(Pickup pickup, Player player);

    void onPickupPicked(Pickup pickup, Player player);

    void onPickupRespawn(Pickup pickup);

    void onCheckPointEntered(CheckPoint checkPoint, Player player);

    void onCheckPointExited(CheckPoint checkPoint, Player player);

    void onPlayerModuleList(Player player, String list);

    void onServerPerformanceReport(int entry, String[] descriptions, long[] times);

}
