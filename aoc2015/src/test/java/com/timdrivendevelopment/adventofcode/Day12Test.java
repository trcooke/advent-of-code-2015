package com.timdrivendevelopment.adventofcode;

import junit.framework.TestCase;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Day12Test extends TestCase {

    Day12 day12 = new Day12();
    Set<String> valueBlacklist = new HashSet<>();

    public void testSumIntegersExample1() {
        assertThat(day12.sumIntegers("{0:[1,2,3]}", valueBlacklist), is(6));
    }

    public void testSumIntegersExample2() {
        assertThat(day12.sumIntegers("{\"a\":2,\"b\":4}", valueBlacklist), is(6));
    }

    public void testSumIntegersExample3() {
        assertThat(day12.sumIntegers("{0:[[[3]]]}", valueBlacklist), is(3));
    }

    public void testSumIntegersExample4() {
        assertThat(day12.sumIntegers("{\"a\":{\"b\":4},\"c\":-1}", valueBlacklist), is(3));
    }

    public void testSumIntegersExample5() {
        assertThat(day12.sumIntegers("{\"a\":[-1,1]}", valueBlacklist), is(0));
    }

    public void testSumIntegersExample6() {
        assertThat(day12.sumIntegers("{0:[-1,{\"a\":1}]}", valueBlacklist), is(0));
    }

    public void testSumIntegersExample7() {
        assertThat(day12.sumIntegers("{0:[]}", valueBlacklist), is(0));
    }

    public void testSumIntegersExample8() {
        assertThat(day12.sumIntegers("{}}", valueBlacklist), is(0));
    }
}