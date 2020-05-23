package com.resolvix.lib.sort.bubble;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BubbleSortUT {

    @Test
    public void sortIntegerArray() {
        Integer[] ints = new Integer[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        BubbleSort.sort(ints, Integer::compareTo);
        Assert.assertThat(
            ints,
            Matchers.arrayContaining(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    @Test
    public void sortIntegerList() {
        List<Integer> ints = Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
        BubbleSort.sort(ints, Integer::compareTo);
        Assert.assertThat(
            ints,
            Matchers.contains(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    @Test
    public void sortCharacterArray() {
        Character[] chars = new Character[] { 'J', 'I', 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A' };
        BubbleSort.sort(chars, Character::compareTo);
        Assert.assertThat(
            chars,
            Matchers.arrayContaining('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'));
    }

    @Test
    public void sortStringArray() {
        String[] strings = new String[] {
            "one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", "ten" };
        BubbleSort.sort(strings, String::compareTo);
        Assert.assertThat(
            strings,
            Matchers.arrayContaining(
                "eight", "five", "four", "nine", "one",
                 "seven", "six", "ten", "three", "two"));
    }
}
