package de.icor.mmofy.custommob;

import de.icor.mmofy.custommob.mobs.ZombieWarrior;
import org.bukkit.Location;
import org.bukkit.entity.*;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.*;

public class MobRegistry {

    private final Map<UUID, CustomMob> mobs = new HashMap<>();

    public CustomMob spawnZombieWarrior(Location location) {
        Zombie zombie = (Zombie) location.getWorld().spawnEntity(location, EntityType.ZOMBIE);
        ZombieWarrior mob = new ZombieWarrior(zombie);
        mobs.put(zombie.getUniqueId(), mob);
        return mob;
    }

    public boolean isCustomMob(Entity entity) {
        return mobs.containsKey(entity.getUniqueId());
    }

    public void handleDamage(Entity entity, double damage, EntityDamageEvent.DamageCause cause) {
        CustomMob mob = mobs.get(entity.getUniqueId());
        if (mob != null) mob.handleDamage(damage, cause);
    }

    public void clearDead() {
        mobs.entrySet().removeIf(entry -> entry.getValue().getEntity().isDead());
    }
}
