import sys
file = sys.argv[1]

def medians_check(list):
    list.sort()
    h = len(list) // 2
    if len(list) % 2 != 0:
        return list[h]
    else:
        return (list[h - 1] + list[h]) / 2

floats = []
with open(file) as f:
    for line in f:
        n = float(line.strip())
        floats.append(n)
s = (sorted(floats))
minimum = s[0]
maximum = s[len(s) - 1]
average = sum(s) / len(s)
median = medians_check(s)
q1 = medians_check(s[0 : len(s)//2])
q3 = medians_check(s[(len(s) // 2) + 1: len(s)])
    
print("Average:", average)
print("Min:", minimum)
print("Q1:", q1)
print("Median:", median)
print("Q3:", q3)
print("Max:", maximum)
print("Sorted List:", s)