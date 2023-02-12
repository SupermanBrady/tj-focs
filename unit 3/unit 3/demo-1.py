# Here are a bunch of demonstrations of python commands!

# Ask the user for a string:
s = input("Please type a string: ")

# Ask the user for a number, and convert it to an integer:
temp = input("Please type an integer: ")
num = int(temp)

# Print the requested character from the given string
print("The character at index", num, "in string", s, "is", s[num])

# Print three characters starting from a certain index
print("The three characters starting at index", num, "are", s[num:num+3])

# Change the case of the string
u = s.upper()
l = s.lower()
print("Uppercase:", u)
print("Lowercase:", l)

# Print the length of the string
print(s, "is", len(s), "characters long")
print() # This adds an empty line to make the output look nicer

# Ask the user for a character to find inside the string
c = input("Please type a single character to search for: ")

# Find the first index of a character in a string
print("The first index of", c, "in", s, "is", s.index(c))
# Notice this *crashes* if c is not in s!  So maybe comment that out and this is better:
if c in s:
    print("The first index of", c, "in", s, "is", s.index(c))
else:
    print(c, "is not in", s)

# Count how many times a character appears in a string
print(c, "appears", s.count(c), "times in", s)

input("Please press enter to to continue")  # You can just use an input statement to pause, if you don't store input
print()

# Example list of integers
lst = [10, 20, 30, 40, 50, 60, 70]

# Append to the end of a list
print("lst contains", lst)
lst.append(80)
print("lst contains", lst, "after appending 80")

# Insert at an index
lst.insert(3, 35)
print("lst contains", lst, "after inserting 35 at index 3")

# Delete an element of a list
del(lst[0])
print("lst contains", lst, "after deleting the item at index 0")

# Cut out part of the list (just like strings!)
new_lst = lst[1:4]
print("new_lst contains", new_lst)
print()

# Using a for loop to print
print("Each element of lst, one at a time:")
for x in lst:
    print(x)
print()

# Using a for loop to make a new list based on a previous one
next_lst = []
for var in lst:
    next_lst.append(var * 3)
print("next_lst was built by multiplying lst by three and contains", next_lst)
print()

# Using a for loop to say where in the alphabet each letter is in a list of letters
alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
lst2 = ["A", "B", "C", "D", "E", "F", "Z"]
for char in lst2:
    print(char, "is at index", alpha.index(char), "in the alphabet")
print("Remember, we index starting at 0 so this makes total sense!")
print()

# Joining the characters in a list of characters into a string
st = "".join(lst2)
print("lst2 made into a string is this string: ", st)

# Making a string into a list of characters
alpha_list = list(alpha)
print("The alphabet made into a list looks like this: ", alpha_list)
print()

input("Please press enter to continue")
print()

# Using a for loop to count up instead of iterating over a list or string
# This involves using another complex data type, a range, which produces integers from 0 up to (but not including)
# the value passed to the range.  So this will make an increasing sequence of integers from 0 to 19.
print("Use the range command to generate numbers from 0 up to, but not including, the value passed")
for i in range(20):
    print(i)
print()

# You can also do this to access everything in a string by index
alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
for count in range(len(alpha)):
    print(count, alpha[count])
print()

# This gives us another way to do word art!
for z in range(len(alpha)):
    print(alpha[0:z+1])  # Why is there a +1 here?
print()

# Finally, you can also pass two arguments into the command to create a range; it will start at the first number,
# then count up to (but not inlcuding) the second.
for num in range(4, 10):
    print(num)