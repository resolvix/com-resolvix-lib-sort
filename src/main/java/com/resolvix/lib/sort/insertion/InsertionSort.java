package com.resolvix.lib.sort.insertion;

import com.resolvix.lib.sort.api.SortAlgorithm;

import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public class InsertionSort
    implements SortAlgorithm
{

    public <T> void sort(T[] ts, Comparator<? super T> c) {
        int i_max = ts.length;
        for (int i = 0; i < i_max; i++) {
            int j = i;
            while (j > 0 && c.compare(ts[j - 1], ts[j]) > 0) {
                T scratchT = ts[j];
                ts[j] = ts[j - 1];
                ts[--j] = scratchT;
            }
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
