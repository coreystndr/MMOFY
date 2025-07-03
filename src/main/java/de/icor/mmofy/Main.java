package de.icor.mmofy;

import de.icor.frameworks.Frameworks;
import de.icor.frameworks.command.CommandManager;
import de.icor.frameworks.gui.GuiManager;
import de.icor.mmofy.commands.TestCommand;
import de.icor.mmofy.mob.MobListener;
import de.icor.mmofy.mob.MobManager;
import lombok.Getter;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Getter
    private static Main instance;
    @Getter
    private GuiManager guiManager = Frameworks.getGuiManager();
    @Getter
    private MobManager mobManager = new MobManager();

    @Override
    public void onEnable() {
        instance = this;
        CommandManager commandManager = new CommandManager(this);
        initCommands(commandManager);
        initListeners(getServer().getPluginManager());
    }

    private void initCommands(CommandManager commandManager) {
        commandManager.register(new TestCommand(getMobManager()));
    }

    private void initListeners(PluginManager pluginManager) {
        pluginManager.registerEvents(guiManager, this);
        pluginManager.registerEvents(new MobListener(getMobManager()), this);
    }
}
