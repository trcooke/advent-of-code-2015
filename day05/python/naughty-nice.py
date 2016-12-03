import sys
from collections import deque


def threevowels(line):
    vowelcount = 0
    for char in line:
        if char in "aeiou":
            vowelcount += 1
    return vowelcount >= 3


def twoletters(line):
    lastletter = ""
    for char in line:
        if char == lastletter:
            return True
        else:
            lastletter = char


def containsspecifics(line):
    if "ab" in line:
        return False
    if "cd" in line:
        return False
    if "pq" in line:
        return False
    if "xy" in line:
        return False
    return True


def part1():
    strings = open(sys.argv[1]).readlines()
    strings = filter(threevowels, strings)
    strings = filter(twoletters, strings)
    strings = filter(containsspecifics, strings)
    return len(strings)


def twoletterstwice(line):
    lastpair = ("-", "-")
    pairs = []
    for char in line:
        if (lastpair[1], char) in pairs and lastpair != (lastpair[1], char):
            return True
        pairs.append((lastpair[1], char))
        lastpair = (lastpair[1], char)
    return False


def splitchars(line):
    lasttwoletters = deque()
    lasttwoletters.append("-")
    lasttwoletters.append("-")
    for char in line:
        lastbutone = lasttwoletters.popleft()
        if char == lastbutone:
            return True
        lasttwoletters.append(char)
    return False


def part2():
    strings = open(sys.argv[1]).readlines()
    strings = filter(twoletterstwice, strings)
    strings = filter(splitchars, strings)
    return len(strings)


print "Part1: " + str(part1())
print "Part2: " + str(part2())
