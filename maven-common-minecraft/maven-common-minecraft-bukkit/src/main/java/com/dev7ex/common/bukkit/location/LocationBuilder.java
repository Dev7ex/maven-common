package com.dev7ex.common.bukkit.location;

import lombok.Getter;

import org.bukkit.Location;
import org.bukkit.World;

/**
 *
 * @author Dev7ex
 * @since 14.05.2021
 *
 */

@Getter
public final class LocationBuilder {

    private final World world;
    private double x, y, z;
    private float pitch = 0f, yaw = 0f;

    public LocationBuilder(final World world) {
        this.world = world;
    }

    public final LocationBuilder setX(final double x) {
        this.x = x;
        return this;
    }

    public final LocationBuilder setY(final double y) {
        this.y = y;
        return this;
    }

    public final LocationBuilder setZ(final double z) {
        this.z = z;
        return this;
    }

    public final LocationBuilder setPitch(final float pitch) {
        this.pitch = pitch;
        return this;
    }

    public final LocationBuilder setYaw(final float yaw) {
        this.yaw = yaw;
        return this;
    }

    public final Location build() {
        return new Location(this.world, this.x, this.y, this.z, this.yaw, this.pitch);
    }

}
