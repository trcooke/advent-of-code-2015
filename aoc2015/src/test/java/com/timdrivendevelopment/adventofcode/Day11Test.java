package com.timdrivendevelopment.adventofcode;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Day11Test {

    Day11 day11 = new Day11();

    @Test
    public void aTob() {
        assertThat(day11.nextPassword("aaaaaaaa"), is("aaaaaaab"));
    }

    @Test
    public void azToba() {
        assertThat(day11.nextPassword("aaaaaaaz"), is("aaaaaaba"));
    }

    @Test
    public void gzzzThaaa() {
        assertThat(day11.nextPassword("aaaagzzz"), is("aaaahaaa"));
    }

    @Test
    public void isValidExample1() {
        assertThat(day11.isValid("hijklmmn"), is(false));
    }

    @Test
    public void isValidExample2() {
        assertThat(day11.isValid("abbceffg"), is(false));
    }

    @Test
    public void isValidExample3() {
        assertThat(day11.isValid("abbcegjk"), is(false));
    }

    @Test
    public void nextValidExample1() throws IOException {
        assertThat(day11.nextValidPassword("abcdefgh"), is("abcdffaa"));
    }

    @Test
    public void nextValidExample2() throws IOException {
        assertThat(day11.nextValidPassword("ghijklmn"), is("ghjaabcc"));
    }
}