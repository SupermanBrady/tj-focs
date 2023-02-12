# If you have a string or list and you want to access each element in it,
# there are three different ways to do that, with different advantages
# and disadvantages.  This demo is worth spending some time on!

ex = "An example string"
ms = "Mississippi"
ls = [97, 84, -112, 23, 57]

# Strategy #1: loop by value.

print("Looping by value:")

for letter in ex:
  print(letter)

print()

for value in ls:
  print(value)

print()

# This creates a temporary variable (letter, or value) and assigns each element
# of the string or list to that temporary variable, one at a time.  This does
# NOT give you information about where you are in the list!  Watch this:

print("The problem with looping by value:")
for letter in ms:
  print(letter, ms.index(letter))

print()

# You might expect this to print out each index one by one, but you'll see that
# it doesn't!  .index will always print out the FIRST index of that character in
# a given string.  So, each time you get to an "i", it prints out "1", because
# that's the index of the FIRST "i" in the string!


# Strategy #2: loop by index.

# To solve the problem above, you might want to keep track of WHERE you are in
# your list or string, instead of WHAT VALUE you're on.  Then, you can access
# each element by that index, instead of directly in the for loop.

# Here's how this works:

print("Looping by index:")

for index in range(len(ex)):
  print(index, ex[index])

print()

# Let's go through this step by step.
# len(ex) returns the length of the string ex.
# range(len(ex)) takes that integer length and makes an iterator from it.  What
#    does that mean, well...
# for index in range(len(ex)) will create a temporary variable, index, and instead
#     of putting each VALUE into that temporary variable one by one, it will get
#     integer numbers from 0 up to the length of the list and put those integers
#     into the temporary variable index, one by one.  But that means we DON'T
#     have the current value in the list or string stored in a temporary variable;
#     we have to access it using ex[index].


# Strategy #3: Use enumerate to get both!

# So: we can loop by value, but that means we don't have any way of accessing
# the index / location of where we are in our string/list right now.  Or, we can
# loop using the index / location, but that means we have to access the value at
# that location each time.  Wouldn't it be nice to get both?

# Well, Python is wonderful, and gives you a way to do that:

print("Using enumerate:")

for index, value in enumerate(ex):
  print(index, value)

print()

for location, number in enumerate(ls):
  print(location, number)

# The enumerate command will return, one by one, TWO temporary values - the
# current index and the current value - and let you store those into TWO
# temporary variables.  The FIRST temporary variable always holds the index, the
# SECOND temporary variable always holds what is at that index.

# This solves both problems - you don't lose the index, and you don't need to
# clumsily access the current value!

# Let your teacher know if you have any questions!