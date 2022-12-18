package com.resolvix.lib.sort.shell;

import com.resolvix.lib.sort.api.SortAlgorithm;

import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public class ShellSort
    implements SortAlgorithm
{

    public <T> void sort(T[] ts, Comparator<? super T> c) {
        int k = ts.length;
        while (k != 0) {
            k /= 2;
            int i_max = ts.length;
            for (int i = k; i < i_max; i++) {
                T scratchT = ts[i];
                int j = i;
                for (j = i; (j >= k) && (c.compare(ts[j - k], scratchT) > 0); j -= k) {
                    ts[j] = ts[j - k];
                }
                ts[j] = scratchT;
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
