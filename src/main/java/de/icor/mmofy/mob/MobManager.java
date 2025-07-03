package de.icor.mmofy.mob;

import org.bukkit.entity.Entity;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MobManager {
    private final Map<UUID, CustomMob> mobs = new HashMap<>();

    public void registerMob(Entity entity, double health) {
        CustomMob mob = new CustomMob(entity, health);
        mobs.put(entity.getUniqueId(), mob);
        mob.updateHealthDisplay();
    }

    public void handleDamage(Entity entity, double damage) {
        CustomMob mob = mobs.get(entity.getUniqueId());
        if (mob != null) {
            mob.damage(damage);
        }
    }

    public boolean isCustomMob(Entity entity) {
        return mobs.containsKey(entity.getUniqueId());
    }
}
