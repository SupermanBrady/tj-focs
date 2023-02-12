def grid_moves(n, m): 
    if n == 0 or m == 0: 
        return 1
    else:
        return grid_moves(n - 1, m) + grid_moves(n, m - 1)  

def lattice_moves(n, m, l):
    if n == 0: 
        return grid_moves(m, l)
    if m == 0:
        return grid_moves(n, l)
    if l == 0:
        return grid_moves(n, m)
    else:
        return lattice_moves(n - 1, m, l) + lattice_moves(n, m - 1, l) + lattice_moves(n, m, l - 1)

def grid_moves_point(n, m, x, y):
    return grid_moves(x, y) * grid_moves(n - x, m - y)

import sys
n = int(sys.argv[1])
m = int(sys.argv[2])
x = int(sys.argv[3])
y = int(sys.argv[4])
print(grid_moves(n, m))
print(lattice_moves(n, m, x))
print(grid_moves_point(n, m, x, y))