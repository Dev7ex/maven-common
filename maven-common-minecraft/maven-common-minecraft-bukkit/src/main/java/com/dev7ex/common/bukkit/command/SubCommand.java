package com.dev7ex.common.bukkit.command;

import com.dev7ex.common.bukkit.plugin.BukkitPlugin;
import org.bukkit.command.CommandSender;

import java.util.List;

/**
 *
 * @author Dev7ex
 * @since 19.05.2021
 *
 */

public abstract class SubCommand {

    protected final BukkitPlugin plugin;
    private String name;
    private String permission;
    private String usage;
    private List<String> aliases;

    public SubCommand(final BukkitPlugin plugin) {
        this.plugin = plugin;
    }

    public final void setName(final String name) {
        this.name = name;
    }

    public final String getName() {
        if(this.name == null) {
            return this.getDefaultName();
        }
        return this.name;
    }

    public final void setPermission(final String permission) {
        this.permission = permission;
    }

    public final String getPermission() {
        return this.permission;
    }

    public final void setAliases(final List<String> aliases) {
        this.aliases = aliases;
    }

    public final List<String> getAliases() {
        return this.aliases;
    }

    public final void setUsage(final String usage) {
        this.usage = usage;
    }

    public final String getUsage() {
        return this.usage;
    }

    public abstract boolean execute(final CommandSender commandSender, final String[] arguments);

    protected final String getPrefix() {
        return this.plugin.getConfiguration().getPrefix();
    }

    protected final String getNoPermissionMessage() {
        return this.plugin.getConfiguration().getNoPermissionMessage();
    }

    protected final String getPlayerNotFoundMessage() {
        return this.plugin.getConfiguration().getPlayerNotFoundMessage();
    }

    protected final String getDefaultName() {
        return this.getClass().getSimpleName().replaceAll("Command", "").toLowerCase();
    }

}
