package com.timdrivendevelopment.adventofcode;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Day14Test {

    @Test
    public void timeDuringFirstFlyCycle() {
        Day14.Reindeer reindeer = new Day14.Reindeer("Test", 5, 10, 20);
        assertThat(reindeer.distanceAfter(5), is(25));
    }

    @Test
    public void timeDuringFirstRestCycle() {
        Day14.Reindeer reindeer = new Day14.Reindeer("Test", 5, 10, 20);
        assertThat(reindeer.distanceAfter(15), is(50));
    }

}