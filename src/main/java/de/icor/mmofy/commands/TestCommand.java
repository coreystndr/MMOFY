package de.icor.mmofy.commands;

import de.icor.frameworks.command.Command;
import de.icor.frameworks.item.ItemBuilder;
import de.icor.mmofy.mob.MobManager;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;

@Command(name = "test")
public class TestCommand {

    private final MobManager mobManager;

    public TestCommand(MobManager mobManager) {
        this.mobManager = mobManager;
    }

    public void execute(Player player) {
        Zombie mob = (Zombie) player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE);
        mob.getEquipment().setHelmet(new ItemBuilder(Material.LEATHER_HELMET).build());
        mobManager.registerMob(mob, 200);
    }
}
