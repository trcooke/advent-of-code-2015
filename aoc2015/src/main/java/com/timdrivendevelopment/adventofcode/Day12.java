package com.timdrivendevelopment.adventofcode;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Day12 {

    private int part1() throws IOException {
        BufferedReader reader = getInput("InputDay12");
        StringBuilder jsonInput = new StringBuilder();
        for (String line; (line = reader.readLine()) != null;) {
            jsonInput.append(line);
        }
        Set<String> valueBlacklist = new HashSet<>();
        int sum = sumIntegers(jsonInput.toString(), valueBlacklist);
        return sum;
    }

    int sumIntegers(String jsonInput, Set<String> valueBlacklist) {
        JSONObject jsonObject = new JSONObject(jsonInput);
        int sum = handleValue(jsonObject, valueBlacklist, 0);
        return sum;
    }

    int handleValue(Object value, Set<String> valueBlacklist, int acc) {
        if (value instanceof JSONObject) {
            acc = handleJSONObject((JSONObject) value, valueBlacklist, acc);
        } else if (value instanceof JSONArray) {
            acc = handleJSONArray((JSONArray) value, valueBlacklist, acc);
        } else {
            try {
                int val = Integer.parseInt(value.toString());
                acc += val;
            } catch (NumberFormatException e) {
                // noop
            }
        }
        return acc;
    }

    int handleJSONObject(JSONObject jsonObject, Set<String> valueBlacklist, int acc) {
        int originalAcc = acc;
        Iterator<String> keys = jsonObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                int keyInt = Integer.parseInt(next);
                acc += keyInt;
            } catch (NumberFormatException e) {
                // noop
            }
            if (valueBlacklist.contains(jsonObject.get(next))) {
                return originalAcc;
            }
            acc = handleValue(jsonObject.get(next), valueBlacklist, acc);
        }
        return acc;
    }

    int handleJSONArray(JSONArray jsonArray, Set<String> valueBlacklist, int acc) {
        for (Object next : jsonArray) {
            acc = handleValue(next, valueBlacklist, acc);
        }
        return acc;
    }

    private int part2() throws IOException {
        BufferedReader reader = getInput("InputDay12");
        StringBuilder jsonInput = new StringBuilder();
        for (String line; (line = reader.readLine()) != null;) {
            jsonInput.append(line);
        }
        Set<String> valueBlacklist = new HashSet<>();
        valueBlacklist.add("red");
        int sum = sumIntegers(jsonInput.toString(), valueBlacklist);
        return sum;
    }

    private BufferedReader getInput(String inputFile) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream is = classLoader.getResourceAsStream(inputFile);
        InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(isr);
        return reader;
    }

    public static void main(String[] args) throws IOException {
        Day12 solution = new Day12();
        System.out.println(solution.part1());
        System.out.println(solution.part2());
    }
}
