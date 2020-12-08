package com.timdrivendevelopment.adventofcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Day11 {

    String part1() throws IOException {
        return nextValidPassword("hepxcrrq");
    }

    String nextValidPassword(String currentPassword) {
        boolean valid = false;

        String thisPassword = currentPassword;
        do {
            String nextPassword = nextPassword(thisPassword);
            if (isValid(nextPassword)) {
                valid = true;
            }
            thisPassword = nextPassword;
        } while (!valid);
        return thisPassword;
    }

    boolean isValid(String nextPassword) {
        char[] chars = nextPassword.toCharArray();
        boolean consecutiveChars = false;
        for (int i = 0; i < 5; i++) {
            if (chars[i + 1] == chars[i] + 1 && chars[i + 2] == chars[i] + 2) {
                consecutiveChars = true;
                break;
            }
        }
        if (!consecutiveChars) {
            return false;
        }
        if (nextPassword.contains("i") || nextPassword.contains("o") || nextPassword.contains("l")) {
            return false;
        }
        int countPairs = 0;
        for (int i = 0; i < 7; i++) {
            if (chars[i + 1] == chars[i]) {
                countPairs++;
                i++;
            }
        }
        if (countPairs < 2) {
            return false;
        }
        return true;
    }

    String nextPassword(String currentPassword) {
        char[] chars = currentPassword.toCharArray();
        boolean carry = false;
        int index = 7;
        if (chars[index] == 'z') {
            carry = true;
            chars[index] = 'a';
        } else {
            if (chars[index] + 1 == 'i' || chars[index] + 1 == 'o' || chars[index] + 1 == 'l') {
                chars[index] = (char) (chars[index] + 2);
            } else {
                chars[index] = (char) (chars[index] + 1);
            }
        }
        while (carry) {
            index--;
            if (chars[index] == 'z') {
                chars[index] = 'a';
            } else {
                if (chars[index] + 1 == 'i' || chars[index] + 1 == 'o' || chars[index] + 1 == 'l') {
                    chars[index] = (char) (chars[index] + 2);
                } else {
                    chars[index] = (char) (chars[index] + 1);
                }
                carry = false;
            }
        }
        return new String(chars);
    }

    private String part2() throws IOException {
        return nextValidPassword("hepxxyzz");
    }

    private BufferedReader getInput(String inputFile) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream is = classLoader.getResourceAsStream(inputFile);
        InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(isr);
        return reader;
    }

    public static void main(String[] args) throws IOException {
        Day11 solution = new Day11();
        System.out.println(solution.part1());
        System.out.println(solution.part2());
    }

}
