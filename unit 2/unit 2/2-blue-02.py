alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

eng_freq = [.0817, .0149, .0278, .0425, .1270, .0223, .0202, .0609, .0697, .0015, .0077, .0403, .0241, .0675, .0751,
            .0193, .0010, .0599, .0633, .0906, .0276, .0098, .0236, .0015, .0197, .0007]

eng_freq_squared = []
for freq in eng_freq:
    eng_freq_squared.append(freq * freq)
engIoC = sum(eng_freq_squared)
(engIoC)

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

def i_of_c(text):
    temp = []
    n = len(text)
    for letter in alpha:
        c = text.count(letter)
        ioc = (c / n) * ((c-1) / (n-1))
        temp.append(ioc)
    return(sum(temp))

def friedman_test(text):
    n = len(text)
    c = 1/26
    I = i_of_c(text)
    l = (n * (engIoC - c) / (I * (n - 1) + engIoC - n*c))
    return(l)

def gcd(x, y):
    if y == 0:
        return x
    else:
        return gcd(y, x % y)

def gcd_of_list(list):
    return gcd_list_helper(list, 0)

def gcd_list_helper(list, index):
    if index == len(list) - 1:
        return list[index]
    else:
        return gcd(list[index], gcd_list_helper(list, index + 1))

def find_plausible_gcd(int_list, minimum):
    i = int_list
    temp = []
    for int in i:
        if i.count(int) > minimum:
            temp.append(int)
    g = gcd_of_list(temp)
    if g > 1:
        return g
    else:
        find_plausible_gcd(temp, minimum + 1)

def kasiski_test(text):
    trilist = []
    distances = []
    for l in range(len(text) - 1):
        trigraph = text[l:l + 3]
        if trigraph in trilist:
            distances.append(l - trilist.index(trigraph))
            trilist.append(trigraph)
        else:
            trilist.append(trigraph)
    if gcd_of_list(distances) > 1:
        return gcd_of_list(distances)
    else:
        return find_plausible_gcd(distances, 2)

def make_cosets(text, n):
    coset = []
    for x in range(n):
        coset.append(text[x : len(text) : n])
    return coset

def find_total_difference(x, y):
    differences = []
    for c in range(len(x)):
        differences.append(abs(x[c] - y[c]))
    return sum(differences)

def find_likely_letter(coset):
    cosetdist = []
    for letter in alpha:
        cosetdist.append(coset.count(letter) / 26)
    total = []
    total.append(find_total_difference(cosetdist, eng_freq))
    for n in range(1, 26):
        cosetdist.append(cosetdist[0])
        del(cosetdist[0])
        total.append(find_total_difference(cosetdist, eng_freq))
    maybe = min(total)
    return alpha[total.index(maybe)]

def crack(ciphertext):
    print(friedman_test(ciphertext))
    print(kasiski_test(ciphertext))
    length = input("Please type the length of the keyword you want to try! ")
    make_cosets(ciphertext, int(length))
    for i, c in enumerate(make_cosets(ciphertext, int(length))):
        print(find_likely_letter(c))
    key = input("Please type the keyword you want to try! ")
    print(vigenere_decode(ciphertext, key))

import sys
crack(sys.argv[1])