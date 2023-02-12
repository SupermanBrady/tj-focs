# store, save and load board

def new_board():
    listoflists = []
    for i in range(6):
        line = []
        for i in range(7):
            line.append(".")
        listoflists.append(line)
    return listoflists


def load_board(txtfile):
    string = []
    listoflists = []
    with open(txtfile) as f:
        for line in f:
            n = line.strip()
            string.append(n)
        for i, c in enumerate(string):
            temp = []
            for j in range(len(string) + 1):
                bob = string[i]
                temp.append(bob[j])
            listoflists.append(temp)
    return listoflists


def save_board(lists):
    with open("savegame.txt", "w") as g:
        for list in lists:
            g.write("".join(list) + "\n")
    print("board saved successfully. see you next time!")

def whos_next(list):
    x = 0
    o = 0
    for row in list:
        x = x + row.count("X")
        o = o + row.count("O")
    if x == o:
        return "X"
    elif x > o:
        return "O"
    elif o > x:
        return "X"


#display the board
def display(list):
    bar = "============================="
    divider = " | "

    print(bar)

    for index, line in enumerate(list):
        # print the line number
        print("| ", end="")
        for num, char in enumerate(
                line):  #go through each character/slot in the line
            if num == len(line) - 1:  #if this is the last character/slot
                print(char + divider)  #prints with a newline
            else:
                print(char + divider,
                      end="")  # end="" makes it print without a newline

    print(bar)
    print("  0   1   2   3   4   5   6")


def text_console(x):
    print("-" * (len(x) + 1))
    print(x)
    print("-" * (len(x) + 1))


#Modify the board


def modify(board, player, move):  #MODIFY FOR RED 1
    column = int(move)
    for i in reversed(range(6)):
        if board[i][column] == ".":
            board[i][column] = player
            break
        if i == 0 and board[i][column] != ".":
            new_move = input("this column is full! please select another one: ")
            return modify(board, player, new_move)
    return board


def check_winner(board):  #CHECK FOR WINNER AFTER EACH TURN
    #make it return either "X", "O", or "NONE"
    for row in board:
        for i in range(len(row)):
            winner = horizontal_check_two(i, row, board)

            if winner == "X":
                return "X"
            elif winner == "O":
                return "O"


def diagonal_down_check(column, row, board):
    row_index = board.index(row)
    if column < 4 and row_index < 3:
        diagonal = []
        for i in range(4):
            diagonal.append(board[row_index + i][column + i])
        joined_diagonal = "".join(diagonal)

        if joined_diagonal == "XXXX":
            return "X"
        elif joined_diagonal == "OOOO":
            return "O"
        else:
            return "No winner yet"
    else:
        return "No winner yet"


def diagonal_up_check(column, row, board):
    row_index = board.index(row)
    if column < 4 and row_index > 3:
        diagonal = []
        for i in range(4):
            diagonal.append(board[row_index - i][column + i])
        joined_diagonal = "".join(diagonal)

        if joined_diagonal == "XXXX":
            return "X"
        elif joined_diagonal == "OOOO":
            return "O"
        else:
            return diagonal_down_check(column, row, board)
    else:
        return diagonal_down_check(column, row, board)


def vertical_check(column, row, board):
    row_index = board.index(row)
    if row_index < 3:
        vertical = []
        for i in range(4):
            vertical.append(board[row_index + i][column])
        joined_vertical = "".join(vertical)
        if joined_vertical == "OOOO":
            return "O"
        elif joined_vertical == "XXXX":
            return "X"
        else:
            return diagonal_up_check(column, row, board)
    else:
        return diagonal_up_check(column, row, board)


def horizontal_check_two(column, row, board):
    if column < 4:
        if "".join(row[column:column + 4]) == "XXXX":
            return "X"
        elif "".join(row[column:column + 4]) == "OOOO":
            return "O"
        else:
            return vertical_check(column, row, board)
    else:
        return vertical_check(column, row, board)


# play game
def play_game():
    x = input("Load savegame (L) or New game (N) ? ")
    if x == "L":
        board = load_board(input("File name? "))
    elif x == "N":
        board = new_board()
    else:
        print("read the instructions >:T")
        play_game()

    display(board)
    win_status = check_winner(board)
    if win_status == "O":
        text_console("O wins!")
        text_console("Would you like to (S) save or (Q) quit?")
        status = input("")
    elif win_status == "X":
        text_console("X wins!")
        text_console("Would you like to (S) save or (Q) quit?")
        status = input("")
    player = whos_next(board)
    text_console(player + " moves next.")
    text_console("Choose your next move or (S) to save or (Q) to quit.")
    text_console("To choose your next move, type column number.")
    status = input("")
    # ^we do this first so that we can know what 'status' is at the beginning of each while loop

    while not (status == "S" or status == "Q"):
        board = modify(board, player, status)
        display(board)

        win_status = check_winner(board)
        if win_status == "O":
            text_console("O wins!")
            text_console("Would you like to save (S) or quit without saving? (Q)")
            status = input("")
            break
        elif win_status == "X":
            text_console("X wins!")
            text_console("Would you like to save (S) or quit without saving? (Q)")
            status = input("")
            break
        player = whos_next(board)
        text_console(player + " moves next.")
        text_console("Choose your next move or (S) to save or (Q) to quit.")
        text_console("To choose your next move, type your column number.")
        status = input("")

    if status == "S":
      save_board(board)
    if status == "Q":
      print("thanks for playing! game ended successfully.")


play_game()