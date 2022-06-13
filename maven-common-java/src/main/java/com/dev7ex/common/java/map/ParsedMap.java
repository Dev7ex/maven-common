package com.dev7ex.common.java.map;

import java.util.HashMap;
import java.util.UUID;

/**
 * @author Dev7ex
 * @since 02.11.2020
 */
public class ParsedMap<K, V> extends HashMap<K, V> {

    public ParsedMap() {}

    public ParsedMap(final int initialCapacity) {
        super(initialCapacity);
    }

    public <V> V getValue(final String key) {
        return (V) this.get(key);
    }

    public <V> V getValue(final String key, final V defaultValue) {
        return (this.get(key) == null ? defaultValue : (V) this.get(key));
    }

    public String getString(final K key) {
        return super.get(key).toString();
    }

    public String getString(final K key, final String defaultValue) {
        return (super.get(key).toString() == null ? defaultValue : super.get(key).toString());
    }

    public byte getByte(final K key) {
        return Byte.parseByte(this.getString(key));
    }

    public byte getByte(final K key, final byte defaultValue) {
        return (this.getString(key) == null ? defaultValue : Byte.parseByte(this.getString(key)));
    }

    public short getShort(final K key) {
        return Short.parseShort(this.getString(key));
    }

    public short getShort(final K key, final short defaultValue) {
        return (this.getString(key) == null ? defaultValue : Short.parseShort(this.getString(key)));
    }

    public int getInteger(final K key,  final int defaultValue) {
        return (this.getString(key) == null ? defaultValue : Integer.parseInt(this.getString(key)));
    }

    public int getInteger(final K key) {
        return Integer.parseInt(this.getString(key));
    }

    public long getLong(final K key) {
        return Long.parseLong(this.getString(key));
    }

    public long getLong(final K key, final long defaultValue) {
        return (this.getString(key) == null ? defaultValue : Long.parseLong(this.getString(key)));
    }

    public float getFloat(final K key) {
        return Float.parseFloat(this.getString(key));
    }

    public float getFloat(final K key, final float defaultValue) {
        return (this.getString(key) == null ? defaultValue : Float.parseFloat(this.getString(key)));
    }

    public double getDouble(final K key) {
        return Double.parseDouble(this.getString(key));
    }

    public double getDouble(final K key, final double defaultValue) {
        return (this.getString(key) == null ? defaultValue : Double.parseDouble(this.getString(key)));
    }

    public boolean getBoolean(final K key) {
        return Boolean.parseBoolean(this.getString(key));
    }

    public boolean getBoolean(final K key, final boolean defaultValue) {
        return (this.getString(key) == null ? defaultValue : Boolean.parseBoolean(this.getString(key)));
    }

    public UUID getUUID(final K key) {
        return UUID.fromString(this.getString(key));
    }

}
