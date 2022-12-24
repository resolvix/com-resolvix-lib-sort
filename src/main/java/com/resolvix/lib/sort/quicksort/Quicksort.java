package com.resolvix.lib.sort.quicksort;

import com.resolvix.lib.sort.api.SortAlgorithm;

import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public class Quicksort
    implements SortAlgorithm
{

    private <T> int partition(T[] ts, Comparator<T> c, int m, int n) {
        int p = (m + n) / 2;
        T pivot = ts[p];
        int i = m;
        int j = n;
        while (true) {
            while (c.compare(ts[i], pivot) < 0) i++;
            while (c.compare(ts[j], pivot) > 0) j--;
            if (i >= j)
                break;

            T scratchT = ts[i];
            ts[i] = ts[j];
            ts[j] = scratchT;
        }

        return j;
    }

    private <T> void quicksort(T[] ts, Comparator<T> c, int m, int n) {
        if (m < n) {
            int p = partition(ts, c, m, n);
            quicksort(ts, c, m, p);
            quicksort(ts, c, p + 1, n);
        }
    }

    public <T> void sort(T[] ts, Comparator<? super T> c) {
        quicksort(ts, c, 0, ts.length - 1);
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
