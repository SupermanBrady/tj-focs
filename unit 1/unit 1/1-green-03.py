def bool_myst_A(x):
    if x % 2 == 0:
        return True
    elif x % 3 == 0:
        return True
    else:
        return False


def bool_myst_B(x):
    if x % 2 == 0:
        return True
    elif x > 10:
        return True
    else:
        return False


def bool_myst_C(x):
    if x % 3 == 0:
        return False
    else:
        return True


def bool_myst_D(x):
    if x <= 3:
        return True
    elif x >= 10:
        return True 
    else:
        return False


def bool_myst_E(x):
    if x % 3 == 0:
        return False
    elif x % 5 == 0:
        return False
    else:
        return True


def bool_myst_F(x):
    if x <= 4:
        return False
    elif x >= 10:
        return False 
    else:
        return True


def date_fashion(you, date):
  if you <= 2 or date <= 2:
    return 0
  elif you >= 8 or date >=8:
    return 2
  else: 
    return 1


def squirrel_play(temp, is_summer):
  if is_summer and temp >= 60 and temp <= 100:
    return True
  elif not is_summer and temp >= 60 and temp <= 90:
    return True
  else:
    return False


def caught_speeding(speed, is_birthday):
  if not is_birthday and speed <= 60:
    return 0
  elif not is_birthday and speed >= 61 and speed <= 80:
    return 1
  elif not is_birthday and speed >= 81:
    return 2
  elif is_birthday and speed <= 65:
    return 0
  elif is_birthday and speed >= 66 and speed <= 85:
    return 1
  elif is_birthday and speed >= 86:
    return 2


def sorta_sum(a, b):
  if 10 <= a + b and a + b <= 19:
    return 20
  else:
    return a + b


def alarm_clock(day, vacation):
  if day >= 1 and day <= 5 and not vacation:
    return "7:00"
  elif day >= 1 and day <= 5 and vacation:
    return "10:00"
  elif not vacation and (day == 6 or day == 0):
    return "10:00"
  elif vacation and (day == 6 or day == 0):
    return "off"


def love6(a, b):
  if a == 6 or b == 6:
    return True
  elif a + b == abs(6):
    return True
  elif a - b == abs(6) or b - a == abs(6):
    return True
  else:
    return False


def in1to10(n, outside_mode):
  if not outside_mode and (n >= 1 and n <= 10):
    return True
  elif outside_mode and (n <= 1 or n >= 10):
    return True
  else:
    return False


def near_ten(num):
  if num % (10) <= 2:
    return True
  elif num % (10) == 8:
    return True
  elif num % (10) == 9:
    return True
  else:
    return False
