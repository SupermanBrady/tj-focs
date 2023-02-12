alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

def vigenere_encode(message, key):
    temp = []
    for i, c in enumerate(message):
        k_i = i % len(key)
        k_c = key[k_i]
        a = alpha.index(c)
        k = alpha.index(k_c)
        temp.append(alpha[(a + k) % 26])
    st = "".join(temp)
    return(st)

def vigenere_decode(message, key):
    temp = []
    for i, c in enumerate(message):
        k_i = i % len(key)
        k_c = key[k_i]
        a = alpha.index(c)
        k = alpha.index(k_c)
        temp.append(alpha[(a - k)])
    st = "".join(temp)
    return(st)

import sys
pt = sys.argv[1]
ct = sys.argv[2]
ky = sys.argv[3]
print(vigenere_encode(pt, ky))
print(vigenere_decode(ct, ky))