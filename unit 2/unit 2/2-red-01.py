import sys 

alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

def c_sub(message):
    swap = ""
    while swap != "quit":
        print(message) 
        for letter in alpha:
            print(letter, message.count(letter))
        print("The most common letters in English are usually ETAOINSHRDLU, in that order.")
        swap = input("Type a pair of letters to swap, for example AB would swap A and B, or type 'quit': ")
        if len(swap) == 2:
            message = message.replace(swap[0], "~")
            message = message.replace(swap[1], "`")
            message = message.replace("~", swap[1])
            message = message.replace("`", swap[0])

c_sub(sys.argv[1])