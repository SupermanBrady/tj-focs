temp = []
def triples(x, y, z):
    for i in range(200):
        if x**2 + y**2 == z**3:
            temp.append("hi")
            triples(x + i, y, z)
        else:
            triples(x + i, y, z)
    for i in range(200):
        if x**2 + y**2 == z**3:
            temp.append("hi")
            triples(x, y + i, z)
        else:
            triples(x, y + i, z)
    for i in range(200):
        if x**2 + y**2 == z**3:
            temp.append("hi")
            triples(x, y, z + i)
        else:
            triples(x, y, z + i)
    print(temp)

triples(0, 0, 0)