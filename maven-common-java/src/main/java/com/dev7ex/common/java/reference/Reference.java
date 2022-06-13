package com.dev7ex.common.java.reference;

/**
 * @author Dev7ex
 * @since 02.11.2020
 */
public class Reference<V> {

    private V value;

    public Reference() {}

    public Reference(final V value) {
        this.value = value;
    }

    public void setValue(final V value) {
        this.value = value;
    }

    public V getValue() {
        return this.value;
    }

}