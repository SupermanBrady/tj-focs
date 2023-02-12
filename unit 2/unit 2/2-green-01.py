s = input("Please type a string: ")

print("#1", s[2])
print("#2", s[4])
print("#3", len(s))
print("#4", s[0 : 1])
print("#5", s[len(s) - 1 : len(s)])
print("#6", s[len(s) - 2 : len(s) - 1])
print("#7", s[3 : 8])
print("#8", s[len(s) - 5 : len(s)])
print("#9", s[3 : len(s)])
print("#10", s.lower())
print("#11", s.upper())
temp = []
for letter in s:
    temp.append(letter)
print("#12", temp)
print("#13", s[0: len(s) - 1])
print("#14", s[1: len(s)])
c = "e"
print("#15", s.count(c))
e = "e"
E = "E"
print("#16", s.count("e") + s.count("E"))
count = 0
count = 0
for letter in s:
    if letter in "aeiouAEIOU":
        count = count + 1
print("#17", count)
temp = []
for letter in s:
    if letter in "aeiouAEIOU":
        temp.append(letter)
print("#18", temp)
temp = []
for index, value in enumerate(s):
    if index % 2 == 0:
        temp.append(value)
st = "".join(temp)
print("#19", st)
temp = []
for index, value in enumerate(s):
    if index % 2 != 0:
        temp.append(value)
st = "".join(temp)
print("#20", st)
temp = []
for l in range(len(s) - 1):
    temp.append(s[l:l + 2])
print("#21", temp)
temp = []
for index, value in enumerate(s):
    if index % 3 == 0:
        temp.append("!")
    else:
        temp.append(value)
st = "".join(temp)
print("#22", st)
temp = []
for index, value in enumerate(s):
    if (index + 1)% 3 == 0:
        temp.append("!")
    else:
        temp.append(value)
st = "".join(temp)
print("#23", st)