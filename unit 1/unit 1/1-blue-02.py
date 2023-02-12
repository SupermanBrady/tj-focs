import sys
sys.setrecursionlimit(500000)

def mult_3_5(n):
    if n % 3 == 0:
        return True
    elif n % 5 == 0:
        return True
    else:
        return False

def sum_no_3_5(n):
    if n == 0:
        return 0
    elif not mult_3_5(n): 
        return n + sum_no_3_5(n - 1)
    elif mult_3_5(n):
        return 0 + sum_no_3_5(n - 1)

def ends_with_1_or_3(n):
    if ((n - 1) % 10) == 0 or (n - 1) == 0:
        return True
    elif ((n - 3) % 10) == 0 or (n - 3) == 0:
        return True
    else: 
        return False

def sum_ends_1_or_3(n):
    if n == 0:
        return 0 
    elif ends_with_1_or_3(n):
        return n + sum_ends_1_or_3(n - 1)
    elif not ends_with_1_or_3(n):
        return 0 + sum_ends_1_or_3(n - 1)

def odd_number_digits(n):
    if n < 10 and n > 0:
        return True
    elif n // 10 >= 1 and n // 10 < 10:
        return False
    elif n // 10 >= 10 and n // 10 < 100:
        return True
    elif n // 10 >= 100 and n // 10 < 1000:
        return False 
    elif n // 10 >= 1000 and n // 10 < 10000:
        return True
    elif n // 10 >= 10000 and n // 10 < 100000:
        return False

def sum_odd_digits(n):
    if n == 0:
        return 0
    elif odd_number_digits(n):
        return n + sum_odd_digits(n - 1)
    elif not odd_number_digits(n):
        return sum_odd_digits(n - 1) 

import sys
print(sum_no_3_5(int(sys.argv[1])))
print(ends_with_1_or_3(int(sys.argv[2])))
print(sum_ends_1_or_3(int(sys.argv[3])))
print(odd_number_digits(int(sys.argv[4])))
print(sum_odd_digits(int(sys.argv[5])))