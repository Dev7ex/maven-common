package com.dev7ex.common.bukkit.plugin.configuration;

import com.dev7ex.common.bukkit.plugin.BukkitPlugin;
import com.dev7ex.common.java.map.ParsedMap;
import org.bukkit.configuration.file.FileConfiguration;

/**
 *
 * @author Dev7ex
 * @since 19.05.2021
 *
 */

public abstract class PluginConfiguration {

    protected final FileConfiguration fileConfiguration;
    protected ParsedMap<String, Object> values = new ParsedMap<>(100);

    public PluginConfiguration(final BukkitPlugin bukkitPlugin) {
        this.fileConfiguration = bukkitPlugin.getConfig();
        bukkitPlugin.setDataFolderUsed(true);
        bukkitPlugin.setDefaultConfigUsed(true);
    }

    public <V> V getValueSafe(final String key) {
        if (!this.values.containsKey(key)) {
            return (V) this.values.put(key, this.fileConfiguration.get(key));
        }
        return (V) this.values.get(key);
    }

    public String getStringSafe(final String key) {
        if (!this.values.containsKey(key)) {
            return String.valueOf(this.values.put(key, this.fileConfiguration.getString(key)));
        }
        return this.values.getString(key);
    }

    @Deprecated
    public final String getMessageSafe(final String key) {
        if(this.values.containsKey(key)) {
            return this.values.getString(key);
        }
        return String.valueOf(this.values.put(key, this.fileConfiguration.getString(key)));
    }

    public abstract void load();

    public abstract String getPrefix();

    public abstract String getNoPermissionMessage();

    public abstract String getPlayerNotFoundMessage();


}
