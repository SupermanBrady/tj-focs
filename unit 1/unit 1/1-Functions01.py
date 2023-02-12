# One important fact about Python is that anything you write after one of these
# hashtag / pound sign symbols is TOTALLY IGNORED by Python!  We use this to
# write COMMENTS - writing intended to explain something in the program to a user
# or to someone editing the code.  Just like I'm doing now!

# In your assignment 01-02 you have instructions for what to do with these
# function definitions.
def malcolm(x):
  return 2*x + 1


def elaisa(x, y):
  return 2*x - y


def akash(a):
  if a > 0:
    return 1
  else:
    return -1


def rosa(x):
  return malcolm(x-1) * -1


def aashni(q):
  return akash(q) * q


def dion(n):
  if n > 10:
    return malcolm(n)
  else:
    return rosa(n)


def zhixing(a, b):
  return elaisa(aashni(a), rosa(b)) * 2


# If you want to write a test for one of them, you just write a line of code like this:


# Notice that these lines of code have no spaces in front of them.  If you put spaces
# in front, Python will think you're trying to write your code inside the previous
# function header!

# Feel free to delete these test cases, comment them out, or change them to suit your
# purposes!
