def gcd(x, y):
    if x == 0:
        return y
    if y == 0:
        return x
    if x == 1 or y == 1:
        return 1
    elif x > y:
        return gcd_helper(x, y, y)
    elif y > x:
        return gcd_helper(x, y, x)

def gcd_helper(x, y, f): 
    if f == 1:
        return 1
    if x % f == 0 and y % f == 0:
        return f
    else:
        return gcd_helper(x, y, f - 1) 

def gcd_euclid(x, y):
    if y == 0:
        return x
    else:
        return gcd_euclid(y, x % y)

def lcm(x, y):
    return (x * y) / gcd_euclid(y, x % y)

def lcm_n(n):
    if n == 1:
        return 1
    else:
        return lcm(n, lcm_n(n - 1))

print(lcm_n(20))

import sys
x = int(sys.argv[1])
y = int(sys.argv[2])
n = int(sys.argv[3])
print(gcd(x, y))
print(gcd_euclid(x, y))
print(lcm(x, y))
print(lcm_n(n))