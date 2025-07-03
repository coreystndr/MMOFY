package de.icor.mmofy.custommob.mobs;

import de.icor.mmofy.custommob.CustomMob;
import org.bukkit.entity.LivingEntity;

public class ZombieWarrior extends CustomMob {

    public ZombieWarrior(LivingEntity entity) {
        super(entity, "Zombie Warrior", 150);
    }

    @Override
    public void onSpawn() {

    }

    @Override
    public void onDeath() {

    }

    @Override
    public void onAttack(LivingEntity target) {
        target.damage(5, entity);
    }
}
