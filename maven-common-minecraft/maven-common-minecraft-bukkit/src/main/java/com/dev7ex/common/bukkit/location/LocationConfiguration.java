package com.dev7ex.common.bukkit.location;

import com.dev7ex.common.bukkit.configuration.SimpleConfiguration;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Dev7ex
 * @since 18.10.2020
 */

public class LocationConfiguration extends SimpleConfiguration {

    public LocationConfiguration(final Plugin plugin, final String fileName) {
        super(plugin, fileName);
    }

    public void setLocation(final String name, final Location location) {
        super.yamlConfiguration.set(name + ".world", location.getWorld().getName());
        super.yamlConfiguration.set(name + ".x", location.getX());
        super.yamlConfiguration.set(name + ".y", location.getY());
        super.yamlConfiguration.set(name + ".z", location.getZ());
        super.yamlConfiguration.set(name + ".pitch", location.getPitch());
        super.yamlConfiguration.set(name + ".yaw", location.getYaw());
        super.saveFile();
    }

    public Location getLocation(final String name) {
        final String world = super.yamlConfiguration.getString("locations." + name + ".world");
        final double x = super.yamlConfiguration.getDouble("locations." + name + ".x");
        final double y = super.yamlConfiguration.getDouble("locations." + name + ".y");
        final double z = super.yamlConfiguration.getDouble("locations." + name + ".z");
        final float pitch = (float) super.yamlConfiguration.getDouble("locations." + name + ".pitch");
        final float yaw = (float) super.yamlConfiguration.getDouble("locations." + name + ".yaw");
        return new LocationBuilder(Bukkit.getWorld(name)).setX(x).setY(y).setZ(z).setPitch(pitch).setYaw(yaw).build();
    }

    public boolean locationExists(final String name) {
        return super.yamlConfiguration.contains(name);
    }

    public void deleteLocation(final String name) {
        super.yamlConfiguration.set(name, null);
        super.saveFile();
    }

    public Set<Location> getLocations() {
        final Set<Location> locations = new HashSet<>();

        for(final String location : super.yamlConfiguration.getKeys(false)) {
            locations.add(this.getLocation(location));
        }
        return locations;
    }

}
