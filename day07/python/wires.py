import sys

wires = {}
cache = {}


def doand(x, y):
    # print "AND " + x + " " + y
    if ("AND", x, y) in cache:
        return cache[("AND", x, y)]
    else:
        val = (getwire(x)[2](getwire(x)[0], getwire(x)[1]) & getwire(y)[2](getwire(y)[0], getwire(y)[1])) % 2 ** 16
        cache[("AND", x, y)] = val
        return val


def door(x, y):
    # print "OR " + x + " " + y
    if ("OR", x, y) in cache:
        return cache[("OR", x, y)]
    else:
        val = (getwire(x)[2](getwire(x)[0], getwire(x)[1]) | getwire(y)[2](getwire(y)[0], getwire(y)[1])) % 2 ** 16
        cache[("OR", x, y)] = val
        return val


def dolsh(x, y):
    # print "LSH " + x + " " + y
    if ("LSH", x, y) in cache:
        return cache[("LSH", x, y)]
    else:
        val = (getwire(x)[2](getwire(x)[0], getwire(x)[1]) << int(y)) % 2 ** 16
        cache[("LSH", x, y)] = val
        return val


def dorsh(x, y):
    # print "RSH " + x + " " + y
    if ("RSH", x, y) in cache:
        return cache[("RSH", x, y)]
    else:
        val = (getwire(x)[2](getwire(x)[0], getwire(x)[1]) >> int(y)) % 2 ** 16
        cache[("RSH", x, y)] = val
        return val


def donot(x, y):
    # print "NOT " + x
    if ("NOT", x, y) in cache:
        return cache[("NOT", x, y)]
    else:
        val = ~(getwire(x)[2](getwire(x)[0], getwire(x)[1])) % 2 ** 16
        cache[("NOT", x, y)] = val
        return val


def doin(x, y):
    # print "IN " + x
    return int(x)


def dolink(x, y):
    # print "LNK " + x
    if ("LNK", x, y) in cache:
        return cache[("LNK", x, y)]
    else:
        val = getwire(x)[2](getwire(x)[0], getwire(x)[1])
        cache[("LNK", x, y)] = val
        return val


def getwire(wire):
    if wire.isdigit():
        return wire, 0, lambda x, y: int(x)
    else:
        return wires[wire]


def part1():
    lines = open(sys.argv[1]).readlines()
    cache.clear()
    for line in lines:
        line = line.replace("\n", "")
        instr = line.split()
        if "AND" in line:
            wires[instr[4]] = (instr[0], instr[2], lambda x, y: doand(x, y))
        elif "OR" in line:
            wires[instr[4]] = (instr[0], instr[2], lambda x, y: door(x, y))
        elif "LSHIFT" in line:
            wires[instr[4]] = (instr[0], instr[2], lambda x, y: dolsh(x, y))
        elif "RSHIFT" in line:
            wires[instr[4]] = (instr[0], instr[2], lambda x, y: dorsh(x, y))
        elif "NOT" in line:
            wires[instr[3]] = (instr[1], 0, lambda x, y: donot(x, y))
        else:
            if instr[0].isdigit():
                wires[instr[2]] = (instr[0], 0, lambda x, y: doin(x, y))
            else:
                wires[instr[2]] = (instr[0], 0, lambda x, y: dolink(x, y))
    d = wires["a"]
    return d[2](d[0], d[1])


def part2():
    lines = open(sys.argv[1]).readlines()
    cache.clear()
    for line in lines:
        line = line.replace("\n", "")
        instr = line.split()
        if "AND" in line:
            wires[instr[4]] = (instr[0], instr[2], lambda x, y: doand(x, y))
        elif "OR" in line:
            wires[instr[4]] = (instr[0], instr[2], lambda x, y: door(x, y))
        elif "LSHIFT" in line:
            wires[instr[4]] = (instr[0], instr[2], lambda x, y: dolsh(x, y))
        elif "RSHIFT" in line:
            wires[instr[4]] = (instr[0], instr[2], lambda x, y: dorsh(x, y))
        elif "NOT" in line:
            wires[instr[3]] = (instr[1], 0, lambda x, y: donot(x, y))
        else:
            if instr[0].isdigit():
                wires[instr[2]] = (instr[0], 0, lambda x, y: doin(x, y))
            else:
                wires[instr[2]] = (instr[0], 0, lambda x, y: dolink(x, y))
    wires["b"] = (part1(), 0, lambda x, y: doin(x, y))
    cache.clear()
    d = wires["a"]
    return d[2](d[0], d[1])


print "Part1: " + str(part1())
print "Part2: " + str(part2())
