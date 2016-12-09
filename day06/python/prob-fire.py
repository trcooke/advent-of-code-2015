import sys


def task1():
    lines = open(sys.argv[1]).readlines()
    grid = [[0 for x in range(1000)] for y in range(1000)]

    for line in lines:
        line = line.replace("\n", "")
        if line.startswith("turn on "):
            ra = line.lstrip("turn on ").split(" through ")
            fr = ra[0].split(",")
            to = ra[1].split(",")
            for cell in [(x, y) for x in range(int(fr[0]), int(to[0]) + 1) for y in range(int(fr[1]), int(to[1]) + 1)]:
                grid[cell[0]][cell[1]] = 1
        elif line.startswith("turn off"):
            ra = line.lstrip("turn off ").split(" through ")
            fr = ra[0].split(",")
            to = ra[1].split(",")
            for cell in [(x, y) for x in range(int(fr[0]), int(to[0]) + 1) for y in range(int(fr[1]), int(to[1]) + 1)]:
                grid[cell[0]][cell[1]] = 0
        else:
            ra = line.lstrip("toggle ").split(" through ")
            fr = ra[0].split(",")
            to = ra[1].split(",")
            for cell in [(x, y) for x in range(int(fr[0]), int(to[0]) + 1) for y in range(int(fr[1]), int(to[1]) + 1)]:
                if grid[cell[0]][cell[1]] == 0:
                    grid[cell[0]][cell[1]] = 1
                else:
                    grid[cell[0]][cell[1]] = 0

    lightsum = 0
    for row in grid:
        lightsum += reduce(lambda x, y: x+y, row)
    return lightsum


def task2():
    lines = open(sys.argv[1]).readlines()
    grid = [[0 for x in range(1000)] for y in range(1000)]

    for line in lines:
        line = line.replace("\n", "")
        if line.startswith("turn on "):
            ra = line.lstrip("turn on ").split(" through ")
            fr = ra[0].split(",")
            to = ra[1].split(",")
            for cell in [(x, y) for x in range(int(fr[0]), int(to[0]) + 1) for y in range(int(fr[1]), int(to[1]) + 1)]:
                grid[cell[0]][cell[1]] += 1
        elif line.startswith("turn off"):
            ra = line.lstrip("turn off ").split(" through ")
            fr = ra[0].split(",")
            to = ra[1].split(",")
            for cell in [(x, y) for x in range(int(fr[0]), int(to[0]) + 1) for y in range(int(fr[1]), int(to[1]) + 1)]:
                if grid[cell[0]][cell[1]] != 0:
                    grid[cell[0]][cell[1]] -= 1
        else:
            ra = line.lstrip("toggle ").split(" through ")
            fr = ra[0].split(",")
            to = ra[1].split(",")
            for cell in [(x, y) for x in range(int(fr[0]), int(to[0]) + 1) for y in range(int(fr[1]), int(to[1]) + 1)]:
                grid[cell[0]][cell[1]] += 2

    lightsum = 0
    for row in grid:
        lightsum += reduce(lambda x, y: x+y, row)
    return lightsum


print "Task1: " + str(task1())
print "Task2: " + str(task2())
