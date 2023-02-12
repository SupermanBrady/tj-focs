def sum_arithmetic(n_terms, start_val, inc_val):
    if n_terms == 0:
        return 0
    elif n_terms > 0:
        return start_val + sum_arithmetic(n_terms - 1, start_val + inc_val, inc_val)

def sum_geometric(n_terms, start_val, mult_val):
    if n_terms == 0:
        return 0
    elif n_terms > 0:
        return start_val + sum_geometric(n_terms - 1, start_val * mult_val, mult_val)

import sys
a = float(sys.argv[1])
b = float(sys.argv[2])
c = float(sys.argv[3])
print(sum_arithmetic(a, b, c))
print(sum_geometric(a, b, c))