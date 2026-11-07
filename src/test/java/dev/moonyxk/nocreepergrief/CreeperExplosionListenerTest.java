package dev.moonyxk.nocreepergrief;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.bukkit.entity.Creeper;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.junit.jupiter.api.Test;

class CreeperExplosionListenerTest {
    private final CreeperExplosionListener listener = new CreeperExplosionListener();

    @Test
    void normalCreeperUsesOriginalDatapackRadius() {
        Creeper creeper = mock(Creeper.class);
        ExplosionPrimeEvent event = new ExplosionPrimeEvent(creeper, 3.0F, false);

        listener.onExplosionPrime(event);

        assertEquals(-3.0F, event.getRadius());
        assertFalse(event.isCancelled());
    }

    @Test
    void chargedCreeperUsesVanillaRadiusMultiplier() {
        Creeper creeper = mock(Creeper.class);
        when(creeper.isPowered()).thenReturn(true);
        ExplosionPrimeEvent event = new ExplosionPrimeEvent(creeper, 6.0F, false);

        listener.onExplosionPrime(event);

        assertEquals(-6.0F, event.getRadius());
        assertFalse(event.isCancelled());
    }

    @Test
    void otherExplosionsAreUnchanged() {
        TNTPrimed tnt = mock(TNTPrimed.class);
        ExplosionPrimeEvent event = new ExplosionPrimeEvent(tnt, 4.0F, true);

        listener.onExplosionPrime(event);

        assertEquals(4.0F, event.getRadius());
        assertTrue(event.getFire());
        assertFalse(event.isCancelled());
    }
}
