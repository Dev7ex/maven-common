package com.dev7ex.common.bukkit.command;

import com.dev7ex.common.bukkit.plugin.BukkitPlugin;
import com.dev7ex.common.bukkit.plugin.configuration.PluginConfiguration;
import com.google.common.collect.Maps;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;

import java.util.Map;

/**
 *
 * @author Dev7ex
 * @since 19.05.2021
 *
 */

public abstract class SimpleCommand implements CommandExecutor {

    protected final Map<String, SubCommand> commandMap = Maps.newHashMap();

    private BukkitPlugin plugin;
    private String name;
    private String permission;
    private String usage;

    public SimpleCommand(final BukkitPlugin plugin) {
        this.plugin = plugin;
    }

    protected final void registerSubCommand(final SubCommand subCommand) {
        if((subCommand.getAliases()) != null && (!subCommand.getAliases().isEmpty())) {
            subCommand.getAliases().forEach(aliases -> this.commandMap.put(aliases, subCommand));
        }
        this.commandMap.put(subCommand.getName(), subCommand);
    }

    public final boolean hasSubCommands() {
        return (!this.commandMap.isEmpty());
    }

    protected final boolean testPermission(final CommandSender commandSender) {
        if(!commandSender.hasPermission(this.permission)) {
            commandSender.sendMessage(this.getNoPermissionMessage());
            return false;
        }
        return true;
    }

    protected final void setName(final String name) {
        this.name = name;
    }

    protected final String getName() {
        if(this.name == null) {
            return this.getDefaultName();
        }
        return this.name;
    }

    protected final void setPermission(final String permission) {
        this.permission = permission;
    }

    protected final String getPermission() {
        return this.permission;
    }

    protected final void setUsage(final String usage) {
        this.usage = usage;
    }

    protected final String getUsage() {
        return this.usage;
    }

    protected final PluginConfiguration getConfiguration() {
        return this.plugin.getConfiguration();
    }

    protected final String getPrefix() {
        return this.plugin.getConfiguration().getPrefix();
    }

    protected final String getNoPermissionMessage() {
        return this.plugin.getConfiguration().getNoPermissionMessage();
    }

    protected final String getPlayerNotFoundMessage() {
        return this.plugin.getConfiguration().getPlayerNotFoundMessage();
    }

    public final String getDefaultName() {
        return this.getClass().getSimpleName().replaceAll("Command", "").toLowerCase();
    }

}
