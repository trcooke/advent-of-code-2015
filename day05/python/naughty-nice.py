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
    line = line.replace("\n", "")
    lastpair = ("-", "-")
    pairs = []
    for char in line:
        thispair = (lastpair[1], char)
        print str(lastpair) + str(thispair)
        if thispair in pairs and lastpair != thispair:
            print "Twice: " + str(thispair)
            return True
        if lastpair == thispair:
            lastpair = ("", char)
        else:
            lastpair = thispair
        pairs.append(thispair)
    return False


def splitchars(line):
    line = line.replace("\n", "")
    lasttwoletters = deque()
    lasttwoletters.append("-")
    lasttwoletters.append("-")
    for char in line:
        lastbutone = lasttwoletters.popleft()
        if char == lastbutone:
            print "Split: " + str((char, lastbutone))
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
