package com.dev7ex.common.java.map;

import java.util.HashMap;
import java.util.UUID;

/**
 *
 * @author Dev7ex
 * @since 02.11.2020
 *
 */

public final class ParsedMap<K, V> extends HashMap<K, V> {

    public <V> V getValue(final String key) {
        return (V) this.get(key);
    }

    public final String getString(final K key) {
        return super.get(key).toString();
    }

    public final byte getByte(final K key) {
        return Byte.parseByte(this.getString(key));
    }

    public final short getShort(final K key) {
        return Short.parseShort(this.getString(key));
    }

    public final int getInteger(final K key) {
        return Integer.parseInt(this.getString(key));
    }

    public final long getLong(final K key) {
        return Long.parseLong(this.getString(key));
    }

    public final float getFloat(final K key) {
        return Float.parseFloat(this.getString(key));
    }

    public final double getDouble(final K key) {
        return Double.parseDouble(this.getString(key));
    }

    public final boolean getBoolean(final K key) {
        return Boolean.parseBoolean(this.getString(key));
    }

    public final UUID getUUID(final K key) {
        return UUID.fromString(this.getString(key));
    }

}
