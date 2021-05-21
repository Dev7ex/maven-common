package com.dev7ex.common.java.reference;

/**
 *
 * @author Dev7ex
 * @since 02.11.2020
 *
 */

public final class MultiReference<E, V> {

    private E firstValue;
    private V secondValue;

    public MultiReference(final E firstValue, final V secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    public final E getFirstValue() {
        return this.firstValue;
    }

    public final void setFirstValue(final E firstValue) {
        this.firstValue = firstValue;
    }

    public final V getSecondValue() {
        return this.secondValue;
    }

    public final void setSecondValue(final V secondValue) {
        this.secondValue = secondValue;
    }

}
