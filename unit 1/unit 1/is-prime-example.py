def is_prime(x):
    if x < 2:
        return False
    elif x == 2:
        return True
    elif x % 2 == 0:
        return False
    else:
        return is_prime_helper(x, 3)

def is_prime_helper(x, f):
    if f*f > x:
        return True
    elif x % f == 0:
        return False
    else:
        return is_prime_helper(x, f + 2)

print(is_prime(2938927))