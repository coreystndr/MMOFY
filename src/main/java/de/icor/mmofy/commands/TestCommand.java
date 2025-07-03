package de.icor.mmofy.commands;

import de.icor.frameworks.command.Command;
import de.icor.mmofy.custommob.MobRegistry;
import org.bukkit.entity.Player;

@Command(name = "test")
public class TestCommand {

    private final MobRegistry mobRegistry;

    public TestCommand(MobRegistry mobRegistry) {
        this.mobRegistry = mobRegistry;
    }

    public void execute(Player player) {
        mobRegistry.spawnZombieWarrior(player.getLocation());
    }
}
