def part1():
    sequence = map(int, "3113322113")
    return seqlen(sequence, 40)

def part2():
    sequence = map(int, "3113322113")
    return seqlen(sequence, 50)

def seqlen(sequence, itercount):
    for i in range(itercount):
        newsequence = []
        lastdigit = 0
        digitcount = 1
        for digit in sequence:
            if digit == lastdigit:
                digitcount += 1
            elif lastdigit != 0:
                newsequence.append(digitcount)
                newsequence.append(lastdigit)
                digitcount = 1
            lastdigit = digit
        newsequence.append(digitcount)
        newsequence.append(lastdigit)
        sequence = newsequence[:]
    return len(newsequence)

print part1()
print part2()
