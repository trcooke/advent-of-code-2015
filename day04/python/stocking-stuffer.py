import md5

input = "iwrupvqb"


def part1():
    x = 0
    while True:
        m = md5.new()
        m.update(input)
        m.update(str(x))
        if m.hexdigest().startswith("000000"):
            return x
        else:
            x += 1


print "Part1: " + str(part1())