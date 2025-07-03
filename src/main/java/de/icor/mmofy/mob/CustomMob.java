package de.icor.mmofy.mob;

import lombok.Getter;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

import java.util.UUID;

public class CustomMob {
    @Getter
    private final UUID uuid;
    @Getter
    private final Entity entity;
    @Getter
    private double maxHealth;
    @Getter
    private double currentHealth;

    public CustomMob(Entity entity, double maxHealth) {
        this.uuid = entity.getUniqueId();
        this.entity = entity;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
    }

    public void damage(double amount) {
        currentHealth -= amount;
        if (currentHealth <= 0) {
            entity.remove();
            // Drop, Nachricht, usw.
        } else {
            updateHealthDisplay();
        }
    }

    public void updateHealthDisplay() {
        if (entity instanceof LivingEntity living) {
            living.setCustomNameVisible(true);
            living.setCustomName("§c♥ " + (int) currentHealth + " / " + (int) maxHealth);
        }
    }
}
