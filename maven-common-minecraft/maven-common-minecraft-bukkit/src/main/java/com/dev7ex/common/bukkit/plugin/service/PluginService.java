package com.dev7ex.common.bukkit.plugin.service;

import org.bukkit.event.Listener;

import java.util.Collection;
import java.util.Collections;

/**
 * @author Dev7ex
 * @since 19.05.2021
 */
public interface PluginService {

    void onEnable();

    void onDisable();

    default String getName() {
        return this.getClass().getSimpleName();
    }

    default Collection<Listener> getListener() {
        return Collections.emptyList();
    }

}
