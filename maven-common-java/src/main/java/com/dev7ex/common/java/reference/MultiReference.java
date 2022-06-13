package com.dev7ex.common.java.reference;

/**
 * @author Dev7ex
 * @since 02.11.2020
 */
public class MultiReference<E, V> {

    private E firstValue;
    private V secondValue;

    public MultiReference(final E firstValue, final V secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    public E getFirstValue() {
        return this.firstValue;
    }

    public void setFirstValue(final E firstValue) {
        this.firstValue = firstValue;
    }

    public V getSecondValue() {
        return this.secondValue;
    }

    public void setSecondValue(final V secondValue) {
        this.secondValue = secondValue;
    }

}
