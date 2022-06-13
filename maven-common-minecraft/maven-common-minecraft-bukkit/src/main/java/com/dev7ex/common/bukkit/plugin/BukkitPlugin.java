package com.dev7ex.common.bukkit.plugin;

import com.dev7ex.common.bukkit.plugin.configuration.PluginConfiguration;
import com.dev7ex.common.bukkit.plugin.service.PluginService;
import com.dev7ex.common.bukkit.plugin.service.ServiceManager;

import lombok.Getter;
import lombok.Setter;

import org.bukkit.command.PluginCommand;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.function.Predicate;

/**
 * @author Dev7ex
 * @since 19.05.2021
 */
public abstract class BukkitPlugin extends JavaPlugin {

    private final ServiceManager serviceManager = new ServiceManager(this);

    @Getter @Setter
    private boolean defaultConfigUsed = false;

    @Getter @Setter
    private boolean dataFolderUsed = false;

    @Override
    public void onLoad() {
        if(this.dataFolderUsed) {
            if(!super.getDataFolder().exists()) {
                super.getDataFolder().mkdirs();
            }
        }
        if((this.defaultConfigUsed) && (super.getDataFolder().exists())) {
            super.saveDefaultConfig();
        }
        this.getConfiguration().load();
    }

    @Override
    public void onEnable() {
        this.registerCommands();
        this.registerListeners();
        this.registerServices();

        this.serviceManager.onEnable();
    }

    @Override
    public void onDisable() {
        this.serviceManager.onDisable();
    }

    protected final Listener registerListener(final Listener listener) {
        super.getServer().getPluginManager().registerEvents(listener, this);
        return listener;
    }

    protected final Listener registerListenerIf(final Listener listener, final Predicate<Boolean> predicate) {
        if (predicate.test(true)) {
            return this.registerListener(listener);
        }
        return listener;
    }

    protected final PluginCommand registerCommand(final String pluginCommand) {
        return super.getCommand(pluginCommand);
    }

    protected final void registerService(final PluginService pluginService) {
        this.serviceManager.registerService(pluginService);
    }

    protected final void registerServiceIf(final PluginService pluginService, final Predicate<Boolean> predicate) {
        if (predicate.test(true)) {
            this.serviceManager.registerService(pluginService);
        }
    }

    public ServiceManager getServiceManager() {
        return serviceManager;
    }

    public abstract PluginConfiguration getConfiguration();

    public void registerServices() {}

    public void registerCommands() {}

    public void registerListeners() {}

}
