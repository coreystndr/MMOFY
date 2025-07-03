package de.icor.mmofy.custommob;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDamageEvent;

public abstract class CustomMob {
    protected LivingEntity entity;
    protected double maxHealth;
    protected double currentHealth;
    protected String name;

    public CustomMob(LivingEntity entity, String name, double maxHealth) {
        this.entity = entity;
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;

        entity.setCustomNameVisible(true);
        updateNameTag();
    }

    public abstract void onSpawn();
    public abstract void onDeath();
    public abstract void onAttack(LivingEntity target);

    public void handleDamage(double damage, EntityDamageEvent.DamageCause cause) {
        currentHealth -= damage;
        if (currentHealth <= 0) {
            onDeath();
            entity.remove();
        } else {
            updateNameTag();
        }
    }

    private void updateNameTag() {
        entity.setCustomName(ChatColor.RED + name + " §7[§c" + (int) currentHealth + "§7]");
    }

    public LivingEntity getEntity() {
        return entity;
    }
}
