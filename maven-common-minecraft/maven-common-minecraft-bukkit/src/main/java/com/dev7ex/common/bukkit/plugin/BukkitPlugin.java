package com.dev7ex.common.bukkit.plugin;

import com.dev7ex.common.bukkit.plugin.configuration.PluginConfiguration;
import com.dev7ex.common.bukkit.plugin.service.PluginService;

import com.google.common.collect.Maps;

import lombok.Getter;
import lombok.Setter;

import org.bukkit.command.PluginCommand;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Map;

/**
 *
 * @author Dev7ex
 * @since 19.05.2021
 *
 */

public abstract class BukkitPlugin extends JavaPlugin {

    private final Map<String, PluginService> pluginServices = Maps.newHashMap();

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

        if(!this.pluginServices.isEmpty()) {
            this.pluginServices.values().forEach(PluginService::onEnable);
        }
    }

    @Override
    public void onDisable() {
        if(!this.pluginServices.isEmpty()) {
            this.pluginServices.values().forEach(PluginService::onDisable);
        }
    }

    protected final Listener registerListener(final Listener listener) {
        super.getServer().getPluginManager().registerEvents(listener, this);
        return listener;
    }

    protected final PluginCommand registerCommand(final String pluginCommand) {
        return super.getCommand(pluginCommand);
    }

    protected final PluginService registerService(final PluginService pluginService) {
        return this.pluginServices.put(pluginService.getName(), pluginService);
    }

    public abstract PluginConfiguration getConfiguration();

    public void registerServices() {}

    public void registerCommands() {}

    public void registerListeners() {}

}
