package de.icor.mmofy.custommob;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public enum MobType {
    ZOMBIE_MINION("Zombie Minion", 100, 8, Color.RED);

    public final String name;
    public final double health;
    public final double damage;
    public final ItemStack helmet;

    MobType(String name, double health, double damage, Color color) {
        this.name = name;
        this.health = health;
        this.damage = damage;

        ItemStack item = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setColor(color);
        item.setItemMeta(meta);
        this.helmet = item;
    }
}
