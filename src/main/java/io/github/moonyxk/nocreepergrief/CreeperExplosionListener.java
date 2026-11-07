package io.github.moonyxk.nocreepergrief;

import org.bukkit.entity.Creeper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExplosionPrimeEvent;

public final class CreeperExplosionListener implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onExplosionPrime(ExplosionPrimeEvent event) {
        if (event.getEntity() instanceof Creeper creeper) {
            event.setRadius(creeper.isPowered() ? -6.0F : -3.0F);
        }
    }
}
