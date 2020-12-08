package com.timdrivendevelopment.adventofcode;

import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Day13 {

    private int part1() throws IOException {
        BufferedReader reader = getInput("InputDay13");
        Map<Set<String>, Integer> hapinessFactors = new HashMap<>();
        for (String line; (line = reader.readLine()) != null;) {
            line = line.replace(".", "");
            line.split(" ");
            Set<String> personCombo = new HashSet<>();
            personCombo.add(line.split(" ")[0]);
            personCombo.add(line.split(" ")[10]);
            int units = Integer.parseInt(line.split(" ")[3]);
            if (line.split(" ")[2].equals("lose")) {
                units *= -1;
            }
            if (!hapinessFactors.containsKey(personCombo)) {
                hapinessFactors.put(personCombo, units);
            } else {
                hapinessFactors.put(personCombo, hapinessFactors.get(personCombo) + units);
            }
        }
        Set<String> allAttendees = new HashSet<>();
        for (Set<String> strings : hapinessFactors.keySet()) {
            allAttendees.addAll(strings);
        }
        Collection<List<String>> permutations = Collections2.permutations(allAttendees);
        int highestHappinessScore = 0;
        for (List<String> permutation : permutations) {
            int thisHappinessScore = computeHappinessScore(permutation, hapinessFactors);
            if (thisHappinessScore > highestHappinessScore) {
                highestHappinessScore = thisHappinessScore;
            }
        }

        return highestHappinessScore;
    }

    private int computeHappinessScore(List<String> permutation, Map<Set<String>, Integer> hapinessFactors) {
        int score = 0;
        for (int i = 0; i < permutation.size(); i++) {
            int nextIndex = (i + 1) % permutation.size();
            Set<String> personCombo = new HashSet<>();
            personCombo.add(permutation.get(i));
            personCombo.add(permutation.get(nextIndex));
            score += hapinessFactors.get(personCombo);
        }
        return score;
    }

    private int part2() throws IOException {
        BufferedReader reader = getInput("InputDay13");
        Map<Set<String>, Integer> hapinessFactors = new HashMap<>();
        for (String line; (line = reader.readLine()) != null;) {
            line = line.replace(".", "");
            line.split(" ");
            Set<String> personCombo = new HashSet<>();
            personCombo.add(line.split(" ")[0]);
            personCombo.add(line.split(" ")[10]);
            int units = Integer.parseInt(line.split(" ")[3]);
            if (line.split(" ")[2].equals("lose")) {
                units *= -1;
            }
            if (!hapinessFactors.containsKey(personCombo)) {
                hapinessFactors.put(personCombo, units);
            } else {
                hapinessFactors.put(personCombo, hapinessFactors.get(personCombo) + units);
            }
        }
        Set<String> allAttendees = new HashSet<>();
        for (Set<String> strings : hapinessFactors.keySet()) {
            allAttendees.addAll(strings);
        }
        for (String attendee : allAttendees) {
            hapinessFactors.put(ImmutableSet.of("Tim", attendee), 0);
        }
        allAttendees.add("Tim");
        Collection<List<String>> permutations = Collections2.permutations(allAttendees);
        int highestHappinessScore = 0;
        for (List<String> permutation : permutations) {
            int thisHappinessScore = computeHappinessScore(permutation, hapinessFactors);
            if (thisHappinessScore > highestHappinessScore) {
                highestHappinessScore = thisHappinessScore;
            }
        }

        return highestHappinessScore;
    }

    private BufferedReader getInput(String inputFile) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream is = classLoader.getResourceAsStream(inputFile);
        InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(isr);
        return reader;
    }

    public static void main(String[] args) throws IOException {
        Day13 solution = new Day13();
        System.out.println(solution.part1());
        System.out.println(solution.part2());
    }
}
