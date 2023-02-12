# Instructions:
# 1) Run this code, look at the code and output carefully.
# Decide what the symbol < does.
  # < any number "less than" 5 returns 1

def example(x):
  if x != 5:
    return 1
  else:
    return 0

print("Calling with a 4 returns", example(4))
print("Calling with a 4.9 returns", example(4.9))
print("Calling with a 5 returns", example(5))
print("Calling with a 5.1 returns", example(5.1))
print("Calling with a 6 returns", example(6))

# 2) Replace the < symbol with a <= symbol.
#    Decide what the symbol <= does.
#    any number "less than or equal to" 5 

# 3) Replace the <= symbol with a > symbol.
#    Decide what the symbol > does.
#     any number "greater than" 5 

# 4) Replace the > symbol with a >= symbol.
#    Decide what the symbol >= does.
#     any number "greater than or equal to" 5 

# 5) Replace the >= symbol with a == symbol.
#    Decide what the symbol == does.
#     any number "equal to" 5

# 6) Replace the == symbol with a != symbol.
#    Decide what the symbol != does.
#     any number "not equal to" 5

# 7) What if you use a single equal sign, a = symbol?
#    What happens?
#     you get a syntax error



# Then, delete these three quote marks AND the three quote marks at the bottom of the code.
# (This is another way to comment out large blocks of code - surround them with two sets of
# triple quotes!)







# Instructions:
# 8) Run this code, look at the code and output carefully.
#    Guess what the symbol % does.
#      % returns all even numbers with 0 and odd numbers with 1

def mystery(x):
  return x % 3

print("Calling with a 1 returns", mystery(1))
print("Calling with a 2 returns", mystery(2))
print("Calling with a 3 returns", mystery(3))
print("Calling with a 4 returns", mystery(4))
print("Calling with a 5 returns", mystery(5))
print("Calling with a 6 returns", mystery(6))
print("Calling with a 7 returns", mystery(7))
print("Calling with a 8 returns", mystery(8))
print("Calling with a 9 returns", mystery(9))
print("Calling with a 10 returns", mystery(10))

# 9) Change the 2 inside the mystery function to a 3.
#    Run the code again.  Does your theory still work?
#     no

# 10) Change the 3 inside the mystery function to a 4.
#    Run the code again.

# 11) What does the % symbol do?
#       % gives the remainder when dividing the input by the stated number.