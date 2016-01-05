package org.zyq.huobi.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Yuquan Zou on 2016/1/2.
 */
public class LimiteList<E> extends ArrayList<E> {

    private int initialCapacity;

    public int getInitialCapacity() {
        return initialCapacity;
    }

    public LimiteList(int initialCapacity) {
        super(initialCapacity);
        this.initialCapacity = initialCapacity;
    }

    public boolean add(E e) {
        boolean result = false;
        synchronized (this) {
            if (this.size() + 1 > initialCapacity) {
                this.remove(this.size() - 1);
            }
            super.add(0, e);
        }
        return result;
    }

    public void add(int index, E element) {
    }

    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }
}
