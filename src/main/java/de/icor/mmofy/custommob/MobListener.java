package de.icor.mmofy.custommob;

import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class MobListener implements Listener {

    private final MobRegistry mobRegistry;

    public MobListener(MobRegistry mobRegistry) {
        this.mobRegistry = mobRegistry;
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        Entity entity = event.getEntity();
        if (!mobRegistry.isCustomMob(entity)) return;

        double damage = event.getDamage();
        mobRegistry.handleDamage(entity, damage, event.getCause());

        event.setDamage(0.0);
    }
}
