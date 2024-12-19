package com.resolvix.lib.sort.bubble;

import com.resolvix.lib.sort.api.SortAlgorithm;

import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

/**
 *  Provides generic implementations of the BubbleSort algorithm
 */
public class BubbleSort
    implements SortAlgorithm
{

    public <T> void sort(T[] ts, Comparator<? super T> c) {
        boolean finished = false;
        int i_max = ts.length;
        for (int i = 0; i < i_max - 1; i++)
            for (int j = i + 1; j < i_max; j++)
                if (c.compare(ts[i], ts[j]) > 0) {
                    T scratchT = ts[i];
                    ts[i] = ts[j];
                    ts[j] = scratchT;
                }
    }

    public <T> void sort(List<T> list, Comparator<? super T> c) {
        @SuppressWarnings("unchecked")
        T[] ts = (T[]) list.toArray();
        sort(ts, c);
        ListIterator<T> i = list.listIterator();
        for (T t : ts) {
            i.next();
            i.set(t);
        }
    }

    public <T extends Comparable<? super T>> void sort(List<T> list) {
        sort(list, T::compareTo);
    }
}
