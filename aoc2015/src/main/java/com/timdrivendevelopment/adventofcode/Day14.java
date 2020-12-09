package com.timdrivendevelopment.adventofcode;

import com.google.common.base.Objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Day14 {

    private int part1() throws IOException {
        BufferedReader reader = getInput("InputDay14");
        Set<Reindeer> reindeerSet = new HashSet<>();
        int furthest = 0;
        for (String line; (line = reader.readLine()) != null;) {
            String[] split = line.split(" ");
            Reindeer reindeer = new Reindeer(
                    split[0],
                    Integer.parseInt(split[3]),
                    Integer.parseInt(split[6]),
                    Integer.parseInt(split[13]));
            int thisDistance = reindeer.distanceAfter(2503);
            reindeerSet.add(reindeer);
            if (thisDistance > furthest) {
                furthest = thisDistance;
            }
        }
        return furthest;
    }

    private int part2() throws IOException {
        BufferedReader reader = getInput("InputDay14");
        Set<Reindeer> reindeerSet = new HashSet<>();
        int furthest = 0;
        for (String line; (line = reader.readLine()) != null;) {
            String[] split = line.split(" ");
            Reindeer reindeer = new Reindeer(
                    split[0],
                    Integer.parseInt(split[3]),
                    Integer.parseInt(split[6]),
                    Integer.parseInt(split[13]));
            reindeerSet.add(reindeer);
        }
        Map<Reindeer, Integer> scores = new HashMap<>();
        for (Reindeer reindeer : reindeerSet) {
            scores.put(reindeer, 0);
        }
        for (int time = 1; time <= 2503; time++) {
            Set<Reindeer> winners = new HashSet<>();
            int winnerDistance = 0;
            for (Reindeer reindeer : reindeerSet) {
                int distance = reindeer.distanceAfter(time);
                if (distance > winnerDistance) {
                    winners.clear();
                    winners.add(reindeer);
                    winnerDistance = distance;
                } else if (distance == winnerDistance) {
                    winners.add(reindeer);
                }
            }
            for (Reindeer winner : winners) {
                scores.put(winner, scores.get(winner) + 1);
            }
        }
        return scores.values().stream().max(Integer::compareTo).get();
    }

    private BufferedReader getInput(String inputFile) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream is = classLoader.getResourceAsStream(inputFile);
        InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(isr);
        return reader;
    }

    public static void main(String[] args) throws IOException {
        Day14 solution = new Day14();
        System.out.println(solution.part1());
        System.out.println(solution.part2());
    }

    static class Reindeer {
        private final String name;
        private final int speed;
        private final int flyTime;
        private final int restTime;

        public Reindeer(String name, int speed, int flyTime, int restTime) {
            this.name = name;
            this.speed = speed;
            this.flyTime = flyTime;
            this.restTime = restTime;
        }

        @Override
        public String toString() {
            return "Reindeer{" +
                    "name='" + name + '\'' +
                    ", speed=" + speed +
                    ", flyTime=" + flyTime +
                    ", restTime=" + restTime +
                    '}';
        }

        public int distanceAfter(int time) {
            int flyRestCycles = (time / (flyTime + restTime));
            int distance = flyRestCycles * flyTime * speed;
            int remainder = time % (flyTime + restTime);
            if (remainder <= flyTime) {
                distance += remainder * speed;
            } else {
                distance += flyTime * speed;
            }
            return distance;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Reindeer reindeer = (Reindeer) o;
            return speed == reindeer.speed &&
                    flyTime == reindeer.flyTime &&
                    restTime == reindeer.restTime &&
                    Objects.equal(name, reindeer.name);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(name, speed, flyTime, restTime);
        }
    }
}
