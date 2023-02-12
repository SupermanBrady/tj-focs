def caesar_encode(text, shift):
    alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    temp = []
    for letter in text:
        i = alpha.index(letter) 
        if i > 25 - shift:
            temp.append(alpha[(i + shift) % 26])
        else:
            temp.append(alpha[i + shift])
    st = "".join(temp)
    return st

def caesar_decode(text, shift):
    alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    temp = []
    for letter in text:
        i = alpha.index(letter) 
        if i < shift:
            temp.append(alpha[(26 + i) - shift])
        else:
            temp.append(alpha[i - shift])
    st = "".join(temp)
    return st

def caesar_crack(text):
    shiftcount = 0
    for shiftcount in range(26):
        print(caesar_decode(text, shiftcount))
        shiftcount = shiftcount + 1

def substitution_encode(text, code_alpha):
    alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    alpha2 = code_alpha
    temp = []
    for letter in text:
        i = alpha.index(letter)
        temp.append(alpha2[i])
    st = "".join(temp)
    return st

def substitution_decode(text, code_alpha):
    alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    alpha2 = code_alpha
    temp = []
    for letter in text:
        i = alpha2.index(letter)
        temp.append(alpha[i])
    st = "".join(temp)
    return st

import sys
pt = sys.argv[1]
a2 = sys.argv[2]
ct = sys.argv[3]
ct2 = sys.argv[4]
shift = int(sys.argv[5])
print(caesar_encode(pt, shift))
print(caesar_decode(ct, shift))
print(substitution_encode(pt, a2))
print(substitution_decode(ct2, a2))
print(caesar_crack(ct))