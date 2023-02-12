def sum_n(n):
    if n == 0:
        return 0
    else:
        return n + sum_n(n - 1)

def sum_squares(n):
    if n == 0:
        return 0
    else:
        return n**2 + sum_squares(n - 1)

def sum_even(n):
    if n == 0:
        return 0
    elif n % 2 == 0:
        return n + sum_even(n - 2)
    elif n % 2 == 1:
        return sum_even(n-1)

def count_threes(n):
    if n < 3:
        return 0
    else:
        return 1 + count_threes(n - 3)

def sum_m_to_n(m, n):
    if m == n:
        return m
    elif m > n:
        return m + sum_m_to_n((m - 1), n)
    else:
        return n + sum_m_to_n(m, (n - 1))

import sys
print(sum_n(int(sys.argv[1])))
print(sum_squares(int(sys.argv[2])))
print(sum_even(int(sys.argv[3])))
print(count_threes(int(sys.argv[4])))
print(sum_m_to_n(int(sys.argv[5]), int(sys.argv[6])))