package com.resolvix.lib.sort.bubble;

import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

/**
 *  Provides generic implementations of the BubbleSort algorithm
 */
public class BubbleSort {

    public static <T> void sort(T[] ts, Comparator<T> c) {
        boolean finished = false;
        int i_max = ts.length;
        while (!finished) {
            finished = true;
            for (int i = 0; i < i_max - 1; i++)
                if (c.compare(ts[i], ts[i+1]) > 0) {
                    T scratchT = ts[i];
                    ts[i] = ts[i+1];
                    ts[i+1] = scratchT;
                    finished = false;
                }
        }
    }

    public static <T extends Comparable<? super T>> void sort(List<T> list) {
        throw new UnsupportedOperationException();
    }

    public static <T> void sort(List<T> list, Comparator<? super T> c) {
        @SuppressWarnings("unchecked")
        T[] ts = (T[]) list.toArray();
        sort(ts, c);
        ListIterator<T> i = list.listIterator();
        for (T t : ts) {
            i.next();
            i.set(t);
        }
    }
}
