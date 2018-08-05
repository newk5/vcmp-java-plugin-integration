package com.maxorator.vcmp.java.plugin.integration.server;

import com.maxorator.vcmp.java.plugin.integration.generic.Colour;

public class WastedSettings {

    private int deathTimeMillis;
    private int fadeTimeMillis;
    private float fadeInSpeed;
    private float fadeOutSpeed;
    private Colour fadeColour;
    private int corpseFadeStart;
    private int corpseFadeDuration;

    public WastedSettings(int deathTimeMillis, int fadeTimeMillis, float fadeInSpeed, float fadeOutSpeed, Colour fadeColour, int corpseFadeStart, int corpseFadeDuration) {
        this.deathTimeMillis = deathTimeMillis;
        this.fadeTimeMillis = fadeTimeMillis;
        this.fadeInSpeed = fadeInSpeed;
        this.fadeOutSpeed = fadeOutSpeed;
        this.fadeColour = fadeColour;
        this.corpseFadeStart = corpseFadeStart;
        this.corpseFadeDuration = corpseFadeDuration;
    }

    public WastedSettings(int deathTimeMillis, int fadeTimeMillis, Double fadeInSpeed, Double fadeOutSpeed, Colour fadeColour, int corpseFadeStart, int corpseFadeDuration) {
        this.deathTimeMillis = deathTimeMillis;
        this.fadeTimeMillis = fadeTimeMillis;
        this.fadeInSpeed = new Float(fadeInSpeed);
        this.fadeOutSpeed = new Float(fadeOutSpeed);
        this.fadeColour = fadeColour;
        this.corpseFadeStart = corpseFadeStart;
        this.corpseFadeDuration = corpseFadeDuration;
    }

    public WastedSettings(int deathTimeMillis, int fadeTimeMillis, Integer fadeInSpeed, Integer fadeOutSpeed, Colour fadeColour, int corpseFadeStart, int corpseFadeDuration) {
        this.deathTimeMillis = deathTimeMillis;
        this.fadeTimeMillis = fadeTimeMillis;
        this.fadeInSpeed = new Float(fadeInSpeed);
        this.fadeOutSpeed = new Float(fadeOutSpeed);
        this.fadeColour = fadeColour;
        this.corpseFadeStart = corpseFadeStart;
        this.corpseFadeDuration = corpseFadeDuration;
    }

    public WastedSettings(int deathTimeMillis, int fadeTimeMillis, float fadeInSpeed, float fadeOutSpeed, int fadeColourHex, int corpseFadeStart, int corpseFadeDuration) {
        this(deathTimeMillis, fadeTimeMillis, fadeInSpeed, fadeOutSpeed, new Colour(fadeColourHex), corpseFadeStart, corpseFadeDuration);
    }

    /**
     * @return the deathTimeMillis
     */
    public int getDeathTimeMillis() {
        return deathTimeMillis;
    }

    /**
     * @param deathTimeMillis the deathTimeMillis to set
     */
    public void setDeathTimeMillis(int deathTimeMillis) {
        this.deathTimeMillis = deathTimeMillis;
    }

    /**
     * @return the fadeTimeMillis
     */
    public int getFadeTimeMillis() {
        return fadeTimeMillis;
    }

    /**
     * @param fadeTimeMillis the fadeTimeMillis to set
     */
    public void setFadeTimeMillis(int fadeTimeMillis) {
        this.fadeTimeMillis = fadeTimeMillis;
    }

    /**
     * @return the fadeInSpeed
     */
    public float getFadeInSpeed() {
        return fadeInSpeed;
    }

    /**
     * @param fadeInSpeed the fadeInSpeed to set
     */
    public void setFadeInSpeed(float fadeInSpeed) {
        this.fadeInSpeed = fadeInSpeed;
    }

    /**
     * @return the fadeOutSpeed
     */
    public float getFadeOutSpeed() {
        return fadeOutSpeed;
    }

    /**
     * @param fadeOutSpeed the fadeOutSpeed to set
     */
    public void setFadeOutSpeed(float fadeOutSpeed) {
        this.fadeOutSpeed = fadeOutSpeed;
    }

    /**
     * @return the fadeColour
     */
    public Colour getFadeColour() {
        return fadeColour;
    }

    /**
     * @param fadeColour the fadeColour to set
     */
    public void setFadeColour(Colour fadeColour) {
        this.fadeColour = fadeColour;
    }

    /**
     * @return the corpseFadeStart
     */
    public int getCorpseFadeStart() {
        return corpseFadeStart;
    }

    /**
     * @param corpseFadeStart the corpseFadeStart to set
     */
    public void setCorpseFadeStart(int corpseFadeStart) {
        this.corpseFadeStart = corpseFadeStart;
    }

    /**
     * @return the corpseFadeDuration
     */
    public int getCorpseFadeDuration() {
        return corpseFadeDuration;
    }

    /**
     * @param corpseFadeDuration the corpseFadeDuration to set
     */
    public void setCorpseFadeDuration(int corpseFadeDuration) {
        this.corpseFadeDuration = corpseFadeDuration;
    }
}
