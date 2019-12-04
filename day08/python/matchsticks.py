def part1():
    inp = open("input")

    total = 0
    for line in inp:
        line = line.replace("\n", "")
        total += len(line) - len(eval(line))
    return total

def part2():
    inp = open("input")

    total = 0
    for line in inp:
        line = line.replace("\n", "")
        total += len(encode(line)) - len(line)
    return total

def encode(string):
    string = string.replace("\\", "\\\\")
    string = string.replace("\"", "\\\"")
    return "\"" + string + "\""

print part1()
print part2()
