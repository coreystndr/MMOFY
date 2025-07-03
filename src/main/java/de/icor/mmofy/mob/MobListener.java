package de.icor.mmofy.mob;

import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class MobListener implements Listener {

    private final MobManager mobManager;

    public MobListener(MobManager mobManager) {
        this.mobManager = mobManager;
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        Entity entity = event.getEntity();
        if (!mobManager.isCustomMob(entity)) return;

        double damage = event.getDamage();
        mobManager.handleDamage(entity, damage);
        event.setDamage(0.0);
    }
}
