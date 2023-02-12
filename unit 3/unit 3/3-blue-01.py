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
  #file = input("Which file would you like to save to? ")
  with open("savegame.txt", "w") as g:
    for list in lists:
        g.write("".join(list) + "\n")

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

#list for each row
#append each charater in that row
#append each row to larger list

#display the board
def display(list):
  bar = "==============================="
  divider = " | "

  print(bar)

  for index, line in enumerate(list):
    # print the line number
    print(str(index) + divider, end="")
    for num, char in enumerate(line): #go through each character/slot in the line
      if num == len(line)-1: #if this is the last character/slot
        print(char+divider) #prints with a newline
      else: 
        print(char+divider, end="") # end="" makes it print without a newline

  print(bar)
  print("    0   1   2   3   4   5   6")

def text_console(x):
  print("-"*(len(x)+1))
  print(x)
  print("-"*(len(x)+1))
#Modify the board

def modify(board, player, move):
  row = int(move[0])
  column = int(move[3])
  if player == "X":
    board[row][column] = "X" # this replaces the item in the list with X
  else:
    board[row][column] = "O" # this does that but with O
  return board

# play game
def play_game():
  x = input("Load or New? ")
  if x == "Load":
    board = load_board(input("File name? "))
  elif x == "New":
    board = new_board()
  else:
    print("no work :(")
    quit()

  display(board)
  player = whos_next(board)
  text_console(player + " moves next.")
  text_console("Choose your next move or (S) to save or (Q) to quit.")
  text_console("To choose your next move, type your row and column number in the format r, c.")
  status = input("")
  # ^we do this first so that we can know what 'status' is at the beginning of each while loop

  while not (status == "S" or status == "Q"):
    board = modify(board, player, status)
    display(board)
    player = whos_next(board)
    text_console(player + " moves next.")
    text_console("Choose your next move or (S) to save or (Q) to quit.")
    text_console("To choose your next move, type your row and column number in the format r, c.")
    status = input("")
  
  if status == "S":
    save_board(board)

play_game()

# (red) make things fall

# determining if there is a winner every turn