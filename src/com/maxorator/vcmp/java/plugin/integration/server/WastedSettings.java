package com.maxorator.vcmp.java.plugin.integration.server;

import com.maxorator.vcmp.java.plugin.integration.generic.Colour;

public class WastedSettings {

    public int deathTimeMillis;
    public int fadeTimeMillis;
    public float fadeInSpeed;
    public float fadeOutSpeed;
    public Colour fadeColour;
    public int corpseFadeStart;
    public int corpseFadeDuration;

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
}
