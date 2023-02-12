def shrink(x):
    print (x)
    if len(x) == 0:
        return 
    else:
        shrink(x[0: len(x) - 1])

def grow(x):
    if len(x) == 0:
        return 
    else:
        grow(x[0: len(x) - 1])
        print (x)

def shrink_right(x):
    print(x)
    return shrink_right_helper(0, x, 0)

def shrink_right_helper(a, x, p):
    b = len(x)
    if a == b - 1 or p == b - 1:
        return
    else:
        print(" " * (p + 1) + x[a + 1: b])
        shrink_right_helper(a + 1, x, p + 1)

def word_cascade(x):
    grow(x)
    shrink_right_helper(0, x, 0)

def cascade_backwards(x):
    backwards_helper(0, x, 0)
    shrink(x)

def backwards_helper(a, x, p):
    b = len(x)
    if a == b - 1 or p == b - 1:
        return
    else:
        backwards_helper(a + 1, x, p + 1)
        print(" " * (p + 1) + x[a + 1: b])

def snake(x):
    return snake_helper(x, 0, 1)

def snake_helper(x, a, c):
    b = len(x)
    if a == b - 1 and c == b and a % 4 != 3:
        print(" " * (a % 4) + x[a: b])
    elif a == b - 1 and c == b and a % 4 == 3:
        print(" " * 1 + x[a: b])
    elif a % 4 == 3:
        print(" " * 1 + x[a: c])
        snake_helper(x, a + 1, c + 1)
    else:
        print(" " * (a % 4) + x[a: c])
        snake_helper(x, a + 1, c + 1)

def custom_snake(x, s):
    return custom_helper(x, 0, 1, s)

def custom_helper(x, a, c, s):
    b = len(x)
    d = a % ((s - 1) * 2) 
    if a == b - 1 and c == b and d > s - 1:
        print(" " * ((s - 1) * 2 - d) + x[a: c])
    elif a == b - 1 and c == b and d < s - 1:
        print(" " * d + x[a: c])
    elif d > s - 1:
        print(" " * ((s - 1) * 2 - d) + x[a: c])
        custom_helper(x, a + 1, c + 1, s)
    else:
        print(" " * d + x[a: c])
        custom_helper(x, a + 1, c + 1, s)

import sys
s = sys.argv[1]
print("Shrink:")
print()
shrink(s)
print()
print("Grow:")
print()
grow(s)
print()
print("Shrink right:")
print()
shrink_right(s)
print()
print("Word cascade:")
print()
word_cascade(s)
print()
print("Cascade backwards:")
print()
cascade_backwards(s)
print()
print("Snake:")
print()
snake(s)
print()
print("Custom snake:")
print()
custom_snake(s, int(sys.argv[2]))