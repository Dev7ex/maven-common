package com.dev7ex.common.java.reference;

/**
 *
 * @author Dev7ex
 * @since 02.11.2020
 *
 */

public final class Reference<V> {

    private V value;

    public Reference() {}

    public Reference(final V value) {
        this.value = value;
    }

    public final void setValue(V value) {
        this.value = value;
    }

    public final V getValue() {
        return this.value;
    }

}