package com.dev7ex.common.bukkit.configuration;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Dev7ex
 * @since 10.10.2020
 *
 */

public abstract class SimpleConfiguration {

    protected final File file;
    protected final YamlConfiguration yamlConfiguration;

    public SimpleConfiguration(final Plugin plugin, final String fileName) {
        this.file = new File(plugin.getDataFolder() + File.separator + fileName);
        this.yamlConfiguration = YamlConfiguration.loadConfiguration(this.file);

        if(!this.file.exists()) {
            try {
                this.file.createNewFile();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    public final void saveFile() {
        try {
            this.yamlConfiguration.save(this.file);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}
