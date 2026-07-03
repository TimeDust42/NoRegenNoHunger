package com.timedust.noRegenNoHunger.data;

public class WorldData {

    private String worldName;

    private boolean regenEnabled;
    private boolean hungerEnabled;

    public WorldData(String worldName, boolean regenEnabled, boolean hungerEnabled) {
        this.worldName = worldName;
        this.regenEnabled = regenEnabled;
        this.hungerEnabled = hungerEnabled;
    }

    public String getWorldName() {
        return worldName;
    }

    public void setWorldName(String worldName) {
        this.worldName = worldName;
    }

    public boolean isRegenEnabled() {
        return regenEnabled;
    }

    public void setRegenEnabled(boolean regenEnabled) {
        this.regenEnabled = regenEnabled;
    }

    public boolean isHungerEnabled() {
        return hungerEnabled;
    }

    public void setHungerEnabled(boolean hungerEnabled) {
        this.hungerEnabled = hungerEnabled;
    }
}
