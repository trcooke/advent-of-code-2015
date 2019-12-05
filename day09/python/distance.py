from sets import Set
import itertools

def part1():
    (shortest, longest) = getdistances()
    return shortest

def part2():
    (shortest, longest) = getdistances()
    return longest

def getdistances():
    inp = open("input")
    locations = Set()
    distances = {}
    for line in inp:
        (route, distance) = line.replace("\n", "").split(" = ")
        (source, destination) = route.split(" to ")
        locations.add(source)
        locations.add(destination)
        distances[(source, destination)] = int(distance)
        distances[(destination, source)] = int(distance)
    routes = list(itertools.permutations(locations, len(locations)))
    shortest = 10000000000
    longest = 0
    for route in routes:
        distance = 0
        for location in range(len(route) - 1):
            distance += distances[(route[location], route[location + 1])]
        if distance < shortest:
            shortest = distance
        if distance > longest:
            longest = distance
    return (shortest, longest)

print part1()
print part2()

