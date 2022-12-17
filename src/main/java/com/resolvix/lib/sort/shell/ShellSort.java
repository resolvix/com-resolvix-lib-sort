package com.resolvix.lib.sort.shell;

import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public class ShellSort {

    private static <T> int[] getGapSequence(T[] ts) {
        return new int[] { 5, 2, 1 };
    }

    public static <T> void sort(T[] ts, Comparator<T> c) {
        int[] gapSequence = getGapSequence(ts);
        for (int gap : gapSequence) {
            int i_max = ts.length;
            for (int i = gap; i < i_max; i++) {
                T scratchT = ts[i];
                int j = i;
                for (j = i; (j >= gap) && (c.compare(ts[j - gap], scratchT) > 0); j -= gap) {
                    ts[j] = ts[j - gap];
                }
                ts[j] = scratchT;
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
