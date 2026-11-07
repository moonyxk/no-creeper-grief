package dev.moonyxk.nocreepergrief;

import org.bukkit.plugin.java.JavaPlugin;

public final class NoCreeperGriefPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new CreeperExplosionListener(), this);
    }
}
