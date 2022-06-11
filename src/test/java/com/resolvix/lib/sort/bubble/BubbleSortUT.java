package com.resolvix.lib.sort.bubble;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BubbleSortUT {

    BubbleSort algorithm = new BubbleSort();

    @Before
    public void before() {
        //
    }

    //
    //  sort array
    //

    @Test
    public void sortIntegerArray() {
        Integer[] ints = new Integer[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        algorithm.sort(ints, Integer::compareTo);
        Assert.assertThat(
            ints,
            Matchers.arrayContaining(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    @Test
    public void sortCharacterArray() {
        Character[] chars = new Character[] { 'J', 'I', 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A' };
        algorithm.sort(chars, Character::compareTo);
        Assert.assertThat(
            chars,
            Matchers.arrayContaining('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'));
    }

    @Test
    public void sortStringArray() {
        String[] strings = new String[] {
            "one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", "ten" };
        algorithm.sort(strings, String::compareTo);
        Assert.assertThat(
            strings,
            Matchers.arrayContaining(
                "eight", "five", "four", "nine", "one",
                 "seven", "six", "ten", "three", "two"));
    }

    //
    //  sort list
    //

    @Test
    public void sortIntegerList() {
        List<Integer> ints = Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
        algorithm.sort(ints);
        Assert.assertThat(
                ints,
                Matchers.contains(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    @Test
    public void sortCharacterList() {
        List<Character> chars = Arrays.asList('J', 'I', 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A');
        algorithm.sort(chars);
        Assert.assertThat(
                chars,
                Matchers.contains('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'));
    }

    @Test
    public void sortStringList() {
        List<String> strings = Arrays.asList(
                "one", "two", "three", "four", "five",
                "six", "seven", "eight", "nine", "ten");
        algorithm.sort(strings);
        Assert.assertThat(
                strings,
                Matchers.contains(
                        "eight", "five", "four", "nine", "one",
                        "seven", "six", "ten", "three", "two"));
    }
}
