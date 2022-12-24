package com.resolvix.lib.sort.heap;

import com.resolvix.lib.sort.api.SortAlgorithm;

import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public class HeapSort
    implements SortAlgorithm
{

    private <T> void swap(T[] ts, int i, int j) {
        T scratchT = ts[i];
        ts[i] = ts[j];
        ts[j] = scratchT;
    }

    private <T> void heapify(T[] ts, Comparator<? super T> c, int n, int i) {
        int l = 2 * i + 1;
        int m = i;
        if (l > n)
            return;
        if (c.compare(ts[l], ts[m]) > 0)
            m = l;
        int r = l + 1;
        if (r < n && c.compare(ts[r], ts[m]) > 0)
            m = r;
        if (m == i)
            return;
        swap(ts, i, m);
        heapify(ts, c, n, m);
    }

    public <T> void sort(T[] ts, Comparator<? super T> c) {
        int n = ts.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(ts, c, n, i);

        for (int i = 0; i < n; i++) {
            swap(ts, 0, n - i - 1);
            heapify(ts, c, n - i - 2, 0);
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
