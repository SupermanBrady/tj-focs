import math

alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

def mod_inverse_helper(a, b):
    q, r = a//b, a%b
    if r == 1:
        return (1, -1 * q)
    u, v = mod_inverse_helper(b, r)
    return (v, -1 * q * v + u)

def mod_inverse(a, m):
    assert math.gcd(a, m) == 1, "You're trying to invert " + str(a) + " in mod " + str(m) + " and that doesn't work!"
    return mod_inverse_helper(m, a)[1] % m

def affine_encode(message, a, b):
    encode = []
    for letter in message:
        i = alpha.index(letter) 
        m = (a*i + b) % 26
        encode.append(alpha[m])
    est = "".join(encode)
    return est

def affine_decode(message, a, b):
    decode = []
    for letter in message:
        i = alpha.index(letter)
        a1 = mod_inverse(a, 26)
        m = (a1 * (i-b)) % 26
        decode.append(alpha[m])
    dst = "".join(decode)
    return dst

def convert_to_num(ngraph):
    numerical = []
    for i, letter in enumerate(ngraph):
        numerical.append(alpha.index(letter) * (26**i))
    return sum(numerical)

def convert_to_text(num, n):
    if n == 1:
        return alpha[num]
    else:
        x = alpha[num % 26]
        return x + convert_to_text(num // 26, n - 1)

def affine_n_encode(text, n, a, b):
    textlist = [] #a list of every letter in text
    ngraphs = [] #a list of all the ngraphs
    encnumbers = [] #the new numbers
    decgraphs = []
    for letter in text:
        textlist.append(letter)
    r = len(text) % n
    if r != 0:
        for i in range(n - r):
            textlist.append("X")
    for i in range(0, len(text), n):
        ngraphs.append(textlist[i : i + n])

    for ngraph in ngraphs:
        i = convert_to_num(ngraph)
        encnumbers.append((a*i + b) % 26**n)
    for num in encnumbers:
        decgraphs.append(convert_to_text(num, n))
    st = "".join(decgraphs)
    return st

def affine_n_decode(text, n, a, b):
    ngraphs = [] #a list of all the ngraphs
    decnumbers = [] #the new numbers
    decgraphs = []
    for i in range(0, len(text), n):
        ngraphs.append(text[i : i + n])
    for ngraph in ngraphs:
        i = convert_to_num(ngraph)
        a1 = mod_inverse(a, 26**n)
        decnumbers.append((a1 * (i-b)) % 26**n)
    for num in decnumbers:
        decgraphs.append(convert_to_text(num, n))
    st = "".join(decgraphs)
    return st

import sys
text, dec1, dec2 = sys.argv[1:4]
a, b, n, n_a, n_b = [int(x) for x in sys.argv[4:]]
print(affine_encode(text, a, b))
print(affine_decode(dec1, a, b))
print(affine_n_encode(text, n, n_a, n_b))
print(affine_n_decode(dec2, n, n_a, n_b))