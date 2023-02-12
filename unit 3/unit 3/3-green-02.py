import sys
file = sys.argv[1]

months = ["blank", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"]
dashformat = []

assortedlist = []
with open(file) as f:
    for line in f:
        n = (line.strip())
        assortedlist.append(n)

def slash2dash(date):
    new = []
    resort = []
    txt = date
    split = txt.split("/")

    resort.append(split[2])
    resort.append(split[0])
    resort.append(split[1])
    for i, c in enumerate(resort):
        if i == 0 and int(c) > 21:
            new.append("19" + str(c) + "-")
        elif i == 0 and int(c) <= 21:
            new.append("20" + str(c) + "-")
        if i == 1 and len(c) > 1:
            new.append(c + "-")
        elif i == 1 and len(c) == 1:
            new.append("0" + str(c) + "-")
        if i == 2 and len(c) > 1:
            new.append(str(c))
        elif i == 2 and len(c) == 1:
            new.append("0" + str(c))
    final = "".join(new)
    return final

def word2dash(date):
    new = []
    txt = date.replace(",", "")
    resort = []
    split = txt.split(" ")

    resort.append(split[2])
    resort.append(split[0])
    resort.append(split[1])
    print(resort)
    for i, c in enumerate(resort):
        if i == 0:
            new.append(c + "-")
        if i == 1 and months.index(c) < 10:
            new.append("0" + str(months.index(c)) + "-")
        elif i == 1 and months.index(c) >= 10:
            new.append(str(months.index(c)) + "-")
        if i == 2 and int(c) < 10:
            new.append("0" + str(c))
        elif i == 2 and int(c) >= 10:
            new.append(str(c))
    final = "".join(new)
    return final

def format_check():
    for date in assortedlist:
        if "," in date:
            dashformat.append(word2dash(date))
        elif "/" in date:
            dashformat.append(slash2dash(date))
        else:
            dashformat.append(date)

format_check()
sorted_final = sorted(dashformat)

with open("sorted_dates.txt", "w") as g:
    for date in sorted_final:
      g.write(date + "\n")