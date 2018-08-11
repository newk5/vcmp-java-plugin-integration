package com.maxorator.vcmp.java.plugin.integration;

import com.maxorator.vcmp.java.plugin.integration.placeable.CheckPoint;
import com.maxorator.vcmp.java.plugin.integration.placeable.GameObject;
import com.maxorator.vcmp.java.plugin.integration.placeable.Pickup;
import com.maxorator.vcmp.java.plugin.integration.player.Player;
import com.maxorator.vcmp.java.plugin.integration.vehicle.Vehicle;

public class AbstractEventHandler implements EventHandler {

    @Override
    public void onServerLoadScripts() {

    }

    @Override
    public void onServerUnloadScripts() {

    }

    @Override
    public boolean onServerInitialise() {
        return true;
    }

    @Override
    public void onServerShutdown() {

    }

    @Override
    public void onServerFrame() {

    }

    @Override
    public void onPluginCommand(int identifier, String message) {

    }
    
    @Override
    public void onServerPerformanceReport(int entry, String[] descriptions, long[] times) {
       
    }

    @Override
    public String onIncomingConnection(String name, String password, String ip) {
        return name;
    }

    @Override
    public void onClientScriptData(Player player, byte[] data) {

    }

    @Override
    public void onPlayerConnect(Player player) {

    }

    @Override
    public void onPlayerDisconnect(Player player, int reason) {

    }

    @Override
    public boolean onPlayerRequestClass(Player player, int classIndex) {
        return true;
    }

    @Override
    public boolean onPlayerRequestSpawn(Player player) {
        return true;
    }

    @Override
    public void onPlayerSpawn(Player player) {

    }

    @Override
    public void onPlayerDeath(Player player, Player killer, int reason, int bodyPart) {

    }

    @Override
    public void onPlayerUpdate(Player player, int updateType) {

    }

    @Override
    public boolean onPlayerRequestEnterVehicle(Player player, Vehicle vehicle, int slot) {
        return true;
    }

    @Override
    public void onPlayerEnterVehicle(Player player, Vehicle vehicle, int slot) {

    }

    @Override
    public void onPlayerExitVehicle(Player player, Vehicle vehicle) {

    }

    @Override
    public void onPlayerNameChange(Player player, String oldName, String newName) {

    }

    @Override
    public void onPlayerStateChange(Player player, int oldState, int newState) {

    }

    @Override
    public void onPlayerActionChange(Player player, int oldAction, int newAction) {

    }

    @Override
    public void onPlayerOnFireChange(Player player, boolean isOnFire) {

    }

    @Override
    public void onPlayerCrouchChange(Player player, boolean isCrouching) {

    }

    @Override
    public void onPlayerGameKeysChange(Player player, int oldKeys, int newKeys) {

    }

    @Override
    public void onPlayerBeginTyping(Player player) {

    }

    @Override
    public void onPlayerEndTyping(Player player) {

    }

    @Override
    public void onPlayerAwayChange(Player player, boolean isAway) {

    }

    @Override
    public boolean onPlayerMessage(Player player, String message) {
        return true;
    }

    @Override
    public boolean onPlayerCommand(Player player, String message) {
        return false;
    }

    @Override
    public boolean onPlayerPrivateMessage(Player player, Player recipient, String message) {
        return true;
    }

    @Override
    public void onPlayerKeyBindDown(Player player, int keyBindIndex) {

    }

    @Override
    public void onPlayerKeyBindUp(Player player, int keyBindIndex) {

    }

    @Override
    public void onPlayerSpectate(Player player, Player spectated) {

    }

    @Override
    public void onVehicleUpdate(Vehicle vehicle, int updateType) {

    }

    @Override
    public void onVehicleExplode(Vehicle vehicle) {

    }

    @Override
    public void onVehicleRespawn(Vehicle vehicle) {

    }

    @Override
    public void onObjectShot(GameObject object, Player player, int weaponId) {

    }

    @Override
    public void onObjectTouched(GameObject object, Player player) {

    }

    @Override
    public boolean onPickupPickAttempt(Pickup pickup, Player player) {
        return true;
    }

    @Override
    public void onPickupPicked(Pickup pickup, Player player) {

    }

    @Override
    public void onPickupRespawn(Pickup pickup) {

    }

    @Override
    public void onCheckPointEntered(CheckPoint checkPoint, Player player) {

    }

    @Override
    public void onCheckPointExited(CheckPoint checkPoint, Player player) {

    }

    @Override
    public void onPlayerCrashReport(Player player, String crashLog) {

    }

    @Override
    public void onPlayerModuleList(Player player, String list) {
        
    }
}
