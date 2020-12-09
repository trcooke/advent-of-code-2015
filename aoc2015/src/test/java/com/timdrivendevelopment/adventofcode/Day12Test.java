package com.timdrivendevelopment.adventofcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Day12Test {

    Day12 day12 = new Day12();
    Set<String> valueBlacklist = new HashSet<>();

    @Test
    public void testSumIntegersExample1() {
        assertThat(day12.sumIntegers("{0:[1,2,3]}", valueBlacklist), is(6));
    }

    @Test
    public void testSumIntegersExample2() {
        assertThat(day12.sumIntegers("{\"a\":2,\"b\":4}", valueBlacklist), is(6));
    }

    @Test
    public void testSumIntegersExample3() {
        assertThat(day12.sumIntegers("{0:[[[3]]]}", valueBlacklist), is(3));
    }

    @Test
    public void testSumIntegersExample4() {
        assertThat(day12.sumIntegers("{\"a\":{\"b\":4},\"c\":-1}", valueBlacklist), is(3));
    }

    @Test
    public void testSumIntegersExample5() {
        assertThat(day12.sumIntegers("{\"a\":[-1,1]}", valueBlacklist), is(0));
    }

    @Test
    public void testSumIntegersExample6() {
        assertThat(day12.sumIntegers("{0:[-1,{\"a\":1}]}", valueBlacklist), is(0));
    }

    @Test
    public void testSumIntegersExample7() {
        assertThat(day12.sumIntegers("{0:[]}", valueBlacklist), is(0));
    }

    @Test
    public void testSumIntegersExample8() {
        assertThat(day12.sumIntegers("{}}", valueBlacklist), is(0));
    }
}