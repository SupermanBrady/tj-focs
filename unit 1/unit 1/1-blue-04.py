def guess(x, y, counter):
    tryThis = (x + y) // 2
    number = input("Is this your number: " + str(tryThis) + "\n correct / low / high ")
    if number == "correct": 
        print("I guessed your number! It took this many guesses:" + str(counter))
    elif number == "low":
        guess(tryThis + 1, y, counter + 1)
    elif number == "high":
        guess(x, tryThis - 1, counter + 1)

guess(0, 100, 1)