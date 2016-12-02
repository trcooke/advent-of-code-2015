import sys
from sets import Set

MOVES = {
    "^": lambda position: (position[0] + 1, position[1]),
    "v": lambda position: (position[0] - 1, position[1]),
    "<": lambda position: (position[0], position[1] - 1),
    ">": lambda position: (position[0], position[1] + 1)
}


def part1():
    directions = open(sys.argv[1]).read()
    curpos = (0, 0)
    history = Set()
    history.add(curpos)
    for dir in directions:
        curpos = MOVES[dir](curpos)
        history.add(curpos)
    return len(history)


def part2():
    directions = open(sys.argv[1]).read()
    curpos1 = (0, 0)
    history1 = Set()
    history1.add(curpos1)
    curpos2 = (0, 0)
    history2 = Set()
    history2.add(curpos2)
    santa = 0
    for dir in directions:
        if santa == 0:
            curpos1 = MOVES[dir](curpos1)
            history1.add(curpos1)
            santa = 1
        else:
            curpos2 = MOVES[dir](curpos2)
            history2.add(curpos2)
            santa = 0
    return len(history1.union(history2))


print "Part1: " + str(part1())
print "Part2: " + str(part2())
